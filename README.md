# TIX API MongoDB Archetype
Source Project of TIX API Spring Project Maven Archetype
Contains all sets of required modules for development

This repository not used for bare skeleton project for getting started, you need to do some steps before doing the actual project.

Following are the steps to make archetype for Maven : 
1. <code>git clone https://github.com/prasetyasetiawantiketcom/archetype-mongodb.git</code>
2. <code>cd archetype-mongodb</code>
3. <code>mvn clean install</code>
4. <code>mvn archetype:create-from-project</code>
5. <code>cd target/generated-sources/archetype</code>
6. <code>mvn install</code>
7. Done!!

Now you can create a new Maven Project by just running <code>mvn archetype:generate -DarchetypeCatalog=local</code>

Make sure you select the <code>com.tiket.tix.archetype.mongodb</code>, if you have multiple archetype in your local system when you got prompted to select archetype.
