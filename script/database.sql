CREATE TABLE mybatis1.tbl_department (
	id int NOT NULL AUTO_INCREMENT,
	dep_name varchar(100) NULL,
	CONSTRAINT tbl_department_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci ;


CREATE TABLE mybatis1.tbl_employee (
	id int NOT NULL AUTO_INCREMENT,
	last_name varchar(100) NULL,
	gender varchar(100) NULL,
	d_id int NULL,
	CONSTRAINT tbl_employee_PK PRIMARY KEY (id),
	CONSTRAINT tbl_employee_tbl_department_FK FOREIGN KEY (d_id) REFERENCES mybatis1.tbl_department(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci ;
