CREATE TABLE IF NOT EXISTS `orders` (
    `idorders` INT NOT NULL,
    `idcustomers` INT NULL,
    `idusers` INT NULL,
    `order_timestamp` VARCHAR(45) NULL,
    `order_deposit` DOUBLE NULL,
    `order_total` DOUBLE NOT NULL,
    `order_notes` VARCHAR(200) NULL,
    PRIMARY KEY (`idorders`),
    INDEX `idcustomers_idx` (`idcustomers` ASC) VISIBLE,
    INDEX `idusers_idx` (`idusers` ASC) VISIBLE,
    CONSTRAINT `idcustomers`
    FOREIGN KEY (`idcustomers`)
    REFERENCES `customers` (`idcustomers`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT `idusers`
    FOREIGN KEY (`idusers`)
    REFERENCES `users` (`idusers`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE = InnoDB