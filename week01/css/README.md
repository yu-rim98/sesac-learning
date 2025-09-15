## CSS란?
> **CSS(Cascading Style Sheets)**는 HTML 요소들이 웹 브라우저에 어떻게 보일지를 지정하는 스타일 시트 언어이다.
HTML이 웹 문서의 **구조(뼈대)**를 담당한다면 CSS는 문서의 **스타일(디자인)**을 담당한다.
글자 색, 크기, 배경, 레이아웃, 반응형 디자인 등 시각적 요소를 모두 담당한다.

---
## CSS의 기본 구조
```css
선택자 {
  속성: 값;
  속성: 값;
}
```
* 선택자 (Selector) : 어떤 HTML 요소에 스타일을 적용할지 결정
* 속성 (Property) : 적용할 스타일의 종류 (예: color, font-size 등)
* 값 (Value) : 스타일 속성에 지정할 실제 값

예시
```css
p {
  color: red;
  font-size: 16px;
}
```
* 모든 `<p>` 요소에 빨간 글자색과 글자 크리 16px 적용
---

## CSS 적용 방법 3가지
### 1. 인라인 스타일 (Inline Style)
* HTML 요소 안에 style 속성으로 직접 스타일을 지정한다.
* 특정 요소에만 한정적으로 적용된다.
```html
<p style="color: blue;">파란 글자</p>
```

### 2. 내부 스타일 시트 (Internal Style Sheet)
* `<head>` 태그 안에 `<style>` 태그를 넣어 문서 내부에서 스타일을 작성한다.
```html
<head>
  <style>
    h1 {
      color: green;
    }
  </style>
</head>
```

### 3. 외부 스타일 시트 (External Style Sheet)
* 스타일을 작성한 `* .css` 파일을 `<link>` 태그로 HTML에 연결한다.
```html
<link rel="stylesheet" href="style.css" />
```
---

## CSS 선택자
### 1. 전체 선택자 : `*`
* 문서 내 모든 요소에 스타일을 적용한다.
```css
* {
  margin: 0;
  padding: 0;
}
```

### 2. 태그 선택자 (요소 선택자) : `태그명`
* 특정 태그 전체 요소에 스타일을 적용한다.
```css
h1 {
  color: orange;
}
```

### 3. 클래스 선택자 : `.클래스명`
* 여러 요소에 공통 스타일을 적용하고 싶을 때 사용한다.
```css
.title {
  font-weight: bold;
}
```

### 4. 아이디 선택자 : `#아이디명`
* 고유한 요소에만 적용한다.
```css
#main-title {
  text-align: center;
}
```
