<h1>CIELO DB</h1>

-- 회원
CREATE TABLE members (
	memId         VARCHAR2(30)  primary key,     
	memName       VARCHAR2(30)  NOT NULL,   
	memPassword   VARCHAR2(30)  NOT NULL,    
	email         VARCHAR2(60)  NOT NULL,     
	address       VARCHAR2(60)  NOT NULL,    
	hp            VARCHAR2(30)  NOT NULL   
 
);

insert into mem values('alfos77','오미래','1234','alfos77@naver.com','경기도 시흥시','01077287934');

select * from members;

-- 회원
CREATE UNIQUE INDEX PK_members
	ON members ( -- 회원
		memid DESC -- 회원 아이디
	);

-- 상품
CREATE TABLE product (
	productNum   INT          primary key,
	productType  VARCHAR(30)  NOT NULL,     
	productName  VARCHAR(30)  NOT NULL,     
	explan       VARCHAR(300)  NOT NULL,    
	price        INT          NOT NULL,    
      	inventory    INT          NOT NULL
);

-- 상품
CREATE UNIQUE INDEX PK_product
	ON product ( -- 상품
		productNum DESC -- 상품번호
	);



-- 장바구니
CREATE TABLE basket (
	basketNum   INT          primary key, 
	memId       VARCHAR(30)  NOT NULL,     
	productNum  INT          NOT NULL,     
	numbers     INT          NOT NULL    
);


-- 장바구니
CREATE UNIQUE INDEX PK_basket
	ON basket ( -- 장바구니
		basketNum DESC -- 장바구니 번호
	);

-- 결제
CREATE TABLE payment(
	paymentNum          INT          primary key, 
	memId               VARCHAR(30)  NOT NULL,     
	productNum          INT          NOT NULL,    
	numbers             INT          NOT NULL,     
	address             VARCHAR(60)  NOT NULL,     
	hp                  VARCHAR(30)  NOT NULL,     
	creditcardNum       VARCHAR(30)  NOT NULL,     
	creditcardPassword  VARCHAR(10)  NOT NULL    
);


-- 결제
CREATE UNIQUE INDEX PK_payment
	ON payment ( -- 결제
		paymentNum DESC -- 결제 번호
	);

-- 게시판 종류
CREATE TABLE shop_bbs(
    bbscd varchar2(60),
    bbsnm varchar2(60) NOT NULL,
    CONSTRAINT PK_BBS PRIMARY KEY(bbscd)
);
 

-- 게시글
CREATE TABLE bbsedit (
    bbseditno NUMBER,
    bbscd varchar2(20),
    title varchar2(100) NOT NULL,
    contents varchar2(600),
    memId varchar2(60),
    hit NUMBER,
    bbs_date DATE,
    CONSTRAINT PK_ARTICLE PRIMARY KEY(bbseditno),
    CONSTRAINT FK_ARTICLE FOREIGN KEY(bbscd) REFERENCES shop_bbs(bbscd)
);
 
-- 게시글 번호 생성기
CREATE SEQUENCE SEQ_bbsedit
INCREMENT BY 1
START WITH 1;
 
--게시판 데이터 입력
INSERT INTO shop_bbs VALUES ('review','리뷰게시판');
INSERT INTO shop_bbs VALUES ('qna','QnA게시판');
INSERT INTO shop_bbs VALUES ('notice','문의게시판');

commit;


insert into bbsedit values(seq_bbsedit.nextval, 'notice', 'test1', 'it''s test1', 'ttt', 0, sysdate);
insert into bbsedit values(seq_bbsedit.nextval, 'notice', 'test2', 'it''s \*test2', 'ggg', 0, sysdate);
insert into bbsedit values(seq_bbsedit.nextval, 'notice', 'test2', 'it''s \$test3', 'zzzz', 0, sysdate);

-- 댓글
CREATE TABLE comments (
	commentsNum        INT            primary key, 
	bbsNum             INT            NOT NULL,      
	memId              VARCHAR(30)    NOT NULL,    
	commentsDate       DATE           NOT NULL,   
	commentsContents   VARCHAR(300)   NOT NULL     
);


-- 댓글
CREATE UNIQUE INDEX PK_comment
	ON comments ( -- 댓글
		commentsNum  DESC -- 댓글 번호	
);

-- 댓글 시퀀스

create sequence comments_seq; 
