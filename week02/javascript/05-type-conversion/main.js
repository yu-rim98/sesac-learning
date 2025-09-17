// 형변환
// 명시적 형변환 : 개발자가 직접
// 암시적 형변환 : JS 엔진 (번역기)이 자동으로

// 문자열로 명시적 변환
// String () 함수
// 함수 : 프로그래밍 언어의 특정 기능을을 수행하는 도구

// String(데이터) / String(변수)
console.log(String(123)); // 숫자형 -> 문자형
console.log(String(123) === "123");

console.log(String(true));
console.log(String(undefined));
console.log(String(null));

//숫자형 명시적 형변환
// Number() 함수 : 숫자형으로 변환하는 도구
// Number(데이터) / Number(변수)

// 문자열 "123" -> 숫자형 변환 코드
console.log(Number("123") === 123);

// 숫자 형태가 아닌 문자열을 형변한하려면
console.log(Number("1a2b")); // Nan (Not a Number);

// 불리언 명시적 형 변환
// 불리던 데이터 : 참 . 거짓
// Boolean() 함수 : 불리언으로 형변환하는 도구
