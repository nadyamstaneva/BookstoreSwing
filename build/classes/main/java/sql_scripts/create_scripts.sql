create database bookstore;

CREATE TABLE `bookstore`.`book` (`id` SERIAL NOT NULL , `title` VARCHAR(256) NOT NULL , `price` DECIMAL NOT NULL , `author_id` BIGINT NOT NULL ) ENGINE = InnoDB;
CREATE TABLE `bookstore`.`author` (`id` SERIAL NOT NULL , `name` VARCHAR(256) NOT NULL ) ENGINE = InnoDB;

