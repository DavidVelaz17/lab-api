CREATE TABLE IF NOT EXISTS `contents_results` (
    `content_result_id` INT NOT NULL AUTO_INCREMENT,
    `result_id` INT NOT NULL,
    `content_id` INT NOT NULL,
    `result_value` VARCHAR(300),
    INDEX `fk_contents_has_results_results1_idx` (`result_id` ASC) VISIBLE,
    INDEX `fk_contents_has_results_contents1_idx` (`content_id` ASC) VISIBLE,
    PRIMARY KEY (`content_result_id`),
    CONSTRAINT `fk_contents_has_results_contents1`
    FOREIGN KEY (`content_id`)
    REFERENCES `contents` (`content_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT `fk_contents_has_results_results1`
    FOREIGN KEY (`result_id`)
    REFERENCES `results` (`idresults`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE = InnoDB