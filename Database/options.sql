/*
SQLyog - Free MySQL GUI v5.0
Host - 5.1.42-community : Database - test
*********************************************************************
Server version : 5.1.42-community
*/


/*Table structure for table `noptions` */

CREATE TABLE `noptions` (
  `Qid` int(100) NOT NULL,
  `option1` varchar(1000) DEFAULT NULL,
  `option2` varchar(1000) DEFAULT NULL,
  `option3` varchar(1000) DEFAULT NULL,
  `option4` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`Qid`),
  CONSTRAINT `noptions_ibfk_1` FOREIGN KEY (`Qid`) REFERENCES `neasy_amplitude_que` (`Qid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `noptions` */

insert into `noptions` values 
(1,'Monday','Sunday','Friday','Tuesday'),
(2,'Son','Brother','Son-in-law','Brother-in-law'),
(3,'Son','Nephew','Uncle','Grandfather'),
(4,'GLBZGZ','LGBGZL','ZGLBLG','GBLBGZ'),
(5,'20','30','40','50'),
(6,'2,45,500','3,67,500','3,96,000','2,71,500'),
(7,'12,16','10,18','18,10','20,18'),
(8,'28%','25%','29%','12%'),
(9,'11:56 am','12:04 pm','12:06 pm','12 :08 am'),
(10,'Rs 24','Rs 36','Rs 48','Rs 72'),
(11,'120','720','119','None Of These');
