<h1>CIELO DB</h1>

-- 회원
CREATE TABLE mem (<br/>
	memId         VARCHAR2(30)  primary key,     
	memName       VARCHAR2(30)  NOT NULL,   
	memPassword   VARCHAR2(30)  NOT NULL,    
	email         VARCHAR2(60)  NOT NULL,     
	address       VARCHAR2(60)  NOT NULL,    
	hp            VARCHAR2(30)  NOT NULL,     
	gender        VARCHAR2(10)  NOT NULL     
);


select * from mem;

-- 회원
CREATE UNIQUE INDEX PK_mem
	ON mem ( -- 회원
		memid DESC -- 회원 아이디
	);



-- 상품
CREATE TABLE product (<br/>
	productNum   INT          primary key,
	productType  VARCHAR(30)  NOT NULL,     
	productName  VARCHAR(30)  NOT NULL,     
	explan       VARCHAR(300)  NOT NULL,    
	price        INT          NOT NULL,    
        inventory    INT          NOT NULL,
        proImg       VARCHAR(300)	NOT NULL    
);

-- 상품
CREATE UNIQUE INDEX PK_product
	ON product ( -- 상품
		productNum DESC -- 상품번호
	);



-- 장바구니
CREATE TABLE basket (<br/>
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
CREATE TABLE payment(<br/>
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




-- 게시판
CREATE TABLE shop_bbs(<br/>
	bbsNum    INTEGER        primary key, 
	memId     VARCHAR(30)    NOT NULL,     
	title     VARCHAR(60)    NOT NULL,    
	contents  VARCHAR(300)   NOT NULL,     
	bbs_date      DATE           NOT NULL, 
        bbsImg        VARCHAR(300)   NOT NULL
);




-- 게시판
CREATE UNIQUE INDEX PK_shop_bbs
	ON shop_bbs ( -- 게시판
		bbsNum DESC -- 게시판 글번호	
);

-- 게시판 시퀀스

create sequence shop_bbs_seq;

(글번호 자동 증가 .nextval)
insert into shop_bbs values(shop_bbs_seq.nextval,'alfos77','테스트용1','내용 나오는지 테스트~~',sysdate);
insert into shop_bbs values(shop_bbs_seq.nextval,'alfos79','테스트용2','내용 나오는지 테스트222~~',sysdate);
select * from shop_bbs;


comments_seq.nextval

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



-- 후기게시판(상품상세페이지 밑)
CREATE TABLE shop_bbs_review(
	reviewNum    INTEGER        primary key, 
	memId     VARCHAR(30)    NOT NULL,     
	title     VARCHAR(60)    NOT NULL,    
	contents  VARCHAR(300)   NOT NULL,     
	review_date  DATE           NOT NULL
);


create sequence shop_bbs_review_seq; 
