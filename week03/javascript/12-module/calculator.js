// 가장 기본적인 형태의 하나 내보내기(default export) 방식
// 여러 개의 함수(메서드)가 정의된 객체를 생성해서 내보내기

// 객체 : 중괄호로 표현되는 속성의 모음
const calObject = {
  // 함수 선언식 (이름 있는 함수)
  add: function add(n1, n2) {
    return n1 + n2;
  },

  // 화살표 함수
  substract: (n1, n2) => {
    return n1 - n2;
  },

  // 함수 표현식
  multiply: function (n1, n2) {
    return n1 * n2;
  },
};

export default calObject;
