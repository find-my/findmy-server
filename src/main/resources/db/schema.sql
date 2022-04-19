CREATE TABLE `comment` (
    `comment_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `content` varchar(200) DEFAULT NULL,
    `user_id` bigint(20) DEFAULT NULL,
    `post_id` bigint(20) DEFAULT NULL,
    `created_date` datetime(6) DEFAULT NULL,
    `modified_date` datetime(6) DEFAULT NULL,
    PRIMARY KEY (`comment_id`),
    KEY `FKs1slvnkuemjsq2kj4h3vhx7i1` (`post_id`),
    KEY `FK8kcum44fvpupyw6f5baccx25c` (`user_id`),
    CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
    CONSTRAINT `FKs1slvnkuemjsq2kj4h3vhx7i1` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `photo` (
    `photo_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `file` varchar(255) DEFAULT NULL,
    `post_id` bigint(20) DEFAULT NULL,
    `created_date` datetime(6) DEFAULT NULL,
    `modified_date` datetime(6) DEFAULT NULL,
    PRIMARY KEY (`photo_id`),
    KEY `FKt47fmi9mi5p9dkjyyuoyfc63f` (`post_id`),
    CONSTRAINT `FKt47fmi9mi5p9dkjyyuoyfc63f` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `post` (
    `post_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `title` varchar(255) DEFAULT NULL,
    `place` varchar(255) DEFAULT NULL,
    `post_type` varchar(255) DEFAULT NULL,
    `category` varchar(255) DEFAULT NULL,
    `views` int(11) NOT NULL,
    `latitude` float NOT NULL,
    `longitude` float NOT NULL,
    `description` varchar(500) DEFAULT NULL,
    `user_id` bigint(20) DEFAULT NULL,
    `created_date` datetime(6) DEFAULT NULL,
    `modified_date` datetime(6) DEFAULT NULL,
    PRIMARY KEY (`post_id`),
    KEY `FK72mt33dhhs48hf9gcqrq4fxte` (`user_id`),
    CONSTRAINT `FK72mt33dhhs48hf9gcqrq4fxte` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `re_comment` (
    `recomment_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `content` varchar(200) DEFAULT NULL,
    `comment_id` bigint(20) DEFAULT NULL,
    `user_id` bigint(20) DEFAULT NULL,
    `created_date` datetime(6) DEFAULT NULL,
    `modified_date` datetime(6) DEFAULT NULL,
    PRIMARY KEY (`recomment_id`),
    KEY `FKlbau13r2qs2dvla5g9k3xnmpd` (`comment_id`),
    KEY `FK443vej9kw86wscgr7rp5qq08g` (`user_id`),
    CONSTRAINT `FK443vej9kw86wscgr7rp5qq08g` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
    CONSTRAINT `FKlbau13r2qs2dvla5g9k3xnmpd` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `review` (
    `review_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `review` varchar(255) DEFAULT NULL,
    `score` int(11) NOT NULL DEFAULT 1,
    `user_id` bigint(20) DEFAULT NULL,
    `created_date` datetime(6) DEFAULT NULL,
    `modified_date` datetime(6) DEFAULT NULL,
    PRIMARY KEY (`review_id`),
    KEY `FKiyf57dy48lyiftdrf7y87rnxi` (`user_id`),
    CONSTRAINT `FKiyf57dy48lyiftdrf7y87rnxi` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `scrap` (
    `scrap_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `post_id` bigint(20) DEFAULT NULL,
    `user_id` bigint(20) DEFAULT NULL,
    `created_date` datetime(6) DEFAULT NULL,
    `modified_date` datetime(6) DEFAULT NULL,
    PRIMARY KEY (`scrap_id`),
    KEY `FK6cjkagewjywuylil3gw7di68q` (`post_id`),
    KEY `FKgt91kwgqa4f4oaoi9ljgy75mw` (`user_id`),
    CONSTRAINT `FK6cjkagewjywuylil3gw7di68q` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`),
    CONSTRAINT `FKgt91kwgqa4f4oaoi9ljgy75mw` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `user` (
    `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
    `email` varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    `phone` varchar(255) DEFAULT NULL,
    `avatar` varchar(255) DEFAULT NULL,
    `created_date` datetime(6) DEFAULT NULL,
    `modified_date` datetime(6) DEFAULT NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
    UNIQUE KEY `UK_589idila9li6a4arw1t8ht1gx` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;