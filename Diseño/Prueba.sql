
CREATE TABLE IF NOT EXISTS `Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nombreCliente` VARCHAR(45) NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE = InnoDB;
SHOW WARNINGS;
-- -----------------------------------------------------
-- Table `mydb`.`Ingrediente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Ingrediente` (
  `idIngrediente` INT NOT NULL AUTO_INCREMENT,
  `nombreIngrediente` VARCHAR(60) NULL,
  `costoIngrediente` DECIMAL NOT NULL,
  PRIMARY KEY (`idIngrediente`)
) ENGINE = InnoDB;
SHOW WARNINGS;
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
) ENGINE = InnoDB;
SHOW WARNINGS;
-- -----------------------------------------------------
-- Table `mydb`.`Menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Menu` (
  `idMenu` INT NOT NULL AUTO_INCREMENT,
  `idRestaurante` INT NOT NULL,
  PRIMARY KEY (`idMenu`),
  INDEX `idRestaurante_idx` (`idRestaurante` ASC),
  CONSTRAINT `idRestaurante` FOREIGN KEY (`idRestaurante`) REFERENCES `mydb`.`Restaurante` (`idRestaurante`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;
SHOW WARNINGS;
-- -----------------------------------------------------
-- Table `mydb`.`Orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Orden` (
  `idOrden` INT NOT NULL,
  `idCliente` INT NOT NULL,
  `noOrden` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `hora` TIME NOT NULL,
  PRIMARY KEY (`idOrden`, `idCliente`),
  INDEX `idCliente_idx` (`idCliente` ASC),
  CONSTRAINT `idCliente` FOREIGN KEY (`idCliente`) REFERENCES `mydb`.`Cliente` (`idCliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;
SHOW WARNINGS;
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
  CONSTRAINT `idMenu` FOREIGN KEY (`idMenu`) REFERENCES `mydb`.`Menu` (`idMenu`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;
SHOW WARNINGS;
-- -----------------------------------