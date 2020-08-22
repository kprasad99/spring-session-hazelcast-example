
CREATE TABLE TBL_USERS (
  						username VARCHAR(45) NOT NULL ,
  						password VARCHAR(60) NOT NULL ,
  						first_name VARCHAR(60) NOT NULL,
  						last_name VARCHAR(60),
  						enabled TINYINT NOT NULL DEFAULT 1,
  						account_non_expired TINYINT NOT NULL DEFAULT 1,
	                    account_non_locked TINYINT NOT NULL DEFAULT 1,
	                    credentials_non_expired TINYINT NOT NULL DEFAULT 1,
  						PRIMARY KEY (username));

CREATE TABLE TBL_USER_ROLES (
  							user_role_id int(11) NOT NULL AUTO_INCREMENT,
  							username varchar(45) NOT NULL,
  							role varchar(45) NOT NULL,
  							PRIMARY KEY (user_role_id),
  							--UNIQUE KEY uni_username_role (role,username),
  							CONSTRAINT fk_username FOREIGN KEY (username)
  							   REFERENCES TBL_USERS (username)
  							   ON DELETE CASCADE);

INSERT INTO TBL_USERS(username, password, first_name, last_name) values('admin', '$2y$04$tjwifI.EiBtgZoSGrOvDUurL/qZEObqOHeUamrc1EvJlBKto3YdpK', 'test', 'last');
INSERT INTO TBL_USER_ROLES(username, role) VALUES('admin', 'ADMIN');
