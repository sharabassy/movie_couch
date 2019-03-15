DROP SCHEMA IF EXISTS `movie-couch-db`;

CREATE SCHEMA `movie-couch-db`;

use `movie-couch-db`;

SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` 
(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) DEFAULT NULL,
  `year` varchar(45) DEFAULT NULL,
  `imdb_id` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `poster` varchar(250) DEFAULT NULL,
  `imdb_rating` varchar(20) DEFAULT NULL,
  `rated` varchar(20) DEFAULT NULL,
  `released` varchar(45) DEFAULT NULL,
  `runtime` varchar(20) DEFAULT NULL,
  `genre` varchar(128) DEFAULT NULL,
  `director` varchar(128) DEFAULT NULL,
  `writer` varchar(250) DEFAULT NULL,
  `actors` varchar(250) DEFAULT NULL,
  `plot` varchar(400) DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `awards` varchar(250) DEFAULT NULL,
  `metascore` varchar(45) DEFAULT NULL,
  `imdb_votes` int(11) DEFAULT NULL,
  `dvd` varchar(45) DEFAULT NULL,
  `boxoffice` varchar(45) DEFAULT NULL,
  `production` varchar(45) DEFAULT NULL,
  `website` varchar(125) DEFAULT NULL,

  PRIMARY KEY (`id`),
  
  UNIQUE KEY `IMDBID_UNIQUE` (`imdb_id`)

) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` 
(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `user_movie`;
CREATE TABLE `user_movie` 
(
  `user_id` int(11) NOT NULL,
  `movie_id` int(11) NOT NULL,
  `schedule_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`,`movie_id`),
  
  
  CONSTRAINT `FK_MOVIE` 
  FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_USER` 
  FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)  ON DELETE NO ACTION ON UPDATE NO ACTION

) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
