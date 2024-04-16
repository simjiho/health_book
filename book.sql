create table user_tbl(
	user_id varchar2(4) primary key,
	user_passwd varchar2(20),
	user_name varchar2(10),
	user_phone varchar2(20)
);

insert into user_tbl values('1001','31012','윤호기','01011112222');
insert into user_tbl values('1002','30904','김용민','01033334444');

create table trainer_tbl(
	trainer_id number(2) primary key,
	trainer_passwd varchar2(20),
	trainer_name varchar2(20),
	trainer_major varchar2(20),
	pay number(10)
);
insert into trainer_tbl values(10,'1000','최트레이너','다이어트',10000);
insert into trainer_tbl values(11,'1001','이트레이너','근육량증가',20000);
insert into trainer_tbl values(12,'1002','박트레이너','바디프로필',40000);
insert into trainer_tbl values(13,'1003','김트레이너','체형교정',30000);
insert into trainer_tbl values(14,'1004','전트레이너','선수준비',50000);

drop table trainer_tbl;
select * from trainer_tbl;

drop table user_tbl;
select * from user_tbl;

create table book_tbl(
	book_id number(5) primary key,
	user_id varchar2(4),
	trainer_name varchar2(20),
	book_hour number(10),
	book_pay number(20)
);

drop table book_tbl;
select * from book_tbl;

insert into book_tbl values(10001,'1001','최트레이너',10,100000);
insert into book_tbl values(10002,'1002','이트레이너',5,100000);

SELECT
    b.book_id,
    u.user_id,
    t.trainer_name,
    b.book_hour,
    b.book_pay
FROM
    book_tbl b
JOIN
    user_tbl u ON b.user_id = u.user_id
JOIN
    trainer_tbl t ON b.trainer_name = t.trainer_name;

select book_id, user_id, trainer_name, book_hour,
book_pay from book_tbl;

select book_id, user_id, trainer_name, book_hour,
 to_char(book_pay,'l999,999,999') book_pay from book_tbl;