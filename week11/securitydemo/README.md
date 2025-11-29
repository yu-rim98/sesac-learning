# Spring Security 개념 정리
## 기본개념
### 1. 인증(Authentication)과 인가(Authorization)
* 인증(Authentication) : 사용자가 누구인지 확인하는 과정
* 인가(Authorization) : 인증된 사용자가 특정 리소스(페이지, 기능 등)에 접근할 권한이 있는지 확인하는 과정

### 2. SecurityConfig를 통한 중앙 집중식 보안 설정
* `SecurityConfig.java`
    * `@Configuration`, `@EnableWebSecurity` : 해당 어노테이션들은 Spring에게 해당 파일이 보안 설정을 담고 있는 클래스임을 알린다.
    * `SecurityFilterChain` : HTTP 요청에 대한 보안 규칙들의 연쇄(Chain)를 정의한다.
        * `http.authorizeHttpRequests(...)`를 통해 URL 패턴별로 접근 권한을 설정한다.
    * 폼 기반 로그인 : `formLogin()` 설정을 통해 커스텀 로그인 페이지를 사용하고, 로그인 성공 시 `/dashboard`로 이동하도록 지정한다.

### 3. `UserDetailsService`와 `UserDetails`를 이용한 사용자 정보 로딩
* Spring Security가 실제 데이터베이스의 사용자와 연동하는 방법이다.

* `CustomDetailService.java` (`UserDetailsService` 구현체)
    * Spring Security가 로그인을 시도하는 사용자 이름(username)으로 사용자 정보를 조회해야 할 때 호출하는 클래스이다.
    * 내부적으로 `UserRepository`를 사용해 DB에서 사용자를 찾는다.
* `CustomUserDetails.java` (`UserDetails` 구현체)
    * `CustomDetailService`가 DB에서 찾은 User 엔티티를 Spring Security가 이해할 수 있는 형태 (`UserDetails`)로 변환해주는 클래스이다.
    * 이 클래스는 사용자의 비밀번호, 역할(권한), 계정 상태 등을 Spring Security에 제공한다.

### 4. `PasswordEncoder`를 통한 비밀번호 암호화
* 데이터베이스에 비밀번호를 저장할 때는 절대 사용자 입력 값 그대로 저장하지 않고, 해시(Hash)처리된 값으로 저장해야 한다.
* `DataInitializer.java`에서 초기 관리자 및 사용자 계정을 생성할 때 `PasswordEncoder`를 사용해 비밀번호를 암호화한 후 DB에 저장한다.
* 로그인 시에도 사용자가 입력한 비밀번호를 동일한 방식으로 해시 처리한 뒤 DB에 저장된 해시 값과 비교해 일치 여부를 확인한다.
* 위 과정을 통해 원본 비밀번호를 노출하지 않고도 인증이 가능하다.

### 5. 역할 기반 접근 제어
* 사용자의 역할(Role)에 따라 접근할 수 있는 페이지나 기능을 제한하는 방식이다.

* `User` 엔티티에 `role` 필드를 두고 사용자의 역할을 저장한다.
* `SecurityConfig`에서 `hasRole("ADMIN)`과 같은 규칙을 사용해 특정 URL에 특정 역할이 필요함을 명시한다.
* `CustomUserDetails`는 `User` 엔티티의 `role` 문자열을 Spring Security가 인식하는 `GrantedAuthority` 객체로 변환해 인가 과정에서 사용될 수 있도록 한다.

---
## 동작 흐름
### 1. 궁금증
* 사용자가 로그인할 때 코드 어디에서도 `CustomDetailService`의 메서드를 직접 호출하지 않는데도 로그인 시점에 어떻게 자동으로 실행되는 거지?

>Spring Security 내부 동작 방식 및 제어의 역전(IoC) 원리 때문이다.   
>즉, 개발자가 직접 호출하는게 아니라 Spring Security 프레임워크가 정해진 흐름에따라 대신 호출해주는 것이다.

### 2. 과정
1. 로그인 시도
    * 사용자가 로그인 폼에 아이디와 비밀번호를 입력해 '로그인' 버튼을 누르면 해당 요청은 Spring Security가 감시하고 있는 특정 URL로 전송된다.
2. 인증 필터(AuthenticationFilter)가 요청 가로채기
    * Spring Security는 수많은 **보안 필터**들로 연결되어 있는데 그 중에 `UsernamePasswordAuthenticationFilter`라는 필터가 로그인 요청을 가로챈다.
    * 해당 필터는 요청에서 사용자의 아이디와 비밀번호를 추출한다.
3. 인증 관리자(AuthenticationManager)에게 위임
    * 필터는 추출한 아이디와 비밀번호로 `UsernamePasswordAuthenticationToken`이라는 **미인증 상태의 인증 토큰**을 만든다.
    * 그리고 해당 토큰을 `AuthenticationManager(인증 관리자)`에게 전달해 **사용자 인증**을 요청한다.
4. `AuthenticationProvider`의 역할
    * `AuthenticationManager`는 직접 인증을 처리하지 않고 등록된 `AuthenticationProvider(인증 제공자)`에게 인증을 다시 위임한다.
    * 아이디/비밀번호 방식에서는 주로 `DaoAuthenticationProvider`가 이 일을 함
5. `UserDetailsService` 호출 (**핵심**)
    * `DaoAuthenticationProvider`가 사용자 정보를 가져오기 위해 `UserDetailsService` 인터페이스의 구현체를 찾아 `loadUserByUsername()` 메서드를 호출한다.
        * 현재 프로젝트에서는 `CustomDetailService`가 `UserDetailsService`의 구현체이기 때문에 Spring Security는 `CustomDetailService`를 찾아서 실행한다.
        * `CustomDetailService` 내부에서는 `UserRepository`를 사용해 DB에서 사용자 정보를 조회한다.
        * `UserServiceImpl`은 `UserService` 인터페이스의 구현체로 만약 `CustomDetailService`가 `UserService`를 주입받아 사용하면 이때 `UserServiceImpl`의 메서드가 호출될 수 있다. (지금은 `UserRepository` 사용 중)
* 6. 비밀번호 비교 및 인증 완료
    * `CustomDetailService`가 `UserDetails` 객체(사용자 정보)를 반환하면 `DaoAuthenticationProvider`는 `PasswordEncoder`를 사용해 사용자가 입력한 비밀번호와 DB에 저장된 암호화된 비밀번호를 비교한다.
    * 일치하면 인증 성공
