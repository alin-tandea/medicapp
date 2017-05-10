-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema medicdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema medicdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `medicdb` DEFAULT CHARACTER SET utf8 ;
USE `medicdb` ;

-- -----------------------------------------------------
-- Table `medicdb`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicdb`.`patient` (
  `idpatient` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `idcardnumber` VARCHAR(45) NULL DEFAULT NULL,
  `cnp` VARCHAR(45) NULL DEFAULT NULL,
  `birthdate` DATETIME NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idpatient`))
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicdb`.`staff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicdb`.`staff` (
  `idstaff` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `username` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `role` INT(11) NULL DEFAULT NULL,
  `workdays` VARCHAR(7) NULL DEFAULT NULL,
  PRIMARY KEY (`idstaff`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicdb`.`consultation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicdb`.`consultation` (
  `idconsultation` INT(11) NOT NULL AUTO_INCREMENT,
  `datestart` DATETIME NULL DEFAULT NULL,
  `dateend` DATETIME NULL DEFAULT NULL,
  `reason` VARCHAR(100) NULL DEFAULT NULL,
  `staff_idstaff` INT(11) NOT NULL,
  `patient_idpatient` INT(11) NOT NULL,
  PRIMARY KEY (`idconsultation`),
  CONSTRAINT `fk_consultation_patient1`
    FOREIGN KEY (`patient_idpatient`)
    REFERENCES `medicdb`.`patient` (`idpatient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_consultation_staff`
    FOREIGN KEY (`staff_idstaff`)
    REFERENCES `medicdb`.`staff` (`idstaff`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicdb`.`workschedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicdb`.`workschedule` (
  `idworkschedule` INT(11) NOT NULL AUTO_INCREMENT,
  `workday` INT(11) NULL DEFAULT NULL,
  `starthour` INT(11) NULL DEFAULT NULL,
  `endhour` INT(11) NULL DEFAULT NULL,
  `staff_idstaff` INT(11) NOT NULL,
  PRIMARY KEY (`idworkschedule`),
  INDEX `fk_workschedule_staff1_idx` (`staff_idstaff` ASC),
  CONSTRAINT `fk_workschedule_staff1`
    FOREIGN KEY (`staff_idstaff`)
    REFERENCES `medicdb`.`staff` (`idstaff`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
