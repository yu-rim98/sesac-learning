// 논리연산자
// 논리형(불리언형)을 기반으로한 연산자

const trueData = true;
const falseDate = false;

// && (AND)
// 2개의 논리형 데이터가 참일 때 참을 반환, 한개라도 거짓이면 거짓을 반환
console.log("&& 연산자");
console.log(`true && true -> ${trueData && trueData}`); // 템플릿 리터럴에 표현식 사용 가능 (표현식 : 평가 시 어떤 값을 생성하는 코드 조각)
console.log(`flase && true -> ${falseDate && trueData}`);
console.log(`false && flase -> ${falseDate && falseDate}`);

// || (OR)
// 2개의 논리형 데이터 중 하나라도 참이면 참을 반환한다. 둘 다 거짓이면 거짓을 반환
console.log("|| 연산자");
console.log(`true || false -> ${trueData || falseDate}`);
console.log(`false || false -> ${falseDate || falseDate}`);

// ! (NOT)
// 논리형 데이터가 거짓이면 참을 반환, 논리형 데이터가 참이면 거짓을 반환 (뒤집음)
// 1개의 논리형 데이터만 필요
console.log("! 연산자");
console.log(`!true -> ${!trueData}`);
console.log(`!false -> ${!falseDate}`);
