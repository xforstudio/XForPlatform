drop table if exists PRODUCT;
drop table if exists PRODUCT_STORE;
drop table if exists PRODUCT_CATEGORY;
drop table if exists PRODUCT_CATEGORY_RELA;
drop table if exists PRODUCT_TAG;




/*==============================================================*/
/* Table: PRODUCT                                               */
/*==============================================================*/
create table PRODUCT
(
   SID                  varchar(32) not null  comment '',
   PRODUCT_STORE_SID    varchar(32) not null  comment '',
   CODE                 varchar(32) not null  comment '',
   NAME                 varchar(32) not null  comment '',
   MEMO                 varchar(512)  comment '',
   CREATE_TIME          datetime not null  comment '',
   PICTURES_CONTENT     text  comment '',
   PRICE                decimal not null  comment '',
   SALE_STATE           int not null  comment '',
   TAGS_CONTENT         text  comment '',
   primary key (SID)
);

alter table PRODUCT comment '商品';




/*==============================================================*/
/* Table: PRODUCT_STORE                                         */
/*==============================================================*/
create table PRODUCT_STORE
(
   SID                  varchar(32) not null  comment '',
   NAME                 varchar(32) not null  comment '',
   MEMO                 varchar(512)  comment '',
   CREATE_TIME          datetime not null  comment '',
   OWNER                varchar(32) not null  comment '',
   primary key (SID)
);

alter table PRODUCT_STORE comment '商品集';




/*==============================================================*/
/* Table: PRODUCT_CATEGORY                                      */
/*==============================================================*/
create table PRODUCT_CATEGORY
(
   SID                  varchar(32) not null  comment '',
   PRODUCT_STORE_SID    varchar(32) not null  comment '',
   CODE                 int not null  comment '',
   NAME                 varchar(32) not null  comment '',
   MEMO                 varchar(512)  comment '',
   PARENT_CODE          int  comment '',
   primary key (SID)
);


alter table PRODUCT_CATEGORY comment '商品类别';




/*==============================================================*/
/* Table: PRODUCT_CATEGORY_RELA                                 */
/*==============================================================*/
create table PRODUCT_CATEGORY_RELA
(
   SID                  varchar(32) not null  comment '',
   PRODUCT_STORE_SID    varchar(32) not null  comment '',
   CATEGORY_CODE        int not null  comment '',
   PRODUCT_CODE         varchar(32) not null  comment '',
   primary key (SID)
);

alter table PRODUCT_CATEGORY_RELA comment '商品类别关联';




/*==============================================================*/
/* Table: PRODUCT_TAG                                           */
/*==============================================================*/
create table PRODUCT_TAG
(
   SID                  varchar(32) not null  comment '',
   PRODUCT_STORE_SID    varchar(32) not null  comment '',
   CODE                 int not null  comment '',
   NAME                 varchar(32) not null  comment '',
   PARENT_CODE          int not null  comment '',
   primary key (SID)
);

alter table PRODUCT_TAG comment '商品标签';



