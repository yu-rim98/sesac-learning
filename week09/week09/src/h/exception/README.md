## 1. 자바 예외(Exception) 전체 구조
* 자바의 모든 예외는 `Throwable`에서 시작한다.
```
Throwable
 ├─ Error         (개발자가 처리할 수 없음)
 └─ Exception
      ├─ Checked Exception (컴파일 시점 체크)
      └─ Unchecked Exception = RuntimeException (런타임 체크)
```

## 2. Error - 개발자가 신경 안 써도 됨
* `OutOfMemoryError`
* `StackOverflowError` (무한 재귀)
* 위와 같은 에러는 애플리케이션 레벨에서 복구가 불가능하기 때문에 별도로 예외 처리를 할 필요가 없다.

## 3. Unchecked Exception (Runtime Exception) - 예외 처리 선택

| 예외                               | 발생 이유        |
| -------------------------------- | ------------ |
| `NullPointerException`           | null 접근      |
| `ArrayIndexOutOfBoundsException` | 배열 범위 벗어남    |
| `ArithmeticException`            | 1/0과 같은 연산   |
| `NumberFormatException`          | "" -> int 변환 |
| `IllegalArgumentException`       | 잘못된 값 등      |
### 특징
* 예외 처리를 강제하지 않는다.
* 잘못된 코드나 입력에서 주로 발생한다.
* 개발자가 **조건문 등으로 사전에 방지하는 것이 주 방어책**

## 4. Checked Exception - 예외 처리 필수
* 파일, 네트워크, DB 등 **외부 자원**을 다룰 때 발생한다.
* 예시
```java
FileReader fr = new FileReader("a.txt");
```
* `FileNotFoundException`을 반드시 잡아야 함
* 해결 방법
    * 1. `try-catch`
    * 2. `throws`로 호출자에게 위임

## 5. try – catch – finally 기본 구조

```java
try {
    // 예외가 발생할 수 있는 코드
} catch (SpecificException e) {
    // 구체적인 예외 먼저 처리
} catch (Exception e) {
    // 마지막에 가장 넓은 예외 (포괄)
} finally {
    // 예외 발생 여부와 무관하게 무조건 실행
}
```
