use notifier;

CREATE TABLE `notifier`.`user_details` (
  `email` VARCHAR(50)  NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NULL,
  PRIMARY KEY (`email`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);

