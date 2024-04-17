CREATE TABLE IF NOT EXISTS `tests` (
    `idtests` INT NOT NULL,
    `test_name` VARCHAR(100) NOT NULL,
    `test_price` FLOAT NOT NULL,
    `test_price_with_discount` FLOAT NULL,
    PRIMARY KEY (`idtests`))
    ENGINE = InnoDB
