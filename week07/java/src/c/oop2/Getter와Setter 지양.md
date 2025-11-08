## 1. Getter와 Setter를 지양해야 하는 이유
### 1. 캡슐화(Encapsulation) 약화
* 객체의 내부 상태를 외부에서 직접 접근(get)하거나 변경(set)하면 객체의 자율성이 깨진다.
    * 즉, 객체가 단순한 **데이터 구조체**가 되어버림
* 외부에 작성된 코드가 객체 내부 로직을 제어하게 되므로 버그 발생 가능성이 증가한다.
```java
// 잘못된 예 : 외부에서 로직 자체를 정함
account.setBalance(account.getBalance() - 10000);

// 올바른 예 : 값만 주고 내부 로직은 상관하지 않음
account.withdraw(10000);
```
* 객체는 **데이터를 주는 존재**가 아니라 **행동하는 존재**여야 한다.

### 2. 응집도(Cohesion) 저하
* 데이터와 관련된 로직이 객체 내부가 아니라 외부 서비스로 흩어진다.
* 비즈니스 로직이 변경되면 여러 클래스의 코드들(로직 적용하는 코드들)도 수정이 되어야 함 -> 유지보수가 어려워짐
* 데이터와 그 데이터를 다루는 로직이 한 곳에 있으면 응집도가 높아지고 로직이 변경됐을 때 비즈니스 로직을 가지는 클래스에서만 수정하면 된다.

### 3. 불변성(Immutability) 훼손
* `setter`는 객체의 상태를 언제든 변경할 수 있게 하기 때문에 스레드 안정성(Thread-safety), 테스트 안정성을 해친다.
* 도메인객체는 가능하다면 **불변 객체(Immutable Object)**로 설계해야 한다.

### 4. 빈약한 도메인 모델(Anemic Domain Model) 유발
* Getter / Setter만 있는 클래스는 진짜 객체가 아니라 단순한 데이터 덩어리이다.
* 비즈니스 로직이 도메인 객체가 아니라 서비스 계층으로 쏠리게 된다.


## 2. 사용 여부 정리

| 구분       | 사용 여부     | 이유                          |
| -------- | --------- | --------------------------- |
| DTO / VO | 사용 가능     | 데이터 전달, 직렬화 목적의 객체이기 때문     |
| 도메인 객체   | 최소화       | 행동 중심 메서드로 대체하는 것이 좋음       |
| 불변 객체    | setter 제거 | 생성자 혹은 Builder로 초기화하는 것이 좋음 |

## 3. 대안 설계 원칙
### Tell, Don't Ask 원칙
"객체에게 데이터를 달라고(get) 하지 말고, 행동을 시켜라(tell)"
* 즉, 객체가 스스로 상태를 관리하고 행동하도록 설계해야 한다.

### 명령형 이름으로 행동 정의 (메서드명)
`setName` -> `rename`
`setBalance` -> `deposit / withdraw`
`setStatus` -> `activate / deactivate`
* 메서드 이름이 도메인 의미를 표현하도록 한다.

## 참고 문헌 / 자료
|자료|내용 요약|링크|
|---|---|---|
|**《객체지향의 사실과 오해》 (조영호)**|“객체는 상태를 외부에 노출하지 않고, 행동으로만 소통해야 한다.”|-|
|**《Effective Java 3/E》 (Joshua Bloch)**|Item 16: "필드에 접근자를 제공하되, 필요한 경우에만 신중히 사용하라."|-|
|**Martin Fowler - Anemic Domain Model**|getter/setter만 가진 객체는 진짜 객체가 아니라고 지적|[martinfowler.com/bliki/AnemicDomainModel.html](https://martinfowler.com/bliki/AnemicDomainModel.html)|
|**Martin Fowler - Tell Don’t Ask**|“객체에게 시켜라, 묻지 마라” 원칙 정리|[martinfowler.com/bliki/TellDontAsk.html](https://martinfowler.com/bliki/TellDontAsk.html)|
