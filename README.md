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
  
5. Create a sample maven project in ANY directory you want.

   Give a groupId for eg. "org.testproject" and for eg. artifactId: "myTestProject"
   
  `mkdir firstSparkProject`
  
  `cd firstSparkProject`
  
  ```
  mvn archetype:generate -DgroupId=com.testproject -DartifactId=myTestProject -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
	```
6. The above command will create a directory "myTestProject". Now we create an eclipse project out of it.

  `cd myTestProject`
  
  `mvn eclipse:eclpise`
	
7. Now open this project in eclipse. "Import as an existing project"

8. Open the project-explorer and navigate to "pom.xml" and open it.

9. In the opened pom.xml tab, open "pom.xml" from all the tabs underneath: "Dependencies, Effective Pom, pom.xml"

10. Add Spark dependencies in this pom.xml- tab. 
  ```    
  <dependency>
            <groupId>org.apache.spark</groupId>
            <artifactId>spark-core_2.10</artifactId>
            <version>1.3.0</version>
  </dependency>
  ```
  
11. Right click on the "pom.xml" in project-explorer and "Run as" -> "maven-install"

12. Now in terminal, navigate inside project directory "myTestProject" and execute this command.
    This will download all the required dependencies.

    `mvn eclipse:eclipse`
  
    Restart eclipse.

13. Now in project-explorer open the main file from `src/main/java/com.testproject/App.main` and paste this code in there.
    ```
	//keep the default pkg same
	
	import org.apache.spark.api.java.*;
	import org.apache.spark.api.java.function.Function;
	
	public class App {
	  public static void main(String[] args) {
	    String logFile = "/home/user/spark/README.md"; // Using the file from spark installation directory itself.
	    JavaSparkContext sc = new JavaSparkContext("local", "App",
	      "/home/user/spark", new String[]{"target/myTestProject-1.0-SNAPSHOT.jar"}); // 3rd argument will be the installation directory of spark, 4th argument will be the generated jar from your project.(check in workspace in "target" directory for exact name)
	    JavaRDD<String> logData = sc.textFile(logFile).cache();
	
	    long numAs = logData.filter(new Function<String, Boolean>() {
	      public Boolean call(String s) { return s.contains("a"); }
	    }).count();
	
	    long numBs = logData.filter(new Function<String, Boolean>() {
	      public Boolean call(String s) { return s.contains("b"); }
	    }).count();
	
	    System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);
	  }
	}
    ```


14. Once this is in place, just right click on your `App.java` file and `"Rus as"->"Java Application"`
