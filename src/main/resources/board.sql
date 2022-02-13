/*
    2022.2.7
    게시판 관련 여러 객체들 생성 --> 회원전용
*/
-- 객체 삭제
DROP TABLE REPLY;
DROP SEQUENCE REPLY_SEQ;
DROP TABLE "member";
DROP SEQUENCE board_seq;
DROP TABLE board;

-- 게시판 관련 객체
CREATE TABLE board
(
    boardseq NUMBER         constraint board_seq_pk PRIMARY KEY,   -- 게시글 일련번호
    usrid    VARCHAR2(20)   constraint board_id_nn  NOT NULL,      -- 작성자 아이디
    title    VARCHAR2(200)  constraint board_title_nn  NOT NULL,   -- 게시글 제목
    content  VARCHAR2(4000) constraint board_content_nn  NOT NULL, -- 게시글 내용
    hitcount NUMBER DEFAULT 0,                                     -- 게시글 조회수
    regdate  DATE DEFAULT sysdate,                                 -- 등록일
    originalfile VARCHAR2(500),     -- 파일명 (원래 이름: 사용자가 업로드한 이름)
    savedfile    VARCHAR2(500)      -- 첨부파일명(실제 저장된 파일명)
);

CREATE SEQUENCE board_seq;

-- 회원 테이블
CREATE TABLE "member"
(
    usrid   VARCHAR2(20)   PRIMARY KEY,
    usrpwd  VARCHAR2(100)  NOT NULL,
    usrname VARCHAR2(50)   NOT NULL,
    email   VARCHAR2(100)  NOT NULL,
    enabled NUMBER(1) DEFAULT 1,   ---1: 사용가능, 0: 사용불가능 (SECURITY에서 사용하는 컬럼)
    rolename VARCHAR2(50) DEFAULT 'ROLE_USER' NOT NULL -- ROLE_USER, ROLE_MANAGER, ROLE_ADMIN 등 각 역할에 따른 이름
);




