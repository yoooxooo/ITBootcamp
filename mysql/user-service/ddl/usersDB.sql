USE Users
CREATE TABLE `users` (
  `dt_create` datetime(6) DEFAULT NULL,
  `id` binary(16) NOT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `patronymic` varchar(255) DEFAULT NULL,
  `role` enum('ADMIN','CUSTOM_USER','SALE_USER','SECURE_API_USER') DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_jhck7kjdogc7yia7qamc89ypv` (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;