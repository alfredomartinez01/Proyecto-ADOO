-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nombreCliente` VARCHAR(45) NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Ingrediente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Ingrediente` (
  `idIngrediente` INT NOT NULL AUTO_INCREMENT,
  `nombreIngrediente` VARCHAR(60) NULL,
  `costoIngrediente` DECIMAL NOT NULL,
  PRIMARY KEY (`idIngrediente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Restaurante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Restaurante` (
  `idRestaurante` INT NOT NULL AUTO_INCREMENT,
  `nombreRest` VARCHAR(45) NULL,
  `local` INT NULL,
  `telefono` INT(10) NULL,
  `nombreUsuario` VARCHAR(45) NULL,
  `contrasena` VARCHAR(100) NULL,
  PRIMARY KEY (`idRestaurante`)
)ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Menu` (
  `idMenu` INT NOT NULL,
  `idRestaurante` INT NOT NULL,
  PRIMARY KEY (`idMenu`),
  INDEX `idRestaurante_idx` (`idRestaurante` ASC),
  CONSTRAINT `idRestaurante`
    FOREIGN KEY (`idRestaurante`)
    REFERENCES `mydb`.`Restaurante` (`idRestaurante`)
    ON DELETE CASCADE
    ON UPDATE CASCADE) ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Orden` (
  `idOrden` INT NOT NULL AUTO_INCREMENT,
  `idCliente` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `hora` TIME NOT NULL,
  PRIMARY KEY (`idOrden`),
  INDEX `idOrden_idx` (`idOrden` ASC),
  CONSTRAINT `idCliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Platillo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Platillo` (
  `idPlatillo` INT NOT NULL AUTO_INCREMENT,
  `idMenu` INT NOT NULL,
  `nombrePlatillo` VARCHAR(45) NULL,
  `costoPlatillo` DECIMAL NOT NULL,
  `composicion` VARCHAR(100) NULL,
  PRIMARY KEY (`idPlatillo`),
  INDEX `idMenu_idx` (`idMenu` ASC),
  CONSTRAINT `idMenu`
    FOREIGN KEY (`idMenu`)
    REFERENCES `mydb`.`Menu` (`idMenu`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Agrega`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Agrega` (
  `idPlatillo` INT NOT NULL,
  `idIngrediente` INT NOT NULL,
  PRIMARY KEY (`idPlatillo`, `idIngrediente`),
  INDEX `idIngrediente_idx` (`idIngrediente` ASC),
  CONSTRAINT `idIngrediente`
    FOREIGN KEY (`idIngrediente`)
    REFERENCES `mydb`.`Ingrediente` (`idIngrediente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idPlatillo`
    FOREIGN KEY (`idPlatillo`)
    REFERENCES `mydb`.`Platillo` (`idPlatillo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Contiene`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Contiene` (
  `idPlatillo` INT NOT NULL,
  `idOrden` INT NOT NULL,
  PRIMARY KEY (`idPlatillo`, `idOrden`),
  INDEX `idOrden_idx` (`idOrden` ASC),
  CONSTRAINT `idPlatillo_contiene`
    FOREIGN KEY (`idPlatillo`)
    REFERENCES `mydb`.`Platillo` (`idPlatillo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idOrden_contiene`
    FOREIGN KEY (`idOrden`)
    REFERENCES `mydb`.`Orden` (`idOrden`)
    ON DELETE CASCADE
    ON UPDATE CASCADE) ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Horario_restaurante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Horario_restaurante` (
  `dia` VARCHAR(12) NOT NULL,
  `horaApertura` TIME NOT NULL,
  `horaCierre` TIME NOT NULL,
  `idRestaurante` INT NOT NULL,
  PRIMARY KEY (`dia`, `horaApertura`, `horaCierre`, `idRestaurante`),
  INDEX `idRestaurante_idx` (`idRestaurante` ASC),
  CONSTRAINT `idRestaurante_horario`
    FOREIGN KEY (`idRestaurante`)
    REFERENCES `mydb`.`Restaurante` (`idRestaurante`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pago` (
  `idPago` INT NOT NULL AUTO_INCREMENT,
  `idCliente` INT NOT NULL,
  `montoTotal` DECIMAL NOT NULL,
  `noCuenta` INT(18) NULL,
  `cvv` INT(4) NULL,
  `fechaCad` DATE NULL,
  `tipo` TINYINT NOT NULL,
  PRIMARY KEY (`idPago`, `idCliente`),
  INDEX `idCliente_idx` (`idCliente` ASC),
  CONSTRAINT `idCliente_pago`
    FOREIGN KEY (`idCliente`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;