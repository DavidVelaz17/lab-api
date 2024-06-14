CREATE TABLE IF NOT EXISTS `references` (
    `idreferences` INT NOT NULL AUTO_INCREMENT,
    `content_id` INT NOT NULL,
    `v_ref_text` VARCHAR(500) NULL,
    `v_max` VARCHAR(40) NULL,
    `v_min` VARCHAR(40) NULL,
    PRIMARY KEY (`idreferences`),
    INDEX `content_id_idx` (`content_id` ASC) VISIBLE,
    CONSTRAINT `content_id`
    FOREIGN KEY (`content_id`)
    REFERENCES `contents` (`content_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB