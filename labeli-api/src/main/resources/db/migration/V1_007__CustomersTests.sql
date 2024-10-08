CREATE TABLE IF NOT EXISTS `customers_tests` (
    `idcustomers_tests` INT NOT NULL AUTO_INCREMENT,
    `idcustomers` INT NULL,
    `idtests` INT NULL,
    `test_status` SMALLINT(2) NOT NULL,
    `price_by_test` DECIMAL(10,2) NULL DEFAULT 0,
    PRIMARY KEY (`idcustomers_tests`),
    INDEX `idcustomers_idx` (`idcustomers` ASC) VISIBLE,
    INDEX `idtests_idx` (`idtests` ASC) VISIBLE,
    CONSTRAINT `fk_customers_idcustomers`
    FOREIGN KEY (`idcustomers`)
    REFERENCES `customers` (`idcustomers`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT `fk_customers_idtests`
    FOREIGN KEY (`idtests`)
    REFERENCES `tests` (`idtests`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE = InnoDB