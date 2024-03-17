CREATE TABLE IF NOT EXISTS `tests` (
    `idtests` INT NOT NULL,
    `test_name` VARCHAR(50) NOT NULL,
    `test_price` INT NOT NULL,
    PRIMARY KEY (`idtests`))
    ENGINE = InnoDB