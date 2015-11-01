# PIXEL-SHIRT
E-COM PROJECT : School developping

##Installation de BoneCp (Pool de connexion à la BD):

###Placer les jar dans glassfish4/glassfish/domains/domain1/lib :
-bonecp-0.8.0.RELEASE.jar

-guava-13.0.1.jar

-postgresql-8.1-404.jdbc3.jar

-slf4j-api-1.6.6.jar

###Placer le fichier "bonecp-datasource.xml" dans glassfish4/bin/
Modifier les champs par rapport à la base de données créée en local:
<!-- Sets the JDBC connection URL. -->
     <property name="jdbcUrl" value="dbc:postgresql://localhost:5432/Pixel_Shirt"/>
   
     <!-- Sets username to use for connections. -->
     <!-- <property name="username" value="(null or no default value)"/> -->
   
     <!-- Sets username to use for connections. Just delegates to setUsername for clients hardcoded 
          with "setUser" instead. -->
     <property name="user" value="USER_NAME"/>
   
     <!-- Sets password to use for connections. -->
     <property name="password" value="YOUR_PASSWORD"/>
     
###Lancer dans un terminal le script "asadmin" (dans le répertoire "bin" cité précédemment)

###Taper la commande : "add-resources bonecp-datasource.xml"
