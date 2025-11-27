-- 기존 데이터 삭제 (필요시 주석 해제 후 실행)
-- DELETE FROM answer;
-- DELETE FROM question;

-- 1. 질문 데이터 생성 (Question)
-- ID를 명시적으로 지정하여 답변 데이터와 연결하기 쉽게 했습니다.

INSERT INTO QUESTION (id, title, optiona, optionb)
VALUES (1, '오늘 점심 뭐 먹을까?', '짜장면', '짬뽕');

INSERT INTO QUESTION (id, title, optiona, optionb)
VALUES (2, '휴가는 어디로 갈까?', '산', '바다');

INSERT INTO QUESTION (id, title, optiona, optionb)
VALUES (3, '탕수육 먹는 방법은?', '부먹', '찍먹');


-- 2. 답변 데이터 생성 (Answer)
-- question_id는 위에서 만든 question 테이블의 id와 일치해야 합니다.

-- [질문 1] 짜장면(A) vs 짬뽕(B) -> 섞여있는 경우 (A: 2표, B: 1표)
INSERT INTO ANSWER (question_id, answer_text, content) VALUES (1, 'A', '역시 점심은 짜장면이지');
INSERT INTO ANSWER (question_id, answer_text, content) VALUES (1, 'A', '달달한게 땡겨서 짜장');
INSERT INTO ANSWER (question_id, answer_text, content) VALUES (1, 'B', '비오니까 국물 있는 짬뽕');

-- [질문 2] 산(A) vs 바다(B) -> B가 압도적인 경우 (A: 0표, B: 3표)
INSERT INTO ANSWER (question_id, answer_text, content) VALUES (2, 'B', '여름엔 무조건 바다지');
INSERT INTO ANSWER (question_id, answer_text, content) VALUES (2, 'B', '수영하고 싶어요');
INSERT INTO ANSWER (question_id, answer_text, content) VALUES (2, 'B', '산은 벌레 많아서 싫음');

-- [질문 3] 부먹(A) vs 찍먹(B) -> 투표가 없는 경우 (테스트용)
-- 데이터 없음