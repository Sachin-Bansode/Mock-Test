/*
SQLyog - Free MySQL GUI v5.0
Host - 5.1.42-community : Database - test
*********************************************************************
Server version : 5.1.42-community
*/


/*Table structure for table `nanswers` */

CREATE TABLE `nanswers` (
  `Qid` int(100) NOT NULL,
  `Correct` varchar(999) DEFAULT NULL,
  PRIMARY KEY (`Qid`),
  CONSTRAINT `nanswers_ibfk_1` FOREIGN KEY (`Qid`) REFERENCES `neasy_amplitude_que` (`Qid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `nanswers` */

insert into `nanswers` values 
(1,'Friday'),
(2,'Brother'),
(3,'Uncle'),
(4,'GLBZGZ'),
(5,'30'),
(6,'3,67,500'),
(7,'12,16'),
(8,'25%'),
(9,'12:04 pm'),
(10,'Rs 36'),
(11,'120');
