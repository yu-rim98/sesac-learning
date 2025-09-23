// Promise 생성자 함수를 직접 사용하는 방법
// new Promise() : 생성자 함수
// (resolve, reject) => {} : 비동기 작업을 수행하고, 결과를 반환하는 함수

const promise = new Promise((resolve, reject) => {
  // 비동기 작업 흉내
  setTimeout(() => {
    const random = Math.random(); // 랜덤 숫자 생성

    if (random > 0.5) {
      resolve("숫자가 0.5 이상! 성공"); // 성공 시 promise의 콜백 함수로 반환
    } else {
      reject("숫자가 0.5 이하! 실패"); // 실패 시 promise의 콜백 함수로 반환
    }
  }, 1000);
});

// Promise 상태
// 1. Pending (대기) : 비동기 작업이 아직 끝나지 않은 초기 상태
// 2. Fulfilled (이행/성공) : 비동기 작업이 성공적으로 완료된 상태
// 3. Rejected (거절/실패) : 비동기 작업이 실패한 상태
// 예시) 네트워크 통신의 성공과 실패

// 성공 상태일 때 수행할 처리 메서드 : Promise.then(콜백함수)
// 실패 상태일 때 수행할 처리 메서드 : Promise.catch(콜백함수)
// 성공/실패와 관계없이 항상 수행할 처리 메서드 : Promise.catch(콜백함수)

promise
  .then((result) => {
    // resolve 함수의 반환값을 매개변수로 받는다.
    console.log(`성공 : ${result}`);
  })
  .catch((error) => {
    // reject 함수의 반환값을 매개변수로 받는다.
    console.log(`실패 : ${error}`);
  });
// .finally(() => {
//   console.log("성공/실패 여부와 관계 없이 항상 실행");
// });
