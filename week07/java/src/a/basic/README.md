## 1. Java 기본 문법

### 1.1. 변수 (Variable)
- **선언 및 초기화**: `int age = 20;`
- **기본 데이터 타입**:
  - 정수형: `byte`, `short`, `int`, `long`
  - 실수형: `float`, `double`
  - 문자형: `char`
  - 논리형: `boolean`
- **타입 추론**: `var` 키워드를 사용하여 타입을 추론할 수 있습니다. (Java 10 이상)
  ```java
  var age = 20; // int로 추론
  ```
- **참조형 타입**: `String`, `null` (참조형에만 대입 가능)

### 1.2. 연산자 (Operator)
- **산술 연산자**: `+`, `-`, `*`, `/`, `%`
- **증감 연산자**: `++`, `--` (전위/후위)
- **대입 연산자**: `+=`, `-=`, `*=`, `/=`
- **문자열 비교**:
  - `==`: 참조(주소) 비교
  - `.equals()`: 내용 비교
- **논리 연산자**: `&&` (AND), `||` (OR), `!` (NOT)
- **삼항 연산자**: `(조건) ? 값1 : 값2`

### 1.3. 조건문 (IfStatement)
- **`if`, `if-else`, `if-else-if`**: 조건을 확인하여 코드 블록을 실행합니다.
  ```java
  if (score >= 90) {
      System.out.println("A");
  } else if (score >= 80) {
      System.out.println("B");
  } else {
      System.out.println("C");
  }
  ```
- **`switch` 문**: 여러 경우에 따라 다른 코드를 실행합니다.
  ```java
  String season = switch (month) {
      case 3, 4, 5 -> "봄";
      case 6, 7, 8 -> "여름";
      default -> "잘못된 월";
  };
  ```

### 1.4. 반복문 (For)
- **`for` 루프**: 특정 횟수만큼 코드를 반복합니다.
  ```java
  for (int i = 0; i < 5; i++) {
      System.out.println(i);
  }
  ```
- **향상된 `for` 루프**: 배열이나 컬렉션의 모든 요소를 순회합니다.
  ```java
  int[] numbers = {1, 2, 3};
  for (int number : numbers) {
      System.out.println(number);
  }
  ```
- **`break`**: 반복문을 즉시 중단합니다.
- **`continue`**: 현재 반복을 건너뛰고 다음 반복을 시작합니다.

### 1.5. 배열 (Array)
- **선언 및 초기화**:
  ```java
  int[] numbers = new int[5]; // 크기 지정
  String[] names = {"kim", "lee", "park"}; // 값으로 초기화
  ```
- **다차원 배열**:
  ```java
  int[][] matrix = {
      {1, 2, 3},
      {4, 5, 6}
  };
  ```
- **`Arrays` 유틸리티**:
  - `Arrays.toString()`: 배열 요소를 문자열로 출력
  - `Arrays.sort()`: 배열 정렬
  - `Arrays.binarySearch()`: 이진 검색 (정렬된 배열에서 사용)
  - `Arrays.copyOf()`: 배열 복사
  - `Arrays.equals()`: 배열 내용 비교

