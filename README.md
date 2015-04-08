# sparkJava
A sample java project for setting up Apache spark with eclipse IDE (struggled too much with installation, so documenting it)

1. Install Java:

 `sudo apt-add-repository ppa:webupd8team/java`

 `sudo apt-get update`

 `sudo apt-get install oracle-java7-installer`


2. Install Scala:

  `sudo apt-get install scala`

3. Install Maven:

  `sudo apt-get install maven`
  
4. Download precompiled spark ( currently using precompiled binary with hadoop version >= 2.6 )
  
  `wget http://apache.lauf-forum.at/spark/spark-1.3.0/spark-1.3.0-bin-hadoop2.4.tgz`

  `tar -xvzf spark-1.3.0-bin-hadoop2.4.tgz`
  
  `mv spark-1.3.0-bin-hadoop2.4/ spark`
  
5. Create a sample maven project.

   Give a groupId for eg. "org.testproject" and for eg. artifactId: "myTestProject"
  ```
  mvn archetype:generate -DgroupId=com.testproject -DartifactId=myTestProject -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
	```
6. The above command will create a directory "myTestProject". Now we create an eclipse project out of it.

  `cd myTestProject`
  
  `mvn eclipse:eclpise`
	
7. Now open this project in eclipse. "Import as an existing project"

8. Open the project-explorer and navigate to "pom.xml" and open it.
