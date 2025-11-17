## 1. 스트림(Stream) 기본 개념
* 스트림은 데이터 컬렉션(list, set 등)을 함수형으로 처리하는 API이다.
* 데이터를 순차적으로 흘려보내면서(filter, map, sorted 등) 파이프라인 형태로 처리하는 방식

### 스트림을 사용하면 좋은 점
#### 1. 선언형 코드 - 무엇을 할지만 적음
```java
list.stream().filter(n -> n % 2 == 0)
```
* for문을 돌면서 조건 체크 등의 **어떻게**가 없음
* 짝수만 추출하라는 목적만 표현 함

#### 2. 체이닝(중간 연산 -> 최종 연산)
```java
stream.filter().map().sorted().collect()
```

#### 3. 병렬 처리 parallelStream() 지원
* 멀티코어 사용 가능

#### 4. 불변성
* 스트림은 원본 컬렉션을 절대 변경하지 않음
* 항상 새로운 stream -> 새로운 결과 생성

---
## 2. 스트림 처리 단계 구조

```
Stream 생성 -> 중간 연산(n개) -> 최종 연산(1개)
```

* 예시
```java
int sum = list.stream() // 스트림 생성
		.filter(n -> n % 2 == 0) // 중간 연산
		.map(n -> n * n) // 중간 연산
		.reduce(0, Integer::sum); // 최종 연산
```

---
## 3. 스트림 핵심 중간 연산
### filter() - 조건 걸러내기
```java
.filter(n -> n % 2 == 0)
```

### map() - 값 변환
```java
.map(n -> n * n)
.map(String::toUpperCase)
```

### sorted() - 정렬
```java
.sorted() // 기본 정렬
.sorted(comp) // 커스텀 정렬
```

### distinct() - 중복 제거
```java
.distinct()
```

### limit(), skip() - 페이징처럼 사용
```java
.limit(5) // 처음 5개
.skip(3) // 처음 3개 버림
```

### peek() - 디버깅용
```java
.peek(System.out::println)
```

---
## 4. 스트림 핵심 최종 연산
### collect() - 리스트로 변환
```java
.collect(Collectors.toList());
```

### reduce() - 누적 연산
```java
.reduce(0, Integer::sum);
.reduce(1, (a,b) -> a*b); // 곱
```

### forEach() - 요소 순회
```java
.forEach(System.out::println);
```

### anyMatch(), allMatch(), noneMatch() - 논리 검사
```java
.anyMatch(n -> n > 10)
```

### count()
```java
.count();
```

---
## 5. 예제
### 기존 for문
```java
int sum = 0;
for (Integer item : list) {
	if (item % 2 == 0) {
		sum += item * item;
	}
}
```

### 스트림 방식
```java
int sum = list.stream()
		.filter(n -> n % 2 == 0)
		.map(n -> n * n)
		.reduce(0, Integer::sum);
```

### 스트림 장점
* 반복문 제거
* 조건식/변환식 분리 -> 가독성 증가
* 병렬 처리 가능
* 체이닝 연산 가능

---
## 6. 스트림 추가 개념
### 1) 스트림은 1회용이다.
```java
Stream<Integer> s = list.stream();
s.filter(...);
s.map(...); // 이미 사용됐기 때문에 에러남
```

### 2) 지연(lazy) 연산
* 중간 연산(map, filter)은 실행되지 않고, 최종 연산이 호출되는 순간에 실행된다.
    * 불필요한 계산 최소화
    * 성능 최적화

### 3) 병렬 스트림

### 4) 스트림은 원본을 변경하지 않는다.
* List 자체는 절대 변화 없음

---
## 자주 쓰이는 스트림 패턴
### 1) 리스트 필터링
```java
List<Integer> evens = list.stream()
		.filter(n -> n % 2 == 0)
		.toList();
```

### 2) 객체 리스트 -> 특정 필드만 추출
```java
List<String> names = users.stream()
		.map(User::getName)
		.toList();
```
