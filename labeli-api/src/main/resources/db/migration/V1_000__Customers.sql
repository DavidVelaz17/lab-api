CREATE TABLE IF NOT EXISTS `customers` (
    `idcustomers` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `age` SMALLINT(3) NOT NULL,
    `phoneNumber` BIGINT(10) NOT NULL,
    `address` VARCHAR(200) NOT NULL,
    `dateOfBirth` DATE NOT NULL,
    `status` SMALLINT(2) NOT NULL,
    PRIMARY KEY (`idcustomers`)
   )ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;