DROP SEQUENCE board_seq;
DROP TABLE board;

CREATE TABLE board
(
    boardseq NUMBER CONSTRAINT BOARD_SEQ_PK PRIMARY KEY, --계시글 일련번호
    usrid VARCHAR2(20) CONSTRAINT BOARD_ID_NN NOT NULL, -- 작성자 아이디
    title VARCHAR2(200) CONSTRAINT BOARD_TITLE_NN NOT NULL, -- 게시글 제목
    content VARCHAR2(4000) CONSTRAINT BOARD_CONTENT_NN NOT NULL, --계시글 내용
    hitcount NUMBER DEFAULT 0, --게시글 조회수
    regdate DATE DEFAULT SYSDATE, --등록일
    originalfile VARCHAR(500), --파일명(원래이름)
    savedfile VARCHAR2(500)  -- 첨부파일명(실제 저장된 파일명)
);

CREATE SEQUENCE board_seq;
