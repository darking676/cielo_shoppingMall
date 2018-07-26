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

create table products (<br/>
    procd varchar2(60),<br/>
    pronm varchar2(60) NOT NULL,<br/>
    CONSTRAINT PK_PRO PRIMARY KEY(procd)<br/>
);


INSERT INTO products VALUES ('outer','겉옷');<br/>
INSERT INTO products VALUES ('top','상의');<br/>
INSERT INTO products VALUES ('bottom','하의');<br/>
INSERT INTO products VALUES ('dress','원피스');<br/>
INSERT INTO products VALUES ('shoesNacc','악세서리');<br/>
INSERT INTO products VALUES ('sale','세일품목');

commit;


-- 상품 내용
CREATE TABLE product(<br/>
	productNum   NUMBER,   <br/> 
	productName  VARCHAR2(60),<br/>
        procd varchar2(60),     <br/>
	explan       VARCHAR2(500),    <br/>
	price        NUMBER DEFAULT 0,<br/>
        product_url  varchar2(500),<br/>
        CONSTRAINT PK_PRO2 PRIMARY KEY(productNum),<br/>
        CONSTRAINT FK_PRO2 FOREIGN KEY(procd) REFERENCES products(procd)  <br/>
);



-- 장바구니
CREATE TABLE basket (
	basketNum   INT          primary key, 
	memId       VARCHAR2(30)  NOT NULL,     
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
	memId               VARCHAR2(30)  NOT NULL,     
	productNum          INT          NOT NULL,    
	numbers             INT          NOT NULL,     
	address             VARCHAR2(60)  NOT NULL,     
	hp                  VARCHAR2(30)  NOT NULL,     
	creditcardNum       VARCHAR2(30)  NOT NULL,     
	creditcardPassword  VARCHAR2(10)  NOT NULL    
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


insert into bbsedit values(seq_bbsedit.nextval, 'notice', 'test1', 'it', 'ttt', 0, sysdate);
insert into bbsedit values(seq_bbsedit.nextval, 'notice', 'test2', 'it', 'ggg', 0, sysdate);
insert into bbsedit values(seq_bbsedit.nextval, 'notice', 'test3', 'it', 'zzzz', 0, sysdate);


-- 첨부파일 
create table attachfile (
 attachfileno number,
 filename varchar2(50) NOT NULL,
 filetype varchar2(30),
 filesize number,
 bbseditno number,
 constraint PK_ATTACHFILE PRIMARY KEY(attachfileno)
);

-- 첨부파일 번호 생성기
create sequence SEQ_ATTACHFILE
increment by 1
start with 1;


-- 댓글
create table comments (
	commentno          number,
	bbseditno          number,     
	memId              varchar2(60),  
        memo               varchar2(4000),  
	bbs_date           date,
        constraint PK_COMMENTS PRIMARY KEY(commentno)
);

-- 댓글 번호 생성기

create sequence SEQ_COMMENTS
increment by 1
start with 1;

-----------------------------------------------------------------------

상품 타입<br/>
outer = T01<br/>
bottom  = T02<br/>
dress  = T03<br/>
shoes&acc  = T04<br/>
sale   = T05


상품 번호<br/>
outer = 1~100<br/>
bottom  = 101~200<br/>
dress  = 201~300<br/>
shoes&acc  = 301~400<br/>
sale   = 401~500
