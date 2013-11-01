IS101-Team1
===========

FYS Project, IS101 Team 1

	
|=INHOUD===============================================================|

	-	Vereisten
	-	Werkprocedure
	-	SQL Scripten



|=VEREISTEN============================================================|

Als mensen aan het project werken moeten ze zorgen dat ze de volgende dingen geïnstalleerd en klaar hebben staan.

  - NetBeans IDE
  - Laatste versie van de java JDK
  - MySql database
  - JDBC .jar driver
  - Een database met naam fys
    - Daarin een tabel user
      - In die tabel de volgende collumns
        - int       user_id
        - int       group_id
        - varchar   username
        - varchar   first_name
        - varchar   last_name
        - varchar   password
        - int				incorrect_login
        //- tinyint   locked            (tinyint is de MySql versie van een boolean; 0 = false en 1 = true) (VELD IS VERWIJDERD)
  - Een clone van de laatste GitHub versie van het project




|=WERKPROCEDURE========================================================|

Wanneer men veranderingen in het project heeft aangebracht klikt men met de rechtermuisknop op de Class/Package/src en selecteert men de optie Git > Commit.
Hier vult men relevante informatie in, denk hierbij aan aanpassingen die je gemaakt hebt, waarom en waar.
Daarna klikt men nogmaals met de rechtermuisknop op de gewenste Class/Package/src en selecteert men Git > Remote.. > Push. Loop deze reeks door en selecteer de nodige opties. Wanneer met een upstream blablabla.. error krijgt wil dit zeggen dat men niet de laatste versie heeft van het project heeft tijdens het pushen van de aanpassingen. Pull daarna het project.

|=LIBRARIES============================================================|

Voor sommige onderdelen zijn libraries nodig.

De jFreeChart library toevoegen:
Downloadlink: http://sourceforge.net/projects/jfreechart/files/ <-- Vergeet niet te unpacken
Rechtermuisknop op het project in 'Projects', en ga naar 'properties'. Vervolgens ga je naar 'libraries'. Druk op Add 'JAR/Folder'. Ga naar je jFreeChart folder > lib folder, en voeg jCommon toe. Druk op edit. Bij source voeg je de source folder in je JFreeChart toe. Bij javadoc voeg je de checkstyle folder uit je JFreeChart folder toe.

|=SQL Scripts==========================================================|

show create table `HierTableNaam` 				//om met commando een script commando op te vragen.

alter table `user` change group_id permission_id int ; 		//voor mensen die nog de collumn group_id hebben

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) NOT NULL DEFAULT '1',
  `username` varchar(20) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `incorrect_login` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `postal_code` varchar(10) NOT NULL,
  `address` varchar(75) NOT NULL,
  `country` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,	
  `phone_home` varchar(20) DEFAULT NULL,
  `phone_mobile` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8

CREATE TABLE `luggage` (
  `luggage_id` INT NOT NULL AUTO_INCREMENT,
  `customer_id` INT,
  `description` VARCHAR(200),
  `location` VARCHAR(50) NOT NULL,
  `date` DATE NOT NULL,
  `time` TIME NOT NULL,
  `is_lost` TINYINT default 1 NOT NULL,
  `is_handled` TINYINT default 0 NOT NULL,
  PRIMARY KEY (`luggage_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
