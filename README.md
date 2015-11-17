# PIXEL-SHIRT
E-COM PROJECT : School developping

## Récupération des différentes archives
* Glassfish (serveur d'applications Open Source Java EE 5): glassfish-4.1.zip
* BoneCp (Pool de connexion a la BD) : bonecp-0.8.0.RELEASE.jar
* guava (Pool de connexion a la BD) : guava-13.0.1.jar
* Postgresql (Base de donnée) : postgresql-8.1-404.jdbc3.jar
* slf4j (crypter les password): slf4j-api-1.6.6.jar

## Extraire l'archive Glassfish4

## Placer les jar dans glassfish4/glassfish/domains/domain1/lib/ext/ :
* bonecp-0.8.0.RELEASE.jar
* guava-13.0.1.jar
* postgresql-8.1-404.jdbc3.jar
* slf4j-api-1.6.6.jar

##Placer le fichier "bonecp-datasource.xml" dans glassfish4/bin/
Modifier les champs par rapport a la base de donnees cree en local:

<!-- Sets the JDBC connection URL. -->
     <property name="jdbcUrl" value="dbc:postgresql://localhost:5432/Pixel_Shirt"/>
   
     <!-- Sets username to use for connections. -->
     <!-- <property name="username" value="(null or no default value)"/> -->
   
     <!-- Sets username to use for connections. Just delegates to setUsername for clients hardcoded 
          with "setUser" instead. -->
     <property name="user" value="USER_NAME"/>
   
     <!-- Sets password to use for connections. -->
     <property name="password" value="YOUR_PASSWORD"/>
     
##Lancer dans un terminal le script "asadmin" (dans le repertoire "bin" cite precedemment)
* Lancer la commande : @> add-resources bonecp-datasource.xml
