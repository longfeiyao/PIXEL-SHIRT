IBM bluemix

# PIXEL-SHIRT
E-COM PROJECT : School developping
PS : encodage en UTF-8

ajout des lib dans servers ok
 ajout des lib joda et jasyt dans projets eclipse

## installation (possible)  java 8 ubuntu
http://www.webupd8.org/2012/09/install-oracle-java-8-in-ubuntu-via-ppa.html

## INITIALISATION DU PROJET :

Dans un premier temps cloner votre projet dans le répertoire de votre choix. Vpus pouvez utiliser les commandes graphiques de votre IDE Eclipse ou bien taper les lignes de commandes suivantes dans un terminal:
* git init
* git clone https://github.com/Vivien-Michel/PIXEL-SHIRT.git

### Récupération des différentes archives
* Glassfish (serveur d'applications Open Source Java EE 5): glassfish-4.1.zip
* BoneCp (Pool de connexion a la BD) : bonecp-0.8.0.RELEASE.jar
* guava (Pool de connexion a la BD) : guava-13.0.1.jar
* Postgresql (Base de donnée) : postgresql-8.1-404.jdbc3.jar
* slf4j (crypter les password): slf4j-api-1.6.6.jar
* jasypt (crypter les password) :
* joda (time) : joda-time-2.4.jar joda-time-2.4-javadoc.jar joda-time-2.4-sources.jar

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

## Projet Facets
Les facettes définissent des caractéristiques et des exigences pour Java EE des projets et sont utilisées dans le cadre de la configuration pendant l'exécution.

* Dans "properties" (alt+Entrer) du projet PIXEL-SHIRT
* Séléctonnez "projets facets"
* Vérifiez que vous avez les modules ou extensions suivantes :
	* Dynamic Web Module v.3.1
	* GlassFish Web Extensions v.4.0
	* Java v.1.7
	* jpt.jpa v.2.1
 
## Ajouter Glassfish dans le Buildpath de votre projet:
(outil pour java EE)
     
## Démarrer le server
Démarrer le server

dans windows -> server -> runtime environnement
cliquer add
	name : glassfish4
	server root : <votre_chemin>/glassfish4/glassfish
	java Development Kit : java-8-oracle (Eclipse default)

perspective : javva ee -> servers 
add servers puis choisir celui précedemment créer.
pour lancer le server : sur projet -> run as -> run on server 
     
## installation BDD de postGreSQL:
	installation de postGreSQL

http://www.enterprisedb.com/products-services-training/pgdownload

	
	création BDD (a faire) database
	va sur pgadmin
	nv add bdd nom mot de passe etc
	
	modf bone cpp sur lieu et nom et mot de passe et num de port
 
 buildPAth -> configure build path -> add librairies : ear lib et web app libraries
 
 add classpath pour impoter glasshish system
 <classpathentry kind="con" path="oracle.eclipse.tools.glassfish.lib.system">
		<attributes>
			<attribute name="owner.project.facets" value="jst.web"/>
		</attributes>
	</classpathentry>

	
properties -> target runtime
choisir type d'environnement pour server (ex : tomcat, glassfish)
en l'occurence glassfish4 
  
## Dans un terminal dans le repertoire "bin" cite precedemment BDD info pour trouver la base de donnée
* Lancer le script : @> asadmin
* Lancer la commande : @> add-resources bonecp-datasource.xml

voir liste list-jdbc-resources
delete ressources delete-jdbc-resource <ressource>
delete connection delete-jdbc-connection-pool

acces index admin glassfish : http://localhost:4848
http://localhost:8080/Pixel_Shirt/Accueil

mise a jour aplli sur  le server : PUBLISH
demarrrer serveur start 

lancer server : run as -> on server


