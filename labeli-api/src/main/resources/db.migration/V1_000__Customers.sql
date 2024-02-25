CREATE TABLE IF NOT EXISTS `customers` (
    `idcustomers` INT NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `age` SMALLINT(3) NOT NULL,
    `phone_number` BIGINT(10) NOT NULL,
    `address` VARCHAR(200) NOT NULL,
    `dob` DATE NOT NULL,
    `status` SMALLINT(2) NOT NULL,
    `idtests` INT NOT NULL,
    PRIMARY KEY (`idcustomers`),
    CONSTRAINT `idtests`
    FOREIGN KEY (`idtests`)
    REFERENCES `tests` (`idtests`)
   )ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
    COLLATE = utf8_spanish2_ci;