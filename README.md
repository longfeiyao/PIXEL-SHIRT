# PIXEL-SHIRT
E-COM PROJECT : School developping

## INITIALISATION DU PROJET :

Dans un premier temps cloner votre projet dans le répertoire de votre choix. Vous pouvez utiliser les commandes graphiques de votre IDE Eclipse ou bien taper les lignes de commandes suivantes dans un terminal:
* @> git init
* @> git clone https://github.com/Vivien-Michel/PIXEL-SHIRT.git

### Récupération des différentes archives nécessaire au projet :
* Glassfish (serveur d'applications Open Source Java EE 5): glassfish-4.1.zip
* BoneCp (Pool de connexion à la BD) : bonecp-0.8.0.RELEASE.jar
* guava (Pool de connexion à la BD) : guava-13.0.1.jar
* Postgresql (Base de donnée) : postgresql-8.1-404.jdbc3.jar
* slf4j (crypter les passwords): slf4j-api-1.6.6.jar
* jasypt (crypter les passwords) : jasypt-1.9.2.jar
* joda (date timer) : joda-time-2.4.jar joda-time-2.4-javadoc.jar joda-time-2.4-sources.jar

Extraire l'archive Glassfish4 puis placer les .jar précédemment cités dans le dossier "<votre_chemin>/glassfish4/glassfish/domains/domain1/lib/ext/". 

### Projet Facets

Les facettes définissent des caractéristiques et des exigences pour Java EE des projets et sont utilisées dans le cadre de la configuration pendant l'exécution.

* Dans "Properties" (Alt+Entrer) du projet PIXEL-SHIRT
* Sélectionner "projets facets"
* Vérifier que vous avez les modules ou extensions suivantes :
	* Dynamic Web Module v.3.1
	* GlassFish Web Extensions v.4.0
	* Java v.1.7
	* jpt.jpa v.2.1
 
### Installation BDD postGreSQL
Télécharger programme en fonction de son OS via : http://www.enterprisedb.com/products-services-training/pgdownload

#### Création BDD
Lancer pgadmin3 :
Nouveau -> DataBase (renseigner nom, password, encodage, owner)

#### Fichier BoneCpp permettant de faire le lien entre BDD et le projet
Placer le fichier "bonecp-datasource.xml" dans <votre_chemin>/glassfish4/bin/
Modifier les champs par rapport à la base de donnees crée en local:

<!-- Sets the JDBC connection URL. -->
     <property name="jdbcUrl" value="dbc:postgresql://localhost:5432/Pixel_Shirt"/>
   
     <!-- Sets username to use for connections. -->
     <!-- <property name="username" value="(null or no default value)"/> -->
   
     <!-- Sets username to use for connections. Just delegates to setUsername for clients hardcoded 
          with "setUser" instead. -->
     <property name="user" value="USER_NAME"/>
   
     <!-- Sets password to use for connections. -->
     <property name="password" value="YOUR_PASSWORD"/>  
#### Informations pour trouver BDD
Dans un terminal dans le repertoire "<votre_chemin>/glassfish4/bin"
* Lancer le script : @> asadmin
* Lancer la commande : @> add-resources bonecp-datasource.xml

	* voir liste : asadmin> list-jdbc-resources
	* delete ressources : asadmin> delete-jdbc-resource <ressource>
	* delete connection : asadmin> delete-jdbc-connection-pool

### Configurer et Démarrer le server Glassfish
#### Configurer le server
* Ajouter dans : BuildPath -> Configure build path -> EAR librairies & Web App libraries.
* Pour importer Glassfish4 system, ajouter dans le fichier .classpath :

	<classpathentry kind="con" path="oracle.eclipse.tools.glassfish.lib.system">
		<attributes>
			<attribute name="owner.project.facets" value="jst.web"/>
		</attributes>
	</classpathentry>
* Dans Windows -> Server -> Runtime environnement
* Ajouter et renseigner les informations suivantes

	name : glassfish4
	server root : <votre_chemin>/glassfish4/glassfish
	java Development Kit : java-8-oracle (Eclipse default)
* Choisir la perspective : Java EE -> Servers 
* Ajouter un server et choisir celui précedemment créer
PuisPproperties -> Target runtime (choisir le type d'environnement pour server glassfish4 )
#### Démarrer le server
* Démarrer le server : bouton start
* Mise à jour de l'aplication sur le server : Publish (Ctrl+Alt+P)
* Pour lancer le server : Projet -> run as -> run on server 

## Quelques indications
### Acces index admin Glassfish4
	http://localhost:4848
	http://localhost:8080/Pixel_Shirt/Accueil
### Librairies
L'ajout des librairies dans servers son fait automatiquement. Cependant ne pas oublier d'ajouter les librairies [joda,jasyt] dans le projet eclipse via le BuildPath.
### Pensez à mettre l'encodage en UTF-8
### Variante pour l'utilisation de Amazone AWT -> IBM blueMix
### installation (si nécessaire) de java 8 sur ubuntu
Voir site : http://www.webupd8.org/2012/09/install-oracle-java-8-in-ubuntu-via-ppa.html


