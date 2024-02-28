CREATE TABLE IF NOT EXISTS `users` (
    `idusers` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `age` SMALLINT(3) NOT NULL,
    `phone_number` BIGINT(10) NOT NULL,
    `address` VARCHAR(200) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    `role` SMALLINT(2) NOT NULL,
    PRIMARY KEY (`idusers`)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;