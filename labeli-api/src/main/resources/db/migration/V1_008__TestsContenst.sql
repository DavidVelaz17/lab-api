CREATE TABLE IF NOT EXISTS `test_contents` (
    `test_content_id` INT NOT NULL AUTO_INCREMENT,
    `tests_id` INT NOT NULL,
    `content_id` INT NOT NULL,
    INDEX `fk_tests_has_contents_contents1_idx` (`content_id` ASC) VISIBLE,
    INDEX `fk_tests_has_contents_tests1_idx` (`tests_id` ASC) VISIBLE,
    PRIMARY KEY (`test_content_id`),
    CONSTRAINT `fk_tests_has_contents_tests1`
    FOREIGN KEY (`tests_id`)
    REFERENCES `tests` (`idtests`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT `fk_tests_has_contents_contents1`
    FOREIGN KEY (`content_id`)
    REFERENCES `contents` (`content_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE = InnoDB