-- 방명록 만들기(guest book)

-- 객체 삭제하기
DROP SEQUENCE guestbook_seq;
DROP TABLE guestbook;

CREATE Table guestbook
(
    seq NUMBER constraint guestbook_seq_pk PRIMARY KEY,
    usrname VARCHAR2(50) CONSTRAINT guestbook_name_nn NOT NULL,
    usrpwd VARCHAR2(50) CONSTRAINT guestbook_pwd_nn NOT NULL,
    text VARCHAR2(1000) DEFAULT '안녕하세요?',
    regdate DATE DEFAULT SYSDATE
);

CREATE SEQUENCE guestbook_seq;


