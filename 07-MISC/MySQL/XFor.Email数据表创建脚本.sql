drop table if exists EMAIL_MESSAGE;
drop table if exists EMAIL_ACTION;
drop table if exists EMAIL_TEMPLATE;


/*==============================================================*/
/* Table: EMAIL_MESSAGE                                         */
/*==============================================================*/
create table EMAIL_MESSAGE
(
   SID                  varchar(32) not null  comment '',
   EMAIL_FROM           varchar(128) not null  comment '',
   EMAIL_TO             varchar(128) not null  comment '',
   EMAIL_SUBJECT        varchar(128) not null  comment '',
   EMAIL_CONTENT        text  comment '',
   EMAIL_TEMPLATE_CODE  varchar(32)  comment '',
   EMAIL_TEMPLATE_DATA  text  comment '',
   CREATE_TIME          datetime not null  comment '',
   primary key (SID)
);


/*==============================================================*/
/* Table: EMAIL_ACTION                                          */
/*==============================================================*/
create table EMAIL_ACTION
(
   SID                  varchar(32) not null  comment '',
   EMAIL_MESSAGE_SID    varchar(32) not null  comment '',
   SEND_STATE           int not null  comment '',
   SEND_RETRY_COUNT     int not null  comment '',
   CREATE_TIME          datetime not null  comment '',
   MODIFY_TIME          datetime not null  comment '',
   primary key (SID)
);


/*==============================================================*/
/* Table: EMAIL_TEMPLATE                                        */
/*==============================================================*/
create table EMAIL_TEMPLATE
(
   SID                  varchar(32) not null  comment '',
   CODE                 varchar(32) not null  comment '',
   NAME                 varchar(32) not null  comment '',
   MEMO                 varchar(512)  comment '',
   CONTENT              text  comment '',
   FILE_NAME            varchar(128)  comment '',
   ENGINE_TYPE          int not null  comment '',
   CREATE_TIME          datetime not null  comment '',
   MODIFY_TIME          datetime not null  comment '',
   primary key (SID)
);
