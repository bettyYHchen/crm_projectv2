
create database crm_database;

use crm_database;

create table CRM_USER
(
  ID           BIGINT not null,
  USER_NAME         VARCHAR(36) not null,
  ENCRYPTED_PASSWORD VARCHAR(128) not null,
  ENABLED           BIT not null 
) ;

alter table CRM_USER
  add constraint CRM_USER_PK primary key (ID);
 
alter table CRM_USER
  add constraint CRM_USER_UK unique (USER_NAME);
 
--  DROP TABLE IF EXISTS role;

create table ROLE
(
  ID   BIGINT not null,
  ROLE_NAME VARCHAR(30) not null
) ;

alter table ROLE
  add constraint ROLE_PK primary key (ID);
 
alter table ROLE
  add constraint ROLE_UK unique (ROLE_NAME);
 
 

create table CRM_USER_ROLE
(
  ID      BIGINT not null,
  USER_ID BIGINT not null,
  ROLE_ID BIGINT not null
);

alter table CRM_USER_ROLE
  add constraint CRM_USER_ROLE_PK primary key (ID);
 
alter table CRM_USER_ROLE
  add constraint CRM_USER_ROLE_UK unique (USER_ID, ROLE_ID);
 
alter table CRM_USER_ROLE
  add constraint CRM_USER_ROLE_FK1 foreign key (USER_ID)
  references CRM_USER (ID);
 
alter table CRM_USER_ROLE
  add constraint CRM_USER_ROLE_FK2 foreign key (ROLE_ID)
  references ROLE (ID);
 
 
-- Used by Spring Remember Me API.  
CREATE TABLE Persistent_Logins (
 
    userName varchar(64) not null,
    series varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp not null,
    PRIMARY KEY (series)
     
);
 

 
insert into crm_user (ID, USER_NAME, ENCRYPTED_PASSWORD, ENABLED)
values (2, 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 
insert into crm_user (ID, USER_NAME, ENCRYPTED_PASSWORD, ENABLED)
values (1, 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 

 
insert into role (ID, ROLE_NAME)
values (1, 'ROLE_ADMIN');
 
insert into role (ID, ROLE_NAME)
values (2, 'ROLE_USER');
 

 
insert into crm_user_role (USER_ID, ROLE_ID)
values (1, 1);
 
insert into crm_user_role (USER_ID, ROLE_ID)
values ( 1, 2);
 
insert into crm_user_role (USER_ID, ROLE_ID)
values ( 2, 2);

select * from crm_user;
select * from crm_user_role;