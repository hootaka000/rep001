# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table additional_text (
  id                        bigint auto_increment not null,
  eventid                   bigint not null,
  title                     varchar(16) not null,
  message                   varchar(1024) not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_additional_text primary key (id))
;

create table address (
  id                        bigint auto_increment not null,
  entry_userid              bigint,
  prefecturesid             bigint,
  postal_codeid             bigint,
  oversea_postal_code       varbinary(40),
  apartment                 varbinary(100),
  place_name                varbinary(400) not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_address primary key (id))
;

create table admin_user (
  id                        bigint auto_increment not null,
  employee_id               bigint,
  role                      integer not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint uq_admin_user_1 unique (employee_id),
  constraint pk_admin_user primary key (id))
;

create table call_history (
  id                        bigint auto_increment not null,
  entry_userid              bigint,
  memo                      varbinary(512) not null,
  datetime                  datetime not null,
  call_history_type         integer not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_call_history primary key (id))
;

create table comments (
  id                        bigint auto_increment not null,
  message                   varchar(128) not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint uq_comments_message unique (message),
  constraint pk_comments primary key (id))
;

create table company (
  id                        bigint auto_increment not null,
  name                      varchar(32) not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint uq_company_name unique (name),
  constraint pk_company primary key (id))
;

create table complex_group (
  id                        bigint auto_increment not null,
  employee_id               bigint,
  companyid                 bigint,
  name                      varchar(128) not null,
  condition_register_from   datetime,
  condition_register_to     datetime,
  conditon_school_division  integer not null,
  condition_sex             integer,
  condition_selection_status integer,
  condition_school_gropu_type integer,
  condition_new_recruit     integer,
  condition_group_type      integer,
  condition_event_type      integer,
  condition_comment_type    integer,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint uq_complex_group_name unique (name),
  constraint pk_complex_group primary key (id))
;

create table dashboard_report (
  id                        bigint auto_increment not null,
  employee_id               bigint,
  report_type               integer not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_dashboard_report primary key (id))
;

create table employee (
  id                        bigint auto_increment not null,
  name                      varchar(64) not null,
  employee_number           varchar(6) not null,
  employee_status           integer not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint uq_employee_employee_number unique (employee_number),
  constraint pk_employee primary key (id))
;

create table employee_company (
  id                        bigint auto_increment not null,
  employee_id               bigint not null,
  companyid                 bigint not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_employee_company primary key (id))
;

create table entry_sheet_optional_v1 (
  id                        bigint auto_increment not null,
  job_type                  varchar(1024),
  self_pr                   varbinary(6000),
  feats                     varbinary(6000),
  club                      varbinary(6000),
  site_account              varbinary(2000),
  programming_year          integer,
  programming_level         varchar(1024),
  programming_level_other   varchar(1000),
  middleware_lebel          varchar(1024),
  middleware_lebel_other    varchar(1000),
  license                   varchar(1000),
  portfolio                 tinyint(1) default 0,
  portfolio_url             varbinary(6000),
  design_level              varchar(1024),
  design_level_other        varchar(1000),
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_entry_sheet_optional_v1 primary key (id))
;

create table entry_user (
  id                        bigint auto_increment not null,
  companyid                 bigint not null,
  birthday                  varbinary(255) not null,
  last_name_kana            varbinary(18) not null,
  middle_name_kana          varbinary(18),
  first_name_kana           varbinary(18) not null,
  email                     varbinary(512) not null,
  sex                       integer not null,
  password                  varbinary(40) not null,
  entry_date                datetime not null,
  entry_type                integer not null,
  entry_status              integer not null,
  middle_name               varbinary(18),
  data_url                  varchar(1024),
  last_name                 varbinary(18) not null,
  activation                tinyint(1) default 0 not null,
  delflag                   tinyint(1) default 0 not null,
  application_year          integer not null,
  first_name                varbinary(18) not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint uq_entry_user_email unique (email),
  constraint pk_entry_user primary key (id))
;

create table entry_user_comments (
  id                        bigint auto_increment not null,
  entry_userid              bigint not null,
  commentsid                bigint not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_entry_user_comments primary key (id))
;

create table entry_user_communication (
  id                        bigint auto_increment not null,
  entry_userid              bigint not null,
  comments                  varbinary(2048) not null,
  conditiontype             integer not null,
  datetime                  datetime not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_entry_user_communication primary key (id))
;

create table entry_user_event (
  id                        bigint auto_increment not null,
  eventid                   bigint not null,
  entry_userid              bigint not null,
  event_status              integer not null,
  enquete_status            tinyint(1) default 0 not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_entry_user_event primary key (id))
;

create table entry_user_event_schedule (
  id                        bigint auto_increment not null,
  entry_userid              bigint not null,
  event_scheduleid          bigint not null,
  attendance                tinyint(1) default 0 not null,
  selection_result          integer,
  table_number              integer,
  evaluation                integer,
  cancel_flag               tinyint(1) default 0 not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_entry_user_event_schedule primary key (id))
;

create table entry_user_group (
  id                        bigint auto_increment not null,
  entry_userid              bigint not null,
  groupid                   bigint not null,
  fixation                  tinyint(1) default 0 not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_entry_user_group primary key (id))
;

create table entry_user_job_type (
  id                        bigint auto_increment not null,
  entry_userid              bigint not null,
  job_typeid                bigint not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_entry_user_job_type primary key (id))
;

create table entry_user_mail_log (
  id                        bigint auto_increment not null,
  mail_logid                bigint not null,
  entry_userid              bigint not null,
  status                    integer not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_entry_user_mail_log primary key (id))
;

create table entry_user_school (
  id                        bigint auto_increment not null,
  foreign_schoolid          bigint,
  school_subjectid          bigint,
  entry_userid              bigint,
  schoolid                  bigint,
  school_departmentid       bigint,
  classification            integer not null,
  graduation                datetime not null,
  graduation_type           integer not null,
  lab                       varbinary(40),
  club                      varbinary(40),
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint uq_entry_user_school_1 unique (foreign_schoolid),
  constraint pk_entry_user_school primary key (id))
;

create table event (
  id                        bigint auto_increment not null,
  event_groupid             bigint,
  next_eventid              bigint,
  groupid                   bigint not null,
  enquete_code              varchar(2048) not null,
  enquete_url               varchar(1024) not null,
  delflag                   tinyint(1) default 0 not null,
  message                   varchar(3000),
  cancelable                tinyint(1) default 0 not null,
  modifiable                tinyint(1) default 0 not null,
  reception_to              datetime,
  reception_from            datetime not null,
  step_name                 varchar(20) not null,
  name                      varchar(20) not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint uq_event_1 unique (next_eventid),
  constraint pk_event primary key (id))
;

create table event_group (
  id                        bigint auto_increment not null,
  job_typeid                bigint not null,
  type                      integer not null,
  name                      varchar(32) not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_event_group primary key (id))
;

create table event_schedule (
  id                        bigint auto_increment not null,
  eventid                   bigint not null,
  venueid                   bigint not null,
  groupid                   integer not null,
  date_time                 datetime not null,
  capacity_sum              integer not null,
  capacity_male             integer not null,
  capacity_female           integer not null,
  cybozu_eventid            bigint,
  reception_to              datetime not null,
  time_minute               integer not null,
  reception_from            datetime not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_event_schedule primary key (id))
;

create table event_schedule_employee (
  id                        bigint auto_increment not null,
  employee_id               bigint not null,
  event_scheduleid          bigint not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_event_schedule_employee primary key (id))
;

create table facility (
  id                        bigint auto_increment not null,
  venueid                   bigint not null,
  cybozid                   bigint not null,
  name                      varchar(64) not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint uq_facility_cybozid unique (cybozid),
  constraint uq_facility_name unique (name),
  constraint pk_facility primary key (id))
;

create table foreign_school (
  id                        bigint auto_increment not null,
  subject                   varbinary(128) not null,
  department                varbinary(128) not null,
  name                      varbinary(128) not null,
  division                  integer not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_foreign_school primary key (id))
;

create table group_condition_comments (
  id                        bigint auto_increment not null,
  groupid                   bigint not null,
  commentsid                bigint not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_group_condition_comments primary key (id))
;

create table group_condition_event (
  id                        bigint auto_increment not null,
  groupid                   bigint not null,
  eventid                   bigint not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_group_condition_event primary key (id))
;

create table group_condition_group (
  id                        bigint auto_increment not null,
  groupid                   bigint not null,
  condition_groupid         bigint not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_group_condition_group primary key (id))
;

create table group_condition_job_type (
  groupid                   bigint not null,
  job_typeid                bigint not null,
  refusal                   tinyint(1) default 0 not null,
  updated_at                datetime not null,
  lock_version              bigint not null)
;

create table group_condition_school_group (
  id                        bigint auto_increment not null,
  school_groupid            bigint not null,
  groupid                   bigint not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_group_condition_school_group primary key (id))
;

create table group_mail_log (
  id                        bigint auto_increment not null,
  groupid                   bigint not null,
  mail_logid                bigint not null,
  status                    integer not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_group_mail_log primary key (id))
;

create table inquiry (
  id                        bigint auto_increment not null,
  entry_userid              bigint,
  employee_id               bigint,
  answer                    varbinary(2048),
  content                   varbinary(2048) not null,
  type                      integer not null,
  email                     varbinary(512) not null,
  first_name                varbinary(18) not null,
  middle_name               varbinary(18),
  last_name                 varbinary(18) not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_inquiry primary key (id))
;

create table interviewer (
  id                        bigint auto_increment not null,
  employee_id               bigint,
  status                    integer not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint uq_interviewer_1 unique (employee_id),
  constraint pk_interviewer primary key (id))
;

create table job_type (
  id                        bigint auto_increment not null,
  companyid                 bigint not null,
  name                      varchar(16) not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_job_type primary key (id))
;

create table mail_log (
  id                        bigint auto_increment not null,
  send_datetime             datetime not null,
  destination               integer not null,
  subject                   varchar(128) not null,
  body                      varchar(3000) not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_mail_log primary key (id))
;

create table mail_template (
  id                        bigint auto_increment not null,
  subject                   varchar(128) not null,
  body                      varchar(3000) not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_mail_template primary key (id))
;

create table mobile_phone (
  id                        bigint auto_increment not null,
  entry_userid              bigint not null,
  number1                   varbinary(8) not null,
  number2                   varbinary(8) not null,
  number3                   varbinary(8) not null,
  email                     varbinary(512),
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_mobile_phone primary key (id))
;

create table postal_code (
  id                        bigint auto_increment not null,
  prefecturesid             bigint not null,
  place_name                varchar(200) not null,
  code_number1              integer not null,
  code_number2              integer not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_postal_code primary key (id))
;

create table prefectures (
  id                        bigint auto_increment not null,
  area                      integer not null,
  name                      varchar(8) not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint uq_prefectures_name unique (name),
  constraint pk_prefectures primary key (id))
;

create table report_record (
  id                        bigint auto_increment not null,
  goal                      integer not null,
  record_date               datetime not null,
  report_count              integer not null,
  report_type               integer not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_report_record primary key (id))
;

create table school (
  id                        bigint auto_increment not null,
  prefecturesid             bigint not null,
  delflag                   tinyint(1) default 0 not null,
  name                      varbinary(128) not null,
  division                  integer not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_school primary key (id))
;

create table school_department (
  id                        bigint auto_increment not null,
  schoolid                  bigint,
  department                varbinary(128) not null,
  delflag                   tinyint(1) default 0 not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_school_department primary key (id))
;

create table school_group (
  id                        bigint auto_increment not null,
  name                      varchar(128) not null,
  lock_version              bigint not null,
  updated_at                datetime not null,
  constraint uq_school_group_name unique (name),
  constraint pk_school_group primary key (id))
;

create table school_group_condition (
  id                        bigint auto_increment not null,
  school_subjectid          bigint,
  school_departmentid       bigint,
  schoolid                  bigint,
  school_groupid            bigint not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_school_group_condition primary key (id))
;

create table school_group_mail_log (
  school_groupid            bigint not null,
  mail_logid                bigint not null,
  status                    integer,
  updated_at                datetime not null,
  lock_version              bigint not null)
;

create table school_subject (
  id                        bigint auto_increment not null,
  school_departmentid       bigint not null,
  subject                   varbinary(128) not null,
  delflag                   tinyint(1) default 0 not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_school_subject primary key (id))
;

create table system_master (
  id                        bigint auto_increment not null,
  config_key                varchar(16) not null,
  config_value              varchar(1024) not null,
  description               varchar(1024) not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint uq_system_master_config_key unique (config_key),
  constraint pk_system_master primary key (id))
;

create table transportation (
  id                        bigint auto_increment not null,
  venueid                   bigint not null,
  name                      varchar(64) not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint pk_transportation primary key (id))
;

create table venue (
  id                        bigint auto_increment not null,
  contact                   varchar(64) not null,
  name                      varchar(32) not null,
  address                   varchar(300) not null,
  updated_at                datetime not null,
  lock_version              bigint not null,
  constraint uq_venue_name unique (name),
  constraint pk_venue primary key (id))
;

alter table additional_text add constraint fk_additional_text_event_1 foreign key (eventid) references event (id) on delete restrict on update restrict;
create index ix_additional_text_event_1 on additional_text (eventid);
alter table address add constraint fk_address_entryUser_2 foreign key (entry_userid) references entry_user (id) on delete restrict on update restrict;
create index ix_address_entryUser_2 on address (entry_userid);
alter table address add constraint fk_address_prefectures_3 foreign key (prefecturesid) references prefectures (id) on delete restrict on update restrict;
create index ix_address_prefectures_3 on address (prefecturesid);
alter table address add constraint fk_address_postalCode_4 foreign key (postal_codeid) references postal_code (id) on delete restrict on update restrict;
create index ix_address_postalCode_4 on address (postal_codeid);
alter table admin_user add constraint fk_admin_user_employee_5 foreign key (employee_id) references employee (id) on delete restrict on update restrict;
create index ix_admin_user_employee_5 on admin_user (employee_id);
alter table call_history add constraint fk_call_history_entryUser_6 foreign key (entry_userid) references entry_user (id) on delete restrict on update restrict;
create index ix_call_history_entryUser_6 on call_history (entry_userid);
alter table complex_group add constraint fk_complex_group_employee_7 foreign key (employee_id) references employee (id) on delete restrict on update restrict;
create index ix_complex_group_employee_7 on complex_group (employee_id);
alter table complex_group add constraint fk_complex_group_company_8 foreign key (companyid) references company (id) on delete restrict on update restrict;
create index ix_complex_group_company_8 on complex_group (companyid);
alter table dashboard_report add constraint fk_dashboard_report_employee_9 foreign key (employee_id) references employee (id) on delete restrict on update restrict;
create index ix_dashboard_report_employee_9 on dashboard_report (employee_id);
alter table employee_company add constraint fk_employee_company_employee_10 foreign key (employee_id) references employee (id) on delete restrict on update restrict;
create index ix_employee_company_employee_10 on employee_company (employee_id);
alter table employee_company add constraint fk_employee_company_company_11 foreign key (companyid) references company (id) on delete restrict on update restrict;
create index ix_employee_company_company_11 on employee_company (companyid);
alter table entry_user add constraint fk_entry_user_company_12 foreign key (companyid) references company (id) on delete restrict on update restrict;
create index ix_entry_user_company_12 on entry_user (companyid);
alter table entry_user_comments add constraint fk_entry_user_comments_entryUser_13 foreign key (entry_userid) references entry_user (id) on delete restrict on update restrict;
create index ix_entry_user_comments_entryUser_13 on entry_user_comments (entry_userid);
alter table entry_user_comments add constraint fk_entry_user_comments_comments_14 foreign key (commentsid) references comments (id) on delete restrict on update restrict;
create index ix_entry_user_comments_comments_14 on entry_user_comments (commentsid);
alter table entry_user_communication add constraint fk_entry_user_communication_entryUser_15 foreign key (entry_userid) references entry_user (id) on delete restrict on update restrict;
create index ix_entry_user_communication_entryUser_15 on entry_user_communication (entry_userid);
alter table entry_user_event add constraint fk_entry_user_event_event_16 foreign key (eventid) references event (id) on delete restrict on update restrict;
create index ix_entry_user_event_event_16 on entry_user_event (eventid);
alter table entry_user_event add constraint fk_entry_user_event_entryUser_17 foreign key (entry_userid) references entry_user (id) on delete restrict on update restrict;
create index ix_entry_user_event_entryUser_17 on entry_user_event (entry_userid);
alter table entry_user_event_schedule add constraint fk_entry_user_event_schedule_entryUser_18 foreign key (entry_userid) references entry_user (id) on delete restrict on update restrict;
create index ix_entry_user_event_schedule_entryUser_18 on entry_user_event_schedule (entry_userid);
alter table entry_user_event_schedule add constraint fk_entry_user_event_schedule_eventSchedule_19 foreign key (event_scheduleid) references event_schedule (id) on delete restrict on update restrict;
create index ix_entry_user_event_schedule_eventSchedule_19 on entry_user_event_schedule (event_scheduleid);
alter table entry_user_group add constraint fk_entry_user_group_entryUser_20 foreign key (entry_userid) references entry_user (id) on delete restrict on update restrict;
create index ix_entry_user_group_entryUser_20 on entry_user_group (entry_userid);
alter table entry_user_group add constraint fk_entry_user_group_complexGroup_21 foreign key (groupid) references complex_group (id) on delete restrict on update restrict;
create index ix_entry_user_group_complexGroup_21 on entry_user_group (groupid);
alter table entry_user_job_type add constraint fk_entry_user_job_type_entryUser_22 foreign key (entry_userid) references entry_user (id) on delete restrict on update restrict;
create index ix_entry_user_job_type_entryUser_22 on entry_user_job_type (entry_userid);
alter table entry_user_job_type add constraint fk_entry_user_job_type_jobType_23 foreign key (job_typeid) references job_type (id) on delete restrict on update restrict;
create index ix_entry_user_job_type_jobType_23 on entry_user_job_type (job_typeid);
alter table entry_user_mail_log add constraint fk_entry_user_mail_log_mailLog_24 foreign key (mail_logid) references mail_log (id) on delete restrict on update restrict;
create index ix_entry_user_mail_log_mailLog_24 on entry_user_mail_log (mail_logid);
alter table entry_user_mail_log add constraint fk_entry_user_mail_log_entryUser_25 foreign key (entry_userid) references entry_user (id) on delete restrict on update restrict;
create index ix_entry_user_mail_log_entryUser_25 on entry_user_mail_log (entry_userid);
alter table entry_user_school add constraint fk_entry_user_school_foreignSchool_26 foreign key (foreign_schoolid) references foreign_school (id) on delete restrict on update restrict;
create index ix_entry_user_school_foreignSchool_26 on entry_user_school (foreign_schoolid);
alter table entry_user_school add constraint fk_entry_user_school_schoolSubject_27 foreign key (school_subjectid) references school_subject (id) on delete restrict on update restrict;
create index ix_entry_user_school_schoolSubject_27 on entry_user_school (school_subjectid);
alter table entry_user_school add constraint fk_entry_user_school_entryUser_28 foreign key (entry_userid) references entry_user (id) on delete restrict on update restrict;
create index ix_entry_user_school_entryUser_28 on entry_user_school (entry_userid);
alter table entry_user_school add constraint fk_entry_user_school_school_29 foreign key (schoolid) references school (id) on delete restrict on update restrict;
create index ix_entry_user_school_school_29 on entry_user_school (schoolid);
alter table entry_user_school add constraint fk_entry_user_school_schoolDepartment_30 foreign key (school_departmentid) references school_department (id) on delete restrict on update restrict;
create index ix_entry_user_school_schoolDepartment_30 on entry_user_school (school_departmentid);
alter table event add constraint fk_event_eventGroup_31 foreign key (event_groupid) references event_group (id) on delete restrict on update restrict;
create index ix_event_eventGroup_31 on event (event_groupid);
alter table event add constraint fk_event_event_32 foreign key (next_eventid) references event (id) on delete restrict on update restrict;
create index ix_event_event_32 on event (next_eventid);
alter table event add constraint fk_event_complexGroup_33 foreign key (groupid) references complex_group (id) on delete restrict on update restrict;
create index ix_event_complexGroup_33 on event (groupid);
alter table event_group add constraint fk_event_group_jobType_34 foreign key (job_typeid) references job_type (id) on delete restrict on update restrict;
create index ix_event_group_jobType_34 on event_group (job_typeid);
alter table event_schedule add constraint fk_event_schedule_event_35 foreign key (eventid) references event (id) on delete restrict on update restrict;
create index ix_event_schedule_event_35 on event_schedule (eventid);
alter table event_schedule add constraint fk_event_schedule_venue_36 foreign key (venueid) references venue (id) on delete restrict on update restrict;
create index ix_event_schedule_venue_36 on event_schedule (venueid);
alter table event_schedule_employee add constraint fk_event_schedule_employee_employee_37 foreign key (employee_id) references employee (id) on delete restrict on update restrict;
create index ix_event_schedule_employee_employee_37 on event_schedule_employee (employee_id);
alter table event_schedule_employee add constraint fk_event_schedule_employee_eventSchedule_38 foreign key (event_scheduleid) references event_schedule (id) on delete restrict on update restrict;
create index ix_event_schedule_employee_eventSchedule_38 on event_schedule_employee (event_scheduleid);
alter table facility add constraint fk_facility_venue_39 foreign key (venueid) references venue (id) on delete restrict on update restrict;
create index ix_facility_venue_39 on facility (venueid);
alter table group_condition_comments add constraint fk_group_condition_comments_complexGroup_40 foreign key (groupid) references complex_group (id) on delete restrict on update restrict;
create index ix_group_condition_comments_complexGroup_40 on group_condition_comments (groupid);
alter table group_condition_comments add constraint fk_group_condition_comments_comments_41 foreign key (commentsid) references comments (id) on delete restrict on update restrict;
create index ix_group_condition_comments_comments_41 on group_condition_comments (commentsid);
alter table group_condition_event add constraint fk_group_condition_event_complexGroup_42 foreign key (groupid) references complex_group (id) on delete restrict on update restrict;
create index ix_group_condition_event_complexGroup_42 on group_condition_event (groupid);
alter table group_condition_event add constraint fk_group_condition_event_event_43 foreign key (eventid) references event (id) on delete restrict on update restrict;
create index ix_group_condition_event_event_43 on group_condition_event (eventid);
alter table group_condition_group add constraint fk_group_condition_group_complexGroup_44 foreign key (groupid) references complex_group (id) on delete restrict on update restrict;
create index ix_group_condition_group_complexGroup_44 on group_condition_group (groupid);
alter table group_condition_group add constraint fk_group_condition_group_conditionGroup_45 foreign key (condition_groupid) references complex_group (id) on delete restrict on update restrict;
create index ix_group_condition_group_conditionGroup_45 on group_condition_group (condition_groupid);
alter table group_condition_job_type add constraint fk_group_condition_job_type_complexGroup_46 foreign key (groupid) references complex_group (id) on delete restrict on update restrict;
create index ix_group_condition_job_type_complexGroup_46 on group_condition_job_type (groupid);
alter table group_condition_job_type add constraint fk_group_condition_job_type_jobType_47 foreign key (job_typeid) references job_type (id) on delete restrict on update restrict;
create index ix_group_condition_job_type_jobType_47 on group_condition_job_type (job_typeid);
alter table group_condition_school_group add constraint fk_group_condition_school_group_schoolGroup_48 foreign key (school_groupid) references school_group (id) on delete restrict on update restrict;
create index ix_group_condition_school_group_schoolGroup_48 on group_condition_school_group (school_groupid);
alter table group_condition_school_group add constraint fk_group_condition_school_group_complexGroup_49 foreign key (groupid) references complex_group (id) on delete restrict on update restrict;
create index ix_group_condition_school_group_complexGroup_49 on group_condition_school_group (groupid);
alter table group_mail_log add constraint fk_group_mail_log_complexGroup_50 foreign key (groupid) references complex_group (id) on delete restrict on update restrict;
create index ix_group_mail_log_complexGroup_50 on group_mail_log (groupid);
alter table group_mail_log add constraint fk_group_mail_log_mailLog_51 foreign key (mail_logid) references mail_log (id) on delete restrict on update restrict;
create index ix_group_mail_log_mailLog_51 on group_mail_log (mail_logid);
alter table inquiry add constraint fk_inquiry_entryUser_52 foreign key (entry_userid) references entry_user (id) on delete restrict on update restrict;
create index ix_inquiry_entryUser_52 on inquiry (entry_userid);
alter table inquiry add constraint fk_inquiry_employee_53 foreign key (employee_id) references employee (id) on delete restrict on update restrict;
create index ix_inquiry_employee_53 on inquiry (employee_id);
alter table interviewer add constraint fk_interviewer_employee_54 foreign key (employee_id) references employee (id) on delete restrict on update restrict;
create index ix_interviewer_employee_54 on interviewer (employee_id);
alter table job_type add constraint fk_job_type_company_55 foreign key (companyid) references company (id) on delete restrict on update restrict;
create index ix_job_type_company_55 on job_type (companyid);
alter table mobile_phone add constraint fk_mobile_phone_entryUser_56 foreign key (entry_userid) references entry_user (id) on delete restrict on update restrict;
create index ix_mobile_phone_entryUser_56 on mobile_phone (entry_userid);
alter table postal_code add constraint fk_postal_code_prefectures_57 foreign key (prefecturesid) references prefectures (id) on delete restrict on update restrict;
create index ix_postal_code_prefectures_57 on postal_code (prefecturesid);
alter table school add constraint fk_school_prefectures_58 foreign key (prefecturesid) references prefectures (id) on delete restrict on update restrict;
create index ix_school_prefectures_58 on school (prefecturesid);
alter table school_department add constraint fk_school_department_school_59 foreign key (schoolid) references school (id) on delete restrict on update restrict;
create index ix_school_department_school_59 on school_department (schoolid);
alter table school_group_condition add constraint fk_school_group_condition_schoolSubject_60 foreign key (school_subjectid) references school_subject (id) on delete restrict on update restrict;
create index ix_school_group_condition_schoolSubject_60 on school_group_condition (school_subjectid);
alter table school_group_condition add constraint fk_school_group_condition_schoolDepartment_61 foreign key (school_departmentid) references school_department (id) on delete restrict on update restrict;
create index ix_school_group_condition_schoolDepartment_61 on school_group_condition (school_departmentid);
alter table school_group_condition add constraint fk_school_group_condition_school_62 foreign key (schoolid) references school (id) on delete restrict on update restrict;
create index ix_school_group_condition_school_62 on school_group_condition (schoolid);
alter table school_group_condition add constraint fk_school_group_condition_schoolGroup_63 foreign key (school_groupid) references school_group (id) on delete restrict on update restrict;
create index ix_school_group_condition_schoolGroup_63 on school_group_condition (school_groupid);
alter table school_group_mail_log add constraint fk_school_group_mail_log_schoolGroup_64 foreign key (school_groupid) references school_group (id) on delete restrict on update restrict;
create index ix_school_group_mail_log_schoolGroup_64 on school_group_mail_log (school_groupid);
alter table school_group_mail_log add constraint fk_school_group_mail_log_mailLog_65 foreign key (mail_logid) references mail_log (id) on delete restrict on update restrict;
create index ix_school_group_mail_log_mailLog_65 on school_group_mail_log (mail_logid);
alter table school_subject add constraint fk_school_subject_schoolDepartment_66 foreign key (school_departmentid) references school_department (id) on delete restrict on update restrict;
create index ix_school_subject_schoolDepartment_66 on school_subject (school_departmentid);
alter table transportation add constraint fk_transportation_venue_67 foreign key (venueid) references venue (id) on delete restrict on update restrict;
create index ix_transportation_venue_67 on transportation (venueid);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table additional_text;

drop table address;

drop table admin_user;

drop table call_history;

drop table comments;

drop table company;

drop table complex_group;

drop table dashboard_report;

drop table employee;

drop table employee_company;

drop table entry_sheet_optional_v1;

drop table entry_user;

drop table entry_user_comments;

drop table entry_user_communication;

drop table entry_user_event;

drop table entry_user_event_schedule;

drop table entry_user_group;

drop table entry_user_job_type;

drop table entry_user_mail_log;

drop table entry_user_school;

drop table event;

drop table event_group;

drop table event_schedule;

drop table event_schedule_employee;

drop table facility;

drop table foreign_school;

drop table group_condition_comments;

drop table group_condition_event;

drop table group_condition_group;

drop table group_condition_job_type;

drop table group_condition_school_group;

drop table group_mail_log;

drop table inquiry;

drop table interviewer;

drop table job_type;

drop table mail_log;

drop table mail_template;

drop table mobile_phone;

drop table postal_code;

drop table prefectures;

drop table report_record;

drop table school;

drop table school_department;

drop table school_group;

drop table school_group_condition;

drop table school_group_mail_log;

drop table school_subject;

drop table system_master;

drop table transportation;

drop table venue;

SET FOREIGN_KEY_CHECKS=1;

