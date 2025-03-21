-- 1. Créer d'abord la table "type" car elle est référencée par d'autres tables
CREATE TABLE `type`(
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` ENUM('entrée', 'plat', 'dessert') NOT NULL
);

-- 2. Créer ensuite la table "Plat" qui référence "type"
CREATE TABLE `Plat`(
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nom` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `prix` DOUBLE NOT NULL,
  `imageUrl` VARCHAR(255) NOT NULL,
  `id_type` INT UNSIGNED NOT NULL,
  CONSTRAINT `fk_plat_type` FOREIGN KEY (`id_type`) REFERENCES `type`(`id`)
);

-- 3. Créer la table "Commande" qui référence "Plat"
CREATE TABLE `Commande`(
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `id_plat` INT UNSIGNED NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  CONSTRAINT `fk_commande_plat` FOREIGN KEY (`id_plat`) REFERENCES `Plat`(`id`)
);

-- 4. Créer la table "ingrédients"
CREATE TABLE `ingrédients`(
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(255) NOT NULL
);

-- 5. Créer la table de jointure "Plat_ingredients"
CREATE TABLE `Plat_ingredients`(
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `id_plat` INT UNSIGNED NOT NULL,
  `id_ingredients` INT UNSIGNED NOT NULL,
  CONSTRAINT `fk_plat_ingredients_plat` FOREIGN KEY (`id_plat`) REFERENCES `Plat`(`id`),
  CONSTRAINT `fk_plat_ingredients_ingrédients` FOREIGN KEY (`id_ingredients`) REFERENCES `ingrédients`(`id`)
);

-- 6. Créer la table "client" qui référence "Commande"
CREATE TABLE `client`(
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `id_commande` INT UNSIGNED NOT NULL,
  CONSTRAINT `fk_client_commande` FOREIGN KEY (`id_commande`) REFERENCES `Commande`(`id`)
);