## 블로그 프로젝트

### 데이터베이스 테이블 스키마(구조)

```sql
CREATE TABLE users(
id int primary key auto_increment,
username varchar(100) not null unique,
password varchar(100) not null,
email varchar(100) not null unique,
address varchar(200) not null,
createDate timestamp
)engine= InnoDB default charset = utf8;

CREATE TABLE post(
	id int primary key auto_increment,
    userId int,
    title varchar(100) not null,
    content longtext,
    readCount int,
    createDate timestamp,
    foreign key (userId) references users (id) /*어느 하나의 post게시판을 적을때 user id가 있어야함*/
) engine= InnoDB default charset = utf8;

CREATE TABLE coment(
	id int primary key,
    userId int,
    postId int,
    content varchar(300) not null,
    createDate timestamp,
    foreign key (userId) references users (id) on delete set null,
    foreign key (postId) references post (id) on delete cascade
) engine= InnoDB default charset = utf8;

```