drop table if exists STORE;
drop table if exists STORE_CART;

/*==============================================================*/
/* Table: STORE                                                 */
/*==============================================================*/
create table STORE
(
   SID                  varchar(32) not null  comment '',
   CODE                 varchar(32) not null  comment '',
   NAME                 varchar(32) not null  comment '',
   MEMO                 varchar(512)  comment '',
   CREATE_TIME          datetime not null  comment '',
   STATE                int not null  comment '',
   primary key (SID)
);

alter table STORE comment '商店';


/*==============================================================*/
/* Table: STORE_CART                                            */
/*==============================================================*/
create table STORE_CART
(
   SID                  varchar(32) not null  comment '唯一标识',
   ACCOUNT_SID          varchar(32) not null  comment '账户标识',
   CONTENT              text  comment '购物车项集合序列化内容',
   primary key (SID)
);

alter table STORE_CART comment '购物车';
