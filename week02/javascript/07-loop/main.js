// 반복문 없는 코드
// 변수 number를 세번 출력, 1씩 증가하면서
let number = 0;

console.log("반복문 X");
console.log(number++);
console.log(number++);
console.log(number++);

console.log("반복문 O");
for (let number2 = 0; number2 < 3; number2++) {
  console.log(number2);
}

console.log("---------");
// 숫자를 0번 5까지 출력
for (let i = 0; i <= 5; i++) {
  console.log(i);
}
