CREATE DATABASE `bs_edu`;

GRANT USAGE ON *.* TO `blackstar`@`localhost` IDENTIFIED BY 'therion' REQUIRE NONE;

GRANT USAGE ON *.* TO `blackstar`@`localhost` REQUIRE NONE;
GRANT References  ON `bs_edu`.* TO `blackstar`@`localhost`;
GRANT Create View  ON `bs_edu`.* TO `blackstar`@`localhost`;
GRANT USAGE  ON `bs_edu`.* TO `blackstar`@`localhost` WITH GRANT OPTION;
GRANT Alter routine  ON `bs_edu`.* TO `blackstar`@`localhost`;
GRANT Create  ON `bs_edu`.* TO `blackstar`@`localhost`;
GRANT Lock tables  ON `bs_edu`.* TO `blackstar`@`localhost`;
GRANT Insert  ON `bs_edu`.* TO `blackstar`@`localhost`;
GRANT Delete  ON `bs_edu`.* TO `blackstar`@`localhost`;
GRANT Drop  ON `bs_edu`.* TO `blackstar`@`localhost`;
GRANT Alter  ON `bs_edu`.* TO `blackstar`@`localhost`;
GRANT Create temporary tables  ON `bs_edu`.* TO `blackstar`@`localhost`;
GRANT Index  ON `bs_edu`.* TO `blackstar`@`localhost`;
GRANT Create routine  ON `bs_edu`.* TO `blackstar`@`localhost`;
GRANT Trigger  ON `bs_edu`.* TO `blackstar`@`localhost`;
GRANT Show view  ON `bs_edu`.* TO `blackstar`@`localhost`;
GRANT Select  ON `bs_edu`.* TO `blackstar`@`localhost`;
GRANT Update  ON `bs_edu`.* TO `blackstar`@`localhost`;
GRANT Execute  ON `bs_edu`.* TO `blackstar`@`localhost`;
GRANT Event  ON `bs_edu`.* TO `blackstar`@`localhost`;

USE bs_edu;

CREATE TABLE bs_edu.points (
  idPoints INT AUTO_INCREMENT NOT NULL,
  namePoints VARCHAR(20),
  latPoints DOUBLE,
  longPoints DOUBLE,
  descrPoints VARCHAR(20),
  PRIMARY KEY (idPoints)
) ENGINE = InnoDB ROW_FORMAT = DEFAULT CHARACTER SET utf8;
