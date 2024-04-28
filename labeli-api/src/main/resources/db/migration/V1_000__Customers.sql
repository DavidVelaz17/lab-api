CREATE TABLE IF NOT EXISTS `customers` (
    `idcustomers` INT NOT NULL AUTO_INCREMENT,
    `customer_name` VARCHAR(100) NOT NULL,
    `customer_age` SMALLINT(3) NOT NULL,
    `customer_phone_number` BIGINT NOT NULL,
    `customer_address` VARCHAR(200) NOT NULL,
    `customer_date_of_birth` DATE NOT NULL,
    `customer_doctor_name` VARCHAR(100) NULL,
    PRIMARY KEY (`idcustomers`)
   )ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;