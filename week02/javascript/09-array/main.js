// 배열 생성
// 대괄호 [] 사용

// 빈 배열 데이터를 변수 emptyArray 할당
let emptyArray = [];

// 1을 저장한 배열 데이터를 변수 oneArray 할당
let oneArray = [1];

// 원소를 여러개 저장하기 위해서는 , 로 구분한다.
// 1, 2, 3, 4 를 저장한 배열 데이터를 변수 manyArray 할당
let manyArray = [1, 2, 3, 4];

// 배열의 인덱스
// 배열 내부 원소의 위치 번호
// 0부터 시작한다.
// 마지막은 배일 길이 -1

// 배열 원소 접근
// 배열[인덱스]

// 변수 array2에 [1, "2", 3]을 저장한 배열을 할당한다.
let array2 = [1, "2", 3];

// 첫번째 위치의 원소에 접근한다.
array2[0];

// 첫번째 원소를 -1로 재할당
array2[0] = -1;
console.log(array2[0]);

// 원소의 추가와 제거
// 배열데이터.push(데이터) : 추가

// 변수 array3을 선언하고, 배열 데이터[0] 을 할당
let array3 = [0];

// 배열 array3에 1을 원소로 추가
array3.push(1);
console.log(array3);

// 배열데이터.pop() : 제거 (마지막 요소)
let number = array3.pop(); // array3의 마지막 요소를 가져온다.
console.log(array3);
console.log(number);

// 배열 길이 : .length

let array4 = [1, 2, 3];
console.log(array4.length);

// for 만복문을 활용해 01ㅜ터 배열 길이 -1까지 반복
for (let i = 0; i <= array4.length; i++) {
  console.log(i);
}

// for...of 반복문
// 인덱스(위치번호) 활용 X
// 배열에서 직접 원소를 꺼내옴
for (let element of array4) {
  console.log(element);
}
