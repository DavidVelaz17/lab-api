CREATE TABLE IF NOT EXISTS `contents` (
    `content_id` INT NOT NULL AUTO_INCREMENT,
    `content_name` VARCHAR(200) NOT NULL,
    `content_units` VARCHAR(50) NULL,
    PRIMARY KEY (`content_id`))
    ENGINE = InnoDB
