CREATE TABLE IF NOT EXISTS `users` (
    `idusers` INT NOT NULL AUTO_INCREMENT,
    `user_name` VARCHAR(100) NOT NULL,
    `user_age` SMALLINT(3) NOT NULL,
    `user_phone_number` BIGINT(10) NOT NULL,
    `user_address` VARCHAR(200) NOT NULL,
    `user_password` VARCHAR(100) NOT NULL,
    `user_role` SMALLINT(2) NOT NULL,
    PRIMARY KEY (`idusers`)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;