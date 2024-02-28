CREATE TABLE IF NOT EXISTS `customers` (
    `idcustomers` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `age` SMALLINT(3) NOT NULL,
    `phone_number` BIGINT NOT NULL,
    `address` VARCHAR(200) NOT NULL,
    `date_of_birth` DATE NOT NULL,
    `status` SMALLINT(2) NOT NULL,
    PRIMARY KEY (`idcustomers`)
   )ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;