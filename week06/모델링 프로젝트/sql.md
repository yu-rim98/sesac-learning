## ERD

https://www.erdcloud.com/d/wgsAD5Fqc7skXydkB

---

# 🗂️ Delivery 서비스 DB 스키마

```sql
create database delivery
	CHARACTER SET utf8mb4
	COLLATE utf8mb4_unicode_ci;

use delivery;
```

---

## 👤 users (일반 사용자)

```sql
create table users (
	user_id int primary key auto_increment,
	email varchar(100) not null,
	password varchar(255) not null,
	phone varchar(30) not null,
	`rank` varchar(20) not null,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

**설명:**

- 일반 사용자 계정 정보 테이블
- `rank`: 회원 등급 (예: 일반, VIP 등) - 추후 enum

---

## 🏠 user_address (사용자 주소)

```sql
create table user_address (
	address_id int primary key auto_increment,
	user_id int,
	alias varchar(50) not null,
	address_load varchar(255) not null,
	address_detail varchar(255) not null,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    constraint fk_user_address_user
    foreign key (user_id)
    references users (user_id)
);
```

**설명:**

- 사용자의 배송지 관리 테이블
- `alias`: 주소 별칭 (예: 집, 회사 등)

---

## 🧾 business_user (사업자 회원)

```sql
create table business_user (
	b_user_id int primary key auto_increment,
	name varchar(30) not null,
	email varchar(100) not null,
	password varchar(255) not null,
	phone varchar(30) not null,
	business_number varchar(50) not null,
	business_name varchar(100) not null,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

**설명:**

- 음식점을 운영하는 사업자 회원 테이블
- `business_number`: 사업자 등록번호

---

## 🏪 store (가게)

```sql
create table store (
	store_id int primary key auto_increment,
	b_user_id int not null,
	store_name varchar(100) not null,
	store_address varchar(255) not null,
	store_intro text,
	origin_info text,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	constraint fk_store_b_user
	foreign key (b_user_id)
	references business_user (b_user_id)
);
```

**설명:**

- 사업자가 등록한 가게 정보
- `origin_info`: 원산지 표시 정보

---

## 🍱 store_category_info (가게 카테고리 정보)

```sql
create table store_category_info (
	s_category_info_id int primary key auto_increment,
	category_name varchar(20) not null
);

```

**설명:**

- 음식 카테고리 목록 (예: 치킨, 피자, 한식 등)

---

## 🏷️ store_category (가게-카테고리 매핑)

```sql
create table store_category (
	s_category_id int primary key auto_increment,
	s_category_info_id int not null,
	store_id int not null,
	constraint fk_store_category_category_info
	foreign key (s_category_info_id)
	references store_category_info (s_category_info_id),
	constraint fk_store
	foreign key (store_id)
	references store (store_id)
);
```

**설명:**

- 가게가 속한 카테고리를 연결하는 중간 테이블
- 다대다 관계 해결용

---

## 📂 menu_category (메뉴 카테고리)

```sql
create table menu_category (
	menu_category_id int primary key auto_increment,
	menu_category_name varchar(100) not null,
	store_id int not null,
	constraint fk_menu_category_store
	foreign key (store_id)
	references store (store_id)
);

```

**설명:**

- 가게별 메뉴 그룹 (예: 세트메뉴, 사이드, 음료 등)

---

## 🍔 menu (메뉴)

```sql
create table menu (
	menu_id int primary key auto_increment,
	menu_category_id int not null,
	menu_name varchar(100) not null,
	menu_description text,
	menu_img_url varchar(255),
	menu_stock int,
	menu_price int not null,
	constraint fk_menu_menu_category
	foreign key (menu_category_id)
	references menu_category (menu_category_id)
);
```

**설명:**

- 실제 판매 메뉴 정보
- `menu_stock`: 재고 수량
- `menu_img_url`: 메뉴 이미지 경로

---

## 📦 orders (주문)

```sql
create table orders (
	order_id int primary key auto_increment,
	user_id int not null,
	store_id int not null,
	total_price int not null,
	order_state varchar(100),
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    constraint fk_orders_user
    foreign key (user_id)
    references users (user_id),
    constraint fk_orders_store
    foreign key (store_id)
    references store(store_id)
);
```

**설명:**

- 주문 내역 테이블
- `order_state`: 주문 상태 (예: 결제완료, 준비중, 배달완료 등) - enum

---

## 🧾 order_item (주문 상세)

```sql
create table order_item (
	order_item_id int primary key auto_increment,
	menu_id int not null,
	quantity int not null,
	price int not null,
	order_id int not null,
	constraint fk_order_item_order_id
	foreign key (order_id)
	references orders (order_id),
	constraint fk_order_item_menu_id
	foreign key (menu_id)
	references menu (menu_id)
);
```

**설명:**

- 주문별 상세 메뉴 내역
- 각 주문에 포함된 메뉴와 수량

---

## 💳 payment (결제)

```sql
create table payment (
	payment_id int primary key auto_increment,
	order_id int not null,
	payment_type varchar(30) not null,
	payment_state varchar(30),
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    constraint fk_payment_order_id
    foreign key (order_id)
    references orders(order_id)
);
```

**설명:**

- 결제 정보 관리
- `payment_type`: 결제 수단 (카드, 현금 등)
- `payment_state`: 결제 상태 (성공, 실패 등)

---

## ⭐ review (리뷰)

```sql
create table review (
	review_id int primary key auto_increment,
	review_img varchar(255),
	review_detail text,
	user_id int not null,
	order_id int not null,
	constraint fk_review_user_id
	foreign key (user_id)
	references users(user_id),
	constraint fk_review_order_id
	foreign key (order_id)
	references orders(order_id)
);
```

**설명:**

- 사용자 리뷰 정보
- 리뷰 이미지 및 내용 저장

---

## 💬 review_comment (사장님 답글)

```sql
create table review_comment (
	review_comment_id int primary key auto_increment,
	comment_detail text not null,
	b_user_id int not null,
	review_id int not null,
	constraint fk_review_comment_b_user
	foreign key (b_user_id)
	references business_user(b_user_id),
	constraint fk_review_comment_review
	foreign key (review_id)
	references review(review_id)
);
```

**설명:**

- 리뷰에 대한 사업자 답글
- `b_user_id`가 남긴 `review_comment`

---

# 🍔 배달 플랫폼 SQL 시나리오 정리

> 전체 시나리오:
>
> 일반 사용자 / 업주 회원가입 → 가게 등록 → 메뉴 등록 → 주문 및 결제 → 리뷰 등록 및 조회

## 🧍‍♀️ 1. 일반 사용자 회원가입 & 로그인

```sql
-- 회원가입
INSERT INTO users (email, password, phone, `rank`)
VALUES ('choi@gmail.com', '암호화비밀번호', '010-1111-2222', 'Basic');

-- 전체 사용자 조회
SELECT * FROM users;

-- 로그인
SELECT EXISTS(
    SELECT 1
    FROM users
    WHERE email = 'choi@gmail.com'
      AND password = '암호화비밀번호'
);

```

---

## 🧑‍🍳 2. 업주 회원가입 & 로그인

```sql
-- 업주 회원가입
INSERT INTO business_user (name, email, password, phone, business_number, business_name)
VALUES ('홍업주', 'hong@gmail.com', '암호화비밀번호', '010-1212-1212', '사업자등록번호', '상호명');

SELECT * FROM business_user;

-- 업주 로그인
SELECT EXISTS(
    SELECT 1
    FROM business_user
    WHERE email = 'hong@gmail.com'
      AND password = '암호화비밀번호'
);

```

---

## 🏷️ 3. 가게 카테고리 등록

```sql
-- 카테고리 등록
INSERT INTO store_category_info (category_name)
VALUES ('한식'), ('분식'), ('중식'), ('일식'), ('양식'), ('야식');

-- 카테고리 전체 조회
SELECT * FROM store_category_info;
```

---

## 🏠 4. 가게 등록

```sql
BEGIN;
-- 1. 가게 등록
INSERT INTO store (b_user_id, store_name, store_address, store_intro, origin_info)
VALUES (1, '홍가네', '서울시 송파구 ~~', NULL, '배추 : 국산, 쌀 : 국산');

-- 2. 방금 등록한 store_id 가져오기
SET @store_id = LAST_INSERT_ID();

-- 3. 카테고리 연결 (중간 테이블)
INSERT INTO store_category (store_id, s_category_info_id) VALUES (@store_id, 1);

COMMIT;

```

> 여러 카테고리(예: ‘야식’, ‘한식’) 가게 등록 가능

```sql
SELECT * FROM store;
SELECT * FROM store_category;
```

---

## 🍱 5. 카테고리별 가게 조회

```sql
-- 한식 가게 조회
SELECT s.store_name, sci.category_name
FROM store_category sc
JOIN store s ON sc.store_id = s.store_id
JOIN store_category_info sci ON sci.s_category_info_id = sc.s_category_info_id
WHERE sci.category_name = '한식';

-- 야식 가게 조회
SELECT s.store_name, sci.category_name
FROM store s
JOIN store_category sc ON s.store_id = sc.store_id
JOIN store_category_info sci ON sci.s_category_info_id = sc.s_category_info_id
WHERE sci.category_name = '야식';

```

---

## 🧹 6. 가게 삭제 (CASCADE 설정)

```sql
ALTER TABLE store_category DROP FOREIGN KEY fk_store;

ALTER TABLE store_category
ADD CONSTRAINT fk_store
FOREIGN KEY (store_id) REFERENCES store(store_id)
ON DELETE CASCADE;

-- 가게 삭제 시 관련 store_category 행도 자동 삭제
DELETE FROM store WHERE store_id = 4;

```

---

## 🍛 7. 메뉴 등록

```sql
-- 메뉴 카테고리 생성
INSERT INTO menu_category (menu_category_name, store_id)
VALUES ('찌개', 2);

SET @menu_category_id = LAST_INSERT_ID();

-- 메뉴 등록
INSERT INTO menu (menu_category_id, menu_name, menu_description, menu_img_url, menu_stock, menu_price)
VALUES
(@menu_category_id, '김치찌개', '맛있는 김치찌개', 'http://example.com/kimchi.jpg', 50, 8000),
(@menu_category_id, '된장찌개', '맛있는 된장찌개', 'http://example.com/kimchi.jpg', 50, 8000),
(@menu_category_id, '부대찌개', '맛있는 부대찌개', 'http://example.com/kimchi.jpg', 50, 8000);

```

---

## 🧾 8. 가게 메뉴 조회

```sql
SELECT
    mc.menu_category_name,
    m.menu_name,
    m.menu_description,
    m.menu_img_url,
    m.menu_stock,
    m.menu_price
FROM menu_category mc
INNER JOIN menu m ON mc.menu_category_id = m.menu_category_id
WHERE mc.store_id = 2
ORDER BY mc.menu_category_id, m.menu_id;

```

---

## 💳 9. 음식 주문

```sql
START TRANSACTION;

-- 1. 주문 생성
INSERT INTO orders (user_id, store_id, total_price, order_state)
VALUES (1, 2, 16000, '결제대기');

SET @order_id = LAST_INSERT_ID();

-- 2. 주문 항목 등록
INSERT INTO order_item (menu_id, quantity, price, order_id)
VALUES
(1, 2, 8000, @order_id),
(3, 1, 8000, @order_id);

-- 3. 결제 등록
INSERT INTO payment (order_id, payment_type, amount, payment_state)
VALUES (@order_id, '카드', 16000, '결제대기');

COMMIT;

```

---

## 🧾 10. 주문 내역 조회

```sql
SELECT
 	o.order_id,
    o.store_id,
    o.total_price,
    o.order_state,
    oi.menu_id,
    m.menu_name,
    oi.quantity,
    oi.price
FROM orders o
JOIN order_item oi ON o.order_id = oi.order_id
JOIN menu m ON oi.menu_id = m.menu_id
WHERE o.user_id = 1
ORDER BY o.order_id, oi.order_item_id;

```

---

## ⭐ 11. 리뷰 등록 & 조회

```sql
-- 리뷰 생성
INSERT INTO review (review_detail, user_id, order_id)
VALUES ('맛있었어요~~!!', 1, 1);

-- 특정 가게의 리뷰 조회
SELECT
    r.review_id,
    r.review_img,
    r.review_detail,
    r.user_id,
    r.order_id,
    o.store_id
FROM review r
JOIN orders o ON r.order_id = o.order_id
WHERE o.store_id = 2;

-- 내가 쓴 리뷰 조회
SELECT
    r.review_id,
    r.review_img,
    r.review_detail,
    r.user_id,
    r.order_id,
    o.store_id
FROM review r
JOIN orders o ON r.order_id = o.order_id
WHERE r.user_id = 1;

```
