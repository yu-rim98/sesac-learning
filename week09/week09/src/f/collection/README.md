# 컬렉션 프레임워크(JCF, Java Collections Framework)
> 데이터를 효율적으로 저장하고 관리(추가, 삭제, 검색, 정렬)할 수 있도록 자바에서 미리 만들어둔 **데이터 보관함(자료구조)의 모음**이다.   
> 즉, 데이터를 저장하는 자료 구조와 데이터를 처리하는 알고리즘을 구조화하여 클래스로 구현해 놓은 것이다.

## 컬렉션 프레임워크 주요 인터페이스 - `List`, `Set`, `Map`
> 컬렉션 프레임워크는 인터페이스를 사용해 구현된다.

### 1. `List` - 순서가 있는 목록
* 특징 : 데이터의 **순서가 유지**되고, **중복된 데이터를 허용한다.**
* 구현체 : `ArrayList`, `LinkedList`

### 2. `Set` - 순서가 없는 주머니
* 특징 : 데이터의 **순서가 보장되지 않고**, **중복된 데이터를 허용하지 않는다.**
* 구현체 : `HashSet`, `TreeSet`

### 3. `Map` - 키-값 사전
* 특징 : Key(키)와 Value(값)가 **1:1로 짝을 이뤄 저장된다.**
    * Key는 중복될 수 없음
* 구현체 : `HashMap`, `TreeMap`
* `Map`은 `List`나 `Set`이 상속받는 `Collection` 인터페이스와는 별개의 인터페이스이지만 데이터를 다루는 묶음이기 때문에 함께 분류됨

---
## 주요 구현체
### 1. `ArrayList`
* 특징 : 가장 많이 쓰이는 리스트로 내부적으로 '배열'을 사용해 **데이터 검색(조회)이 매우 빠르다.**
* 단점 : 중간에 데이터를 추가하거나 삭제할 때 뒤에 있는 데이터들을 전부 한칸씩 당기거나 밀어야 해서 느리다.
```java
public static void main(String[] args) {  
    // String을 담을 수 있는 ArrayList    
    ArrayList<String> fruits = new ArrayList<>();  
  
    fruits.add("사과");  
    fruits.add("바나나");  
    fruits.add("딸기");  
    fruits.add("사과"); // 중복 허용  
  
    System.out.println(fruits);  
  
    // 2번 인덱스 삭제  
    // fruits.remove(2);  
    fruits.remove("딸기");  
    System.out.println(fruits);  
}
```
* 2번 인덱스 삭제 시 3번 인덱스가 앞으로 당겨져야 함
> List = 순서 유지 + 중복 허용 + 인덱스 접근

### 2. `HashSet`
* 특징 : 순서 상관없이 **중복을 제거할 때** 가장 많이 쓴다. `HashMap`을 기반으로 만들어져서 검색 / 추가 / 삭제 속도가 매우 빠르다.
```java
public static void main(String[] args) {  
    Set<String> uniqueColors = new HashSet<>();  
  
    uniqueColors.add("빨간색");  
    uniqueColors.add("파란색");  
    uniqueColors.add("초록색");  
    uniqueColors.add("빨간색"); // 중복은 무시됨  
  
    System.out.println(uniqueColors); // [파란색, 초록색, 빨간색] 순서 보장 X  
}
```
* 사용 예시 : 사용자가 입력한 값에서 중복을 자동으로 제거하고 싶을 때, 로그 기록에서 중복된 IP 제거해야 할 때
> Set = 순서 없음 + 중복 제거 + 검색 빠름

### 3. `HashMap`
* 특징 : Key-Value 쌍을 저장할 때 가장 보편적으로 쓰인다. Key를 이용해 Value를 매우 빠르게 찾아낼 수 있다.
```java
public static void main(String[] args) {  
    Map<String, Integer> userAges = new HashMap<>();  
  
    userAges.put("유관순", 20);  
    userAges.put("홍길동", 30);  
    userAges.put("이순신", 34);  
  
    int hongAge = userAges.get("홍길동");  
    System.out.println(hongAge);  
}
```

---
### 언제 어떤 컬렉션을 사용할까
1. 순서가 중요하고 중복이 있어도 될 때 -> `ArrayList`
2. 중복을 제거해야 하고 순서는 필요 없을 때 -> `HashSet`
3. 이름이나 ID처럼 고유한 key로 값을 관리해야 할 때 -> `HashMap`