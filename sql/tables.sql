create table members(
    mid     varchar(20)     primary key,
    mname   varchar(20)     not null,
    mpassword   varchar(20) not null
);

create table boards(
    bno                     number(10)      primary key,
    btitle                  varchar(1000)   not null,
    bcontent                clob            not null,
    bwriter                 varchar(20)     REFERENCES members (mid) on delete CASCADE,
    bdate                   DATE            not null,
    bhitcount               NUMBER(5)       not null,
    battachsname    		varchar(100)    null, --고객이 올린 파일을 저장
    battachoename  			varchar(100)    null, --고객이 올린 파일의 이름
    battachtype    			varchar(100)    null
);

create sequence bno_seq;
create table accounts (
    ano         varchar(50)     primary key,
    aowner      varchar(20)     not null,
    abalance    number(10)      not null 
);

