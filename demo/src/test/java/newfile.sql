
/* Drop Triggers */

DROP TRIGGER TRI_Chat_board_chat_id;



/* Drop Tables */

DROP TABLE Chat_board CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_Chat_board_chat_id;




/* Create Sequences */

CREATE SEQUENCE SEQ_Chat_board_chat_id INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE Chat_board
(
	chat_id number NOT NULL,
	chat_content varchar2(200) NOT NULL,
	chat_time date DEFAULT SYSDATE NOT NULL,
	PRIMARY KEY (chat_id)
);



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_Chat_board_chat_id BEFORE INSERT ON Chat_board
FOR EACH ROW
BEGIN
	SELECT SEQ_Chat_board_chat_id.nextval
	INTO :new.chat_id
	FROM dual;
END;

/




