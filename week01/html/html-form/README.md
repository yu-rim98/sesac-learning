## 폼(Form)이란?
> `<form>` 태그는 사용자에게 **데이터를 입력받아 웹 서버로 전송하는 구조**를 만든다.   
회원가입, 로그인, 검색 등 다양한 사용자 입력 처리는 모두 form을 기반으로 동작한다.

```html
<form action="/submit" method="post">
  <!-- 입력 요소들 -->
</form>
```
`action` : 데이터를 전송할 URL **경로** (전송 대상)
`method` : 데이터를 전송하는 **방식** (`GET` 또는 `POST`)

---
### 폼의 주요 요소
#### 1. `<label>` & `<input>` 
* 가장 기본적인 입력 방식
```html
<label for="username">아이디</label>
<input type="text" id="username" name="username" />
```
* `label`은 입력 필드의 **이름표** 역할을 한다.
* `for`와 `id`를 연결시켜 라벨을 클릭하면(*'아이디'* 클릭 시) 입력창에 포커스된다.
	- for, id를 사용하지 않고 `<label>` 태그 내부에 `<input>` 요소를 포함시키는 것도 가능함
* `type` 속성으로 입력 종류를 지정할 수 있다. (예: text, email, password 등)
* `name` 속성은 서버에 데이터를 전송할 때 **데이터의 key값 역할**을 한다.
	- 즉, 위 코드와 같이 `name="username"` 일 경우 서버에서는 `username=입력값` 형태로 데이터를 받는다.
 
#### 2. `<textarea>`
* **여러 줄의 텍스트 입력**을 위한 요소
```html
<textarea name="comment" rows="4" cols="50"></textarea>
```
* 줄바꿈이 가능하며 **긴 텍스트 입력**에 적합하다. (예: 게시판 글 작성, 후기, 댓글 등)
* `rows`, `cols` 속성으로 크기 지정이 가능하다.

#### 3. `<select>` & `<option>`
* 드롭다운 목록을 만들 때 사용
```html
<select name="language">
  <option value="html">HTML</option>
  <option value="css">CSS</option>
</select>
```
* `select`는 묶음이고 `option`은 각 선택 항목을 의미한다.
* `value`는 서버로 전달될 실제 값이고, 내부 텍스트는 사용자에게 보여지는 값이다.

#### 4. `<button>`
* 사용자 액션을 위한 버튼
```html
<button type="submit">전송</button>
<button type="reset">초기화</button>
```
* `type="submit"` : form을 서버로 전송한다.
* `type="reset"` : form 내부 입력값을 초기화한다.
* `type="button"` : 아무 기능 없는 기본 버튼이다.
---
### 주의사항
> `<input>`, `<textarea>`, `<select>` 등 모든 입력 요소는 반드시 `<form>` 태그 안에 위치해야 정상적으로 서버에 전송된다.
