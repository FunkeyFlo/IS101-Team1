IS101-Team1
===========

FYS Project, IS101 Team 1

	
|=INHOUD===============================================================|

	-	Vereisten
	-	Werkprocedure




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
        - tinyint   locked            (tinyint is de MySql versie van een boolean; 0 = false en 1 = true)
  - Een clone van de laatste GitHub versie van het project




|=WERKPROCEDURE========================================================|

Wanneer men veranderingen in het project heeft aangebracht klikt men met de rechtermuisknop op de Class/Package/src en selecteert men de optie Git > Commit.
Hier vult men relevante informatie in, denk hierbij aan aanpassingen die je gemaakt hebt, waarom en waar.
Daarna klikt men nogmaals met de rechtermuisknop op de gewenste Class/Package/src en selecteert men Git > Remote.. > Push. Loop deze reeks door en selecteer de nodige opties. Wanneer met een upstream blablabla.. error krijgt wil dit zeggen dat men niet de laatste versie heeft van het project heeft tijdens het pushen van de aanpassingen. Pull daarna het project.
