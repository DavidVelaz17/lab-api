CREATE TABLE IF NOT EXISTS `order_test` (
    `order_test_id` INT NOT NULL AUTO_INCREMENT,
    `order_id` INT NOT NULL,
    `test_id` INT NOT NULL,
    INDEX `fk_orders_has_tests_tests1_idx` (`test_id` ASC) VISIBLE,
    INDEX `fk_orders_has_tests_orders1_idx` (`order_id` ASC) VISIBLE,
    PRIMARY KEY (`order_test_id`),
    CONSTRAINT `fk_orders_has_tests_orders1`
    FOREIGN KEY (`order_id`)
    REFERENCES `orders` (`idorders`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT `fk_orders_has_tests_tests1`
    FOREIGN KEY (`test_id`)
    REFERENCES `tests` (`idtests`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE = InnoDB