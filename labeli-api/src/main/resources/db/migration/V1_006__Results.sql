CREATE TABLE IF NOT EXISTS `results` (
    `idresults` INT NOT NULL,
    `idcustomers` INT NULL,
    `idtests` INT NULL,
    `result_timestamp` VARCHAR(45) NULL,
    `result_note` VARCHAR(45) NULL,
    PRIMARY KEY (`idresults`),
    INDEX `idcustomer_idx` (`idcustomers` ASC) VISIBLE,
    INDEX `idtests_idx` (`idtests` ASC) VISIBLE,
    CONSTRAINT `fk_results_customers`
    FOREIGN KEY (`idcustomers`)
    REFERENCES `customers` (`idcustomers`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT `idtests`
    FOREIGN KEY (`idtests`)
    REFERENCES `tests` (`idtests`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE = InnoDB