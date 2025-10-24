## DDL(Data Definition Language)

- 데이터 구조(테이블, DB 등)를 정의하거나 변경하는 명령어이다.

### CREATE

- 새로운 테이블이나 데이터베이스를 생성한다.
- `CREATE TABLE 테이블명 (...)`

```sql
CREATE TABLE student (
	id INT,
	name VARCHAR(50)
);
```

### ALTER

- 기존 테이블의 구조를 변경한다.
- `ALTER TABLE 테이블명 ...`

```sql
ALTER TABLE student ADD COLUMN age INT;
```

### DROP

- 테이블이나 데이터베이스를 삭제한다.
- `DROP TABLE 테이블명;

```sql
DROP TABLE student;
```

### TRUNCATE

- 테이블의 데이터만 전부 삭제한다. (구조는 유지)
- `TRUNCATE TABLE 테이블명;`

```sql
TRUNCATE TABLE 테이블명;
```

#### 정리

- `CREATE` : 새로 만듦
- `ALTER` : 수정 (열 추가 / 삭제 등)
- `DROP` : 삭제
- `TRUNCATE` : 데이터만 삭제

## DML(Data Manipulation Language)

- 테이블 안의 데이터를 조작(추가/수정/삭제/조회) 하는 명령어이다.

### INSERT

- 새로운 데이터를 삽입한다. (추가 / 생성)
- `INSERT INTO 테이블명 (열1, 열2) VALUES (값1, 값2);`

```sql
INSERT INTO student (id, name) VALUES (1, '홍길동');
```

### SELECT

- 데이터를 조회한다.
- `SELECT 열1, 열2 FROM 테이블명 WHERE 조건;`

```sql
SELECT name FROM student WHERE id = 1;
```

### UPDATE

- 데이터를 수정한다.
- `UPDATE 테이블명 SET 열 = 값 WHERE 조건;`

```sql
UPDATE student SET name = '이몽룡' WHERE id = 1;
```

### DELETE

- 데이터를 삭제한다.
- `DELETE FROM 테이블명 WHERE 조건;`

```sql
DELETE FROM student WHERE id = 1;
```

#### 정리

- `INSERT` : 새 행 추가
- `SELECT` : 데이터 조회
- `UPDATE` : 특정 데이터 수정
- `DELETE` : 데이터 삭제
