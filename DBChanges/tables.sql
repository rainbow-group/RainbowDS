CREATE TABLE `sc`.`userInfo` (
  `open_id` VARCHAR(100) NOT NULL,
  `avatarUrl` VARCHAR(500) NOT NULL,
  `city` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `gender` INT NULL,
  `language` VARCHAR(45) NULL,
  `nickName` NVARCHAR(200) NOT NULL,
  `province` VARCHAR(45) NULL,
  UNIQUE INDEX `open_id_UNIQUE` (`open_id` ASC) VISIBLE,
  PRIMARY KEY (`open_id`));
  
  
  
  
  
CREATE TABLE `sc`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `open_id` VARCHAR(100) NOT NULL,
  `phone` VARCHAR(45) NULL,
  `created_date` DATETIME NULL DEFAULT NOW(),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `open_id_UNIQUE` (`open_id` ASC) VISIBLE,
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE);

