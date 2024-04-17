CREATE TABLE category
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime NULL,
    updated_at datetime NULL,
    title      VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE joined_table_instructor
(
    user_id        INT NOT NULL,
    specialization VARCHAR(255) NULL,
    CONSTRAINT pk_joinedtable_instructor PRIMARY KEY (user_id)
);

CREATE TABLE joined_table_mentor
(
    user_id INT   NOT NULL,
    company VARCHAR(255) NULL,
    rating  FLOAT NOT NULL,
    CONSTRAINT pk_joinedtable_mentor PRIMARY KEY (user_id)
);

CREATE TABLE joined_table_user
(
    id       INT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_joinedtable_user PRIMARY KEY (id)
);

CREATE TABLE mapped_supper_class_instructor
(
    id             INT NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    specialization VARCHAR(255) NULL,
    CONSTRAINT pk_mappedsupperclass_instructor PRIMARY KEY (id)
);

CREATE TABLE mapped_supper_class_mentor
(
    id       INT   NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    company  VARCHAR(255) NULL,
    rating   FLOAT NOT NULL,
    CONSTRAINT pk_mappedsupperclass_mentor PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_at    datetime NULL,
    updated_at    datetime NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    price DOUBLE NOT NULL,
    image         VARCHAR(255) NULL,
    category_id   BIGINT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE single_table_user
(
    id             INT   NOT NULL,
    user_type      CHAR NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    specialization VARCHAR(255) NULL,
    company        VARCHAR(255) NULL,
    rating         FLOAT NOT NULL,
    CONSTRAINT pk_singletable_user PRIMARY KEY (id)
);

CREATE TABLE table_per_class_instructor
(
    id             INT NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    specialization VARCHAR(255) NULL,
    CONSTRAINT pk_tableperclass_instructor PRIMARY KEY (id)
);

CREATE TABLE table_per_class_mentor
(
    id       INT   NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    company  VARCHAR(255) NULL,
    rating   FLOAT NOT NULL,
    CONSTRAINT pk_tableperclass_mentor PRIMARY KEY (id)
);

CREATE TABLE table_per_class_user
(
    id       INT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_tableperclass_user PRIMARY KEY (id)
);

ALTER TABLE joined_table_instructor
    ADD CONSTRAINT FK_JOINEDTABLE_INSTRUCTOR_ON_USER FOREIGN KEY (user_id) REFERENCES joined_table_user (id);

ALTER TABLE joined_table_mentor
    ADD CONSTRAINT FK_JOINEDTABLE_MENTOR_ON_USER FOREIGN KEY (user_id) REFERENCES joined_table_user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);