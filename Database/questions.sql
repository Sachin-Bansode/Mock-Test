/*
SQLyog - Free MySQL GUI v5.0
Host - 5.1.42-community : Database - test
*********************************************************************
Server version : 5.1.42-community
*/


/*Table structure for table `neasy_amplitude_que` */

CREATE TABLE `neasy_amplitude_que` (
  `Qid` int(100) NOT NULL,
  `Category` varchar(999) DEFAULT NULL,
  `Question` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`Qid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `neasy_amplitude_que` */

insert into `neasy_amplitude_que` values 
(1,'Number Theory','India got Independence on 15th august 1947.What was the day of the week '),
(2,'Blood Relations','Pointing to a boy a woman says,\"His Father is father-in-law of that person whose father is father in law of mine\".Then how is boy related to the woman'),
(3,'Blood Relations','X\'s father\'s wife\'s father\'s granddaughter\'s uncle will be related to X as'),
(4,'Coding-Decoding','If ABCDE is coded as ZYXWVU,then hw is TOYATA coded'),
(5,'Time And Work','A job can be completed by 2 persons,working 3 hours per day for 120 days.In how many days can the same job be completed by 6 persons,working 4 hours  per day?'),
(6,'Ratio And Proportion','The ratio of males and females in a city is 7:8 respectively and the percentage of children among males and females is 25% and 20% respectively.If the number of adult females in the city is 1,56,800.What is total population '),
(7,'Age','Billy is twice as old as Sally was when Billy was as old as Sally is now.And the total of their ages is 28.How old are they?'),
(8,'Percentage','A Person\'s Salary is reduced by 20%.What % be added to it ,to make it equal to the original salary?'),
(9,'Number Theory','Four bells toll at intervals of 14,21 and 42 min respectively.If they toll together at 11:22 am,when will they toll together for the first time after that?'),
(10,'Ratio And Proportion','A bag contains one rupee,50-paise and 25-paise coins in the ratio 2:3:5.Their total value is Rs 114.The value of 50-Paise coins is:'),
(11,'Permutation And Combination','In how many ways can 6 boys form a ring?');
