-- 전체 영화 개수
SELECT count(*) as '전체 영화 개수' FROM film;

-- 등급(rating)이 'PG'인 영화 개수
SELECT count(*) as 'PG 등급 영화 개수' FROM film WHERE rating = 'PG';

-- 서로 다른 등급(rating)의 개수 
SELECT count(DISTINCT rating) FROM film;

-- 모든 영화의 대여료(rental_rate) 합계
SELECT sum(rental_rate) as '모든 영화의 대여료' FROM film;

-- 모든 영화의 평균 대여료 (소수점 둘째 자리)
SELECT ROUND(avg(rental_rate), 2) as '모든 영화의 평균 대여료' FROM film;

-- 등급이 'R'인 영화의 평균 대여료
SELECT avg(rental_rate) FROM film WHERE rating = 'R';

-- 가장 비싼 대여료와 해당 영화 제목
SELECT title, rental_rate FROM film WHERE rental_rate = (SELECT max(rental_rate) FROM film);

-- 가장 긴 상영 시간(length)과 해당 영화 제목
SELECT title, length FROM film WHERE length = (SELECT max(length) FROM film);

-- 가장 짧은 상영 시간과 해당 영화 제목
SELECT title, length FROM film WHERe length = (SELECT min(length) FROm film);

-- film 테이블의 다음 통계를 한 번에 조회하세요 
-- 		전체 영화 수, 총 대여료 합계, 평균 대여료, 최고 대여료, 최저 대여료, 평균 상영 시간
SELECT count(*) as '전체 영화 수', sum(rental_rate) as '총 대여료 합계', avg(rental_rate) as '평균 대여료', max(rental_rate) as '최고 대여료', min(rental_rate) as '최저 대여료', avg(length) FROM film;

