CREATE DATABASE `plant_it` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `address` (
  `id_address` int NOT NULL AUTO_INCREMENT,
  `number` int NOT NULL,
  `postal_code` int NOT NULL,
  `way` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `additional_address` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `town` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id_address`),
  UNIQUE KEY `idAddress_UNIQUE` (`id_address`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `article` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `prix` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `contient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_facture` int NOT NULL,
  `id_article` int NOT NULL,
  `quantite` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contient_article_idx` (`id_article`),
  KEY `fk_facture_contient_idx` (`id_facture`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `conversation` (
  `id_conversation` int NOT NULL AUTO_INCREMENT,
  `id_user_1` int NOT NULL,
  `id_user_2` int NOT NULL,
  PRIMARY KEY (`id_conversation`),
  UNIQUE KEY `idConversation_UNIQUE` (`id_conversation`),
  KEY `fk_Conversation_User1_idx` (`id_user_1`),
  KEY `fk_Conversation_User2_idx` (`id_user_2`),
  CONSTRAINT `fk_Conversation_User1` FOREIGN KEY (`id_user_1`) REFERENCES `user` (`id_user`),
  CONSTRAINT `fk_Conversation_User2` FOREIGN KEY (`id_user_2`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `created_by` (
  `id_plant_reference` int NOT NULL,
  `id_user` int NOT NULL,
  `order_num` int DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id_plant_reference`,`id_user`),
  KEY `fk_Plant_Reference_has_User_User1_idx` (`id_user`),
  KEY `fk_Plant_Reference_has_User_Plant_Reference1_idx` (`id_plant_reference`),
  CONSTRAINT `fk_Plant_Reference_has_User_Plant_Reference1` FOREIGN KEY (`id_plant_reference`) REFERENCES `plant_reference` (`id_plant_reference`),
  CONSTRAINT `fk_Plant_Reference_has_User_User1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `facture` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user` int NOT NULL,
  `total` decimal(10,0) NOT NULL,
  `date` datetime NOT NULL,
  `numero` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_facture_user_idx` (`user`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `maintenance` (
  `id_maintenance` int NOT NULL AUTO_INCREMENT,
  `predicted_date` datetime DEFAULT NULL,
  `realized_date` datetime DEFAULT NULL,
  `report` varchar(1500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_maintenance`),
  UNIQUE KEY `idMeeting_UNIQUE` (`id_maintenance`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `maintenance_picture` (
  `id_maintenance` int NOT NULL,
  `id_picture` int NOT NULL,
  PRIMARY KEY (`id_maintenance`,`id_picture`),
  KEY `fk_Maintenance_has_Picture_Picture1_idx` (`id_picture`),
  KEY `fk_Maintenance_has_Picture_Maintenance1_idx` (`id_maintenance`),
  CONSTRAINT `fk_Maintenance_has_Picture_Maintenance1` FOREIGN KEY (`id_maintenance`) REFERENCES `maintenance` (`id_maintenance`),
  CONSTRAINT `fk_Maintenance_has_Picture_Picture1` FOREIGN KEY (`id_picture`) REFERENCES `picture` (`id_picture`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `maintenance_user` (
  `id_maintenance` int NOT NULL,
  `id_user` int NOT NULL,
  PRIMARY KEY (`id_maintenance`,`id_user`),
  KEY `fk_Maintenance_has_User_User1_idx` (`id_user`),
  KEY `fk_Maintenance_has_User_Maintenance1_idx` (`id_maintenance`),
  CONSTRAINT `fk_Maintenance_has_User_Maintenance1` FOREIGN KEY (`id_maintenance`) REFERENCES `maintenance` (`id_maintenance`),
  CONSTRAINT `fk_Maintenance_has_User_User1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `manage` (
  `id_user_customer` int NOT NULL,
  `id_user_botanist` int NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id_user_customer`,`id_user_botanist`),
  KEY `fk_User_has_User_User2_idx` (`id_user_botanist`),
  KEY `fk_User_has_User_User1_idx` (`id_user_customer`),
  CONSTRAINT `fk_User_has_User_User1` FOREIGN KEY (`id_user_customer`) REFERENCES `user` (`id_user`),
  CONSTRAINT `fk_User_has_User_User2` FOREIGN KEY (`id_user_botanist`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `message` (
  `id_message` int NOT NULL AUTO_INCREMENT,
  `label` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  `id_conversation` int NOT NULL,
  PRIMARY KEY (`id_message`),
  UNIQUE KEY `idMessage_UNIQUE` (`id_message`),
  KEY `fk_Message_Conversation1_idx` (`id_conversation`),
  CONSTRAINT `fk_Message_Conversation1` FOREIGN KEY (`id_conversation`) REFERENCES `conversation` (`id_conversation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `password_historic` (
  `id_historic` int NOT NULL AUTO_INCREMENT,
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  `id_user` int NOT NULL,
  PRIMARY KEY (`id_historic`),
  UNIQUE KEY `idHistoric_UNIQUE` (`id_historic`),
  KEY `fk_Historic_User1_idx` (`id_user`),
  CONSTRAINT `fk_Historic_User1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `picture` (
  `id_picture` int NOT NULL AUTO_INCREMENT,
  `way` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id_picture`),
  UNIQUE KEY `idPictures_UNIQUE` (`id_picture`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `picture_reference` (
  `id_picture_reference` int NOT NULL AUTO_INCREMENT,
  `way` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modification_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id_picture_reference`),
  UNIQUE KEY `idPicture_Reference_UNIQUE` (`id_picture_reference`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `plant` (
  `id_plant` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `place_plant` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `container` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `humidity` int DEFAULT NULL,
  `clarity` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `id_user` int NOT NULL,
  `id_plant_reference` int DEFAULT NULL,
  PRIMARY KEY (`id_plant`),
  UNIQUE KEY `idPlant_UNIQUE` (`id_plant`),
  KEY `fk_Plant_User1_idx` (`id_user`),
  KEY `fk_Plant_Plant_Reference_idx` (`id_plant_reference`),
  CONSTRAINT `fk_Plant_Plant_Reference1` FOREIGN KEY (`id_plant_reference`) REFERENCES `plant_reference` (`id_plant_reference`),
  CONSTRAINT `fk_Plant_User1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `plant_conversation` (
  `id_plant` int NOT NULL,
  `id_conversation` int NOT NULL,
  PRIMARY KEY (`id_plant`,`id_conversation`),
  KEY `fk_Plant_has_Conversation_Conversation1_idx` (`id_conversation`),
  KEY `fk_Plant_has_Conversation_Plant1_idx` (`id_plant`),
  CONSTRAINT `fk_Plant_has_Conversation_Conversation1` FOREIGN KEY (`id_conversation`) REFERENCES `conversation` (`id_conversation`),
  CONSTRAINT `fk_Plant_has_Conversation_Plant1` FOREIGN KEY (`id_plant`) REFERENCES `plant` (`id_plant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `plant_picture` (
  `id_plant` int NOT NULL,
  `id_picture` int NOT NULL,
  PRIMARY KEY (`id_plant`,`id_picture`),
  KEY `fk_Plant_has_Picture_Picture1_idx` (`id_picture`),
  KEY `fk_Plant_has_Picture_Plant1_idx` (`id_plant`),
  CONSTRAINT `fk_Plant_has_Picture_Picture1` FOREIGN KEY (`id_picture`) REFERENCES `picture` (`id_picture`),
  CONSTRAINT `fk_Plant_has_Picture_Plant1` FOREIGN KEY (`id_plant`) REFERENCES `plant` (`id_plant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `plant_reference` (
  `id_plant_reference` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `family` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `size` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `food_source` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `reproduction` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `lifetime` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `place_life` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_plant_reference`),
  UNIQUE KEY `idPlant_Reference_UNIQUE` (`id_plant_reference`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `reference_picture` (
  `id_plant_reference` bigint NOT NULL,
  `id_picture_reference` bigint NOT NULL,
  PRIMARY KEY (`id_plant_reference`,`id_picture_reference`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `referenced_picture` (
  `id_plant_reference` int NOT NULL,
  `id_picture_reference` int NOT NULL,
  PRIMARY KEY (`id_plant_reference`,`id_picture_reference`),
  KEY `fk_Plant_Reference_has_Picture_Reference_Picture_Reference1_idx` (`id_picture_reference`),
  KEY `fk_Plant_Reference_has_Picture_Reference_Plant_Reference1_idx` (`id_plant_reference`),
  CONSTRAINT `fk_Plant_Reference_has_Picture_Reference_Picture_Reference1` FOREIGN KEY (`id_picture_reference`) REFERENCES `picture_reference` (`id_picture_reference`),
  CONSTRAINT `fk_Plant_Reference_has_Picture_Reference_Plant_Reference1` FOREIGN KEY (`id_plant_reference`) REFERENCES `plant_reference` (`id_plant_reference`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `label` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `label_UNIQUE` (`label`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `user` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `lastname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `firstname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `degree` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `specialization` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `hobbies` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `id_address` int DEFAULT NULL,
  `id_user_type` int DEFAULT NULL,
  `id_godfather` bigint DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `idUser_UNIQUE` (`id_user`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  KEY `fk_User_User_Type_idx` (`id_user_type`),
  KEY `fk_User_Address1_idx` (`id_address`),
  CONSTRAINT `fk_User_Address1` FOREIGN KEY (`id_address`) REFERENCES `address` (`id_address`),
  CONSTRAINT `fk_User_User_Type` FOREIGN KEY (`id_user_type`) REFERENCES `user_type` (`id_user_type`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `user_historic` (
  `id_user_historic` int NOT NULL AUTO_INCREMENT,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `id_user` int NOT NULL,
  PRIMARY KEY (`id_user_historic`,`id_user`),
  KEY `fk_User_Historic_User1_idx` (`id_user`),
  CONSTRAINT `fk_User_Historic_User1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `user_type` (
  `id_user_type` int NOT NULL AUTO_INCREMENT,
  `label` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id_user_type`),
  UNIQUE KEY `idUser_Type_UNIQUE` (`id_user_type`),
  UNIQUE KEY `label_UNIQUE` (`label`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
