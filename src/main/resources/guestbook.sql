-- 방명록(guestbook)

-- 객체 삭제하기
DROP SEQUENCE guestbook_seq;
DROP TABLE guestbook;

CREATE TABLE guestbook
(
    seq     NUMBER constraint guestbook_seq_pk PRIMARY KEY,
    usrname VARCHAR2(50) constraint guestbook_name_nn NOT NULL,
    usrpwd  VARCHAR2(50) constraint guestbook_pwd_nn NOT NULL,
    text    VARCHAR2(1000) default '안녕하세요?',
    regdate DATE default sysdate
);

CREATE SEQUENCE guestbook_seq;