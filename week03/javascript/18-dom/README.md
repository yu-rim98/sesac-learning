# DOM(Document Object Model)
> HTML은 정적인 문서지만, 브라우저는 이를 **트리 구조의 객체(DOM)** 로 변환하여 자바스크립트가 조작할 수 있도록 한다.

## HTML은 단순한 정적 문서이다.
> 제목, 본문 등의 정보가 담긴 텍스트 기반의 구조 문서일뿐이다.

## 브라우저는 HTML을 읽고 DOM 구조를 생성한다.
> HTML을 트리(Tree) 형태의 객체 구조로 변환하며 해당 구조를 **Document Object Model(DOM)** 이라고 한다.

## 자바스크립트는 DOM을 이용해 조작을 수행한다.
> `document.getElementById`, `querySelector` 등의 메서드로 HTML 요소를 선택할 수 있으며 내용이나 스타일을 변경하거나 요소 추가/삭제 등의 다양한 조작이 가능하다.
> 이러한 DOM 조작을 통해 웹페이지는 **동적**으로 변한다. (사용자와의 상호작용 기능, API 호출 등)
