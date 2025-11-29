# `Either` 회고
## 프로젝트 개요
* `Either` 프로젝트는 **Spring MVC**, **Spring Data JPA**, **Thymeleaf**를 사용해 사용자가 질문을 등록하고 등록된 질문에 투표할 수 있는 간단한 웹 애플리케이션을 구현하는 것을 목표로 진행했다.
* 핵심 기능으로는 질문 등록, 질문 목록 조회, 질문 상세 페이지 및 투표 기능이 포함된다.
* 해당 과정을 통해 데이터베이스 관계를 자바 클래스로 연결, Spring Boot 기반 웹 개발의 전체적인 흐름을 경험할 수 있었다.

## 좋았던 점
* 요구사항의 핵심 기능을 모두 구현했다는 것
* Controller, Service, Repository의 기본 구조를 갖추고 Spring Data JPA를 이용해 데이터베이스와 상호작용할 수 있도록 구현한 것
* Spring을 활용해 기본기를 다질 수 있는 경험이었음

## 아쉬웠던 점
1. 계층 간의 강한 결합
    * 데이터베이스와 직접 매핑되는 Entity 객체를 컨트롤러와 뷰(타임리프)까지 그대로 전달해 사용한 것
    * 이로 인해 모든 계층이 데이터베이스의 테이블 구조에 강하게 의존하게 된다.
    * 만약 데이터베이스 스키마가 변경되면 Repository뿐만 아니라 Service, Controller, 화면 코드까지 수정해야 하는 연쇄적인 변경이 발생하게 된다.

2. DTO(Data Transfer Object)의 부재
    * 위 문제와 직접 연결되는 부분으로 계층 간 데이터 전송을 위한 DTO의 필요성을 느꼈다.
    * Entity를 그대로 사용하다보니 화면에 필요하지 않은 데이터까지 노출될 수 있고, 화면을 위해 가공된 데이터를 Entity에 추가될 수 있기 때문에 객체의 책임이 모호해질 수 있다는 것을 느꼈다.

3. Controller의 과한 책임
    * `QuestionController`에서 투표 수를 계산하는 등 비즈니스 로직 직접 처리해 controller가 무거워 지고, 코드의 재사용성을 떨어뜨렸다.
    * Controller는 사용자의 HTTP 요청을 받아 적절한 Service를 호출하고 그 결과를 View에 전달하는 역할에 더 집중해야 한다는 것을 다시 한번 느꼈다.

4. 빈약한 도메인 모델(Anemic Domain Model) - 안티 패턴
    * `Question`과 `Answer` 엔티티가 데이터 필드와 `Getter/Setter`만 가진 단순한 데이터 컨테이너 역할만 하고 있었다.
    * `@Setter`를 제한 없이 사용하면서 객체의 상태가 어디서든 쉽게 변경될 수 있는 구조가 되었다.
    * 객체가 스스로의 상태와 행위를 책임지는 '풍부한 도메인 모델'로 설계했다면 데이터의 일관성을 지키고 비즈니스 로직을 더 명확하게 표현할 수 있었을 것이다.


# 리팩토링 회고

### 1. DTO(Data Transfer Object)의 부재 해결
>HTTP 요청 및 응답에 Entity를 직접 사용하던 부분을 ReqDto와 ResDto에 위임

#### 엔티티를 컨트롤러에서 직접 사용했을 때 문제점
1. 내부 구현 노출
    * 데이터베이스와 직접 매핑된 엔티티의 구조가 API 응답에 그대로 노출된다.
    * 이는 보안상 취약할 수 있고, 향후 엔티티가 변경됐을 때 API 구조 자체가 변경되는 강한 결합을 만든다.
2. 불필요한 데이터 전송
    * 엔티티의 모든 필드가 외부에 노출될 수 있다.
        * 예를 들어 목록 조회 시에는 질문의 ID와 제목만 필요한데 모든 필드가 전송되는 비효율이 발생한다.
3. 의도치 않은 변경
    * 엔티티가 영속성 컨텍스트에 의해 관리될 경우 의도치 않게 상태가 변경(더티 체킹)되어 데이터베이스에 반영될 위험이 있다.
#### 최종 해결
* DTO 패턴을 도입해 요청과 응답을 위한 객체를 별도로 정의했다.
    * `QuestionReqDto`, `AnswerReqDto` : 클라이언트의 요청을 받는데 사용
    * `QuestionResDto`, `QuestionDetailResDto`, `AnswerResDto` : 클라이언트에게 응답을 보내는데 사용
> 컨트롤러는 DTO를 통해 데이터를 받고, 서비스 계층은 DTO를 엔티티로 변환해 비즈니스 로직을 처리한다. 그 결과를 다시 DTO로 변환해 컨트롤러에 반환한다.

#### 클린 코드 관점에서의 이점
1. 단일 책임 원칙 (SRP) : 엔티티는 데이터베이스와의 매핑 및 영속성, DTO는 계층 간 데이터 전송, 서비스는 비즈니스 로직 처리라는 각자의 책임에만 집중하게 되었다.
2. API 명세의 명확화 : DTO는 DTO 그 자체로 API의 명세가 된다. `QuestionDetailResDto`만 봐도 상세 조회 API가 어떤 데이터를 반환하는지 명확히 알 수 있다.

#### 고민 : ReqDto -> Entity 변환 로직을 어디에 둘까
* 처음에는 엔티티 내부에 정적 팩토리 메서드를 만들어서 DTO 자체를 받아서 private 생성자를 호출하는 방식을 선택했지만 언젠가 DTO는 변경이 잦기 때문에 엔티티가 DTO를 의존하면 안 된다는 말이 기억나서 고민하기 시작 (엔티티는 순수해야 한다는 점 때문)

#### 엔티티의 순수성?
* 엔티티는 핵심 비즈니스 로직 (도메인 모델)이다. (데이터베이스 테이블과 직접 매핑되고 비즈니스 본질을 담고 있음)
* 반면에 DTO는 화면에 출력하는 용도인 껍데기이다. 즉, 프론트엔드의 요구사항에 따라 수시로 변경될 수 있다. (ex : 이메일만 출력하겠다 -> 닉네임도 같이 출력하게 이메일, 닉네임을 줘라)
* 위 상황에서 만약 엔티티 내부에 DTO 변환 로직이 존재한다면 프론트엔드의 요청에 따라 DTO 형식을 변경해야 하면 DTO 파일 + 엔티티 파일 모두 수정해야 한다.
* 결국 유지보수가 어려워지기 때문에 엔티티는 DTO를 의존하지 않는 것이 좋다고 판단했다.

```java
@Getter  
@Setter  
@NoArgsConstructor  
public class QuestionReqDto {  
  
    private String title;  
    private String optionA;  
    private String optionB;  
  
    public Question toEntity() {  
        return new Question(this.title, this.optionA, this.optionB);  
    }  
}

@Transactional  
public Question createQuestion(QuestionReqDto questionReqDto) {  
    validationQuestion(questionReqDto);  
  
    return questionRepository.save(questionReqDto.toEntity());  
}
```

> 현재 프로젝트에서는 유효성 검사를 서비스 내의 별도 메서드에서 처리했는데 추후 팀 프로젝트를 한다면 그때는 스프링 부트에서 제공되는 Validation을 활용할 수 있을 것 같다.
---
## 2. 서비스 로직 최적화 - 선택지(A/B)에 대한 답변 수 로직

### 1. 첫번째 리팩토링 - DTO의 정적 팩토리 메서드(of) 내에서 처리

```java
// QuestionDetailResDto
public static QuestionDetailResDto of(Question question, List<Answer> answers) {  
    int TotalCountA = 0;  
    int TotalCountB = 0;  
  
    List<AnswerResDto> answerResDtos = new ArrayList<>();  
  
    for (Answer answer : answers) {  
        answerResDtos.add(AnswerResDto.toDto(answer));  
  
        if ("A".equals(answer.getAnswerText())) {  
            TotalCountA++;  
        } else if ("B".equals(answer.getAnswerText())) {  
            TotalCountB++;  
        }  
    }  
  
    return QuestionDetailResDto.builder()  
        .id(question.getId())  
        .title(question.getTitle())  
        .optionA(question.getOptionA())  
        .optionB(question.getOptionB())  
        .countA(TotalCountA)  
        .countB(TotalCountB)  
        .answers(answerResDtos)  
        .build();  
}
```

#### 구조 개선에 대한 고민
* DTO가 계산 로직까지 갖는 것이 **데이터 전송**이라는 핵심 역할을 벗어난다는 생각을 했고, 처음에는 계산 로직을 Question 엔티티 내부의 메서드(`getCountA()`)에 둘까 고민했다.
* 하지만 엔티티 메서드로 분리할 경우 답변 목록을 순회하면서 `getCountA()`, `getCountB()`, `AnswerResDto` 변환을 각각 수행하게 되어 하나의 목록을 총 3번 순회해야 하는 비효율이 발생할 것 같았다.
* 그래서 해당 로직은 서비스 계층(`QuestionService`)에서 처리하는 것이 가장 적합하다고 결론 내렸다.

> 현재는 데이터 규모가 작아서 애플리케이션에서 한번의 루프로 처리해 DB 접근 횟수를 줄이는 방식으로 진행했지만, 대용량 데이터를 처리해야 한다면 DB에서 `count`와 `group by`를 사용해 조회하는 방식으로 개선할 수 있을 것 같다.

#### 최종 해결
* `QuestionService`의 `getQuestionDetail()` 메서드 내에서 답변 목록을 한번만 순회해 `countA`, `countB` 계산과 `AnswerResDto`로 변환을 동시에 처리했다.
* `QuestionDetailResDto`는 계산 로직이 제거되고 단순히 응답 데이터만 갖게 되었다.

#### 클린 코드 관점에서의 이점
1. 성능과 구조의 조화 : 관심사 분리 원칙을 지키면서도(DTO는 데이터만, 서비스는 로직만) 불필요한 반복을 제거해 성능을 유지했다.
2. 불변성 : 응답 DTO를 불변 객체로 만들어 생성된 이후 상태가 변하지 않았음을 보장한다. 이는 데이터의 일관성을 유지하면서 예측 가능한 코드를 만드는데 도움이 된다.

---
## 3. 결론 및 느낀점
* 이번 리팩토링은 단순히 코드를 정리하는 것을 넘어서 각 계층의 역할과 책임을 명확히 고민하는 계기가 되었다.
* 엔티티와 DTO를 분리하는 것은 선택이 아니라 필수적인 설계 원칙임을 다시 한번 깨달을 수 있었다.