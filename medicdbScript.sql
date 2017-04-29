
CREATE SCHEMA IF NOT EXISTS `medicdb` DEFAULT CHARACTER SET utf8 ;
USE `medicdb` ;

-- -----------------------------------------------------
-- Table `medicdb`.`staff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicdb`.`staff` (
  `idstaff` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `role` INT NULL,
  `workdays` VARCHAR(7) NULL,
  PRIMARY KEY (`idstaff`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medicdb`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicdb`.`patient` (
  `idpatient` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `idcardnumber` VARCHAR(45) NULL,
  `cnp` VARCHAR(45) NULL,
  `birthdate` DATETIME NULL,
  `address` VARCHAR(45) NULL,
  PRIMARY KEY (`idpatient`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medicdb`.`consultation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicdb`.`consultation` (
  `idconsultation` INT NOT NULL,
  `datestart` DATETIME NULL,
  `dateend` DATETIME NULL,
  `reason` VARCHAR(100) NULL,
  `staff_idstaff` INT NOT NULL,
  `patient_idpatient` INT NOT NULL,
  PRIMARY KEY (`idconsultation`),
  INDEX `fk_consultation_staff_idx` (`staff_idstaff` ASC),
  INDEX `fk_consultation_patient1_idx` (`patient_idpatient` ASC),
  CONSTRAINT `fk_consultation_staff`
    FOREIGN KEY (`staff_idstaff`)
    REFERENCES `medicdb`.`staff` (`idstaff`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_consultation_patient1`
    FOREIGN KEY (`patient_idpatient`)
    REFERENCES `medicdb`.`patient` (`idpatient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

