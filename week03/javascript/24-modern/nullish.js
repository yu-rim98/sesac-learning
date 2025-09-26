let value1; // undefined, 변수를 선언만 하고 값을 할당하지 않음
let value2 = null; // null, 변수에 null을 할당함

console.log(value1);
console.log(value2);

// nullish
// 접근하려는 값이 null 또는 undefined일 때 기본값(default value)을 적용
// null or undefined ?? 기본 값 = null이거나 undefined이면 "기본값"을 사용

let value3 = value2 ?? "null 기본값"; // value2는 null이므로 "null 기본값" 저장
console.log(value3);

let value4 = value1 ?? "undefined 기본값";
console.log(value4);
