package com.mkinput;


/**
 * Hello world!
 *
 */
import org.apache.spark.api.java.*;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.mllib.*;
public class App {
  public static void main(String[] args) {
    String logFile = "/home/user/spark/spark/README.md"; // Should be some file on your system
    JavaSparkContext sc = new JavaSparkContext("local", "Simple App",
      "/home/user/spark/spark", new String[]{"target/NumberGenerator-1.0-SNAPSHOT.jar"});
    JavaRDD<String> logData = sc.textFile(logFile).cache();

    long numAs = logData.filter(new Function<String, Boolean>() {
      public Boolean call(String s) { return s.contains("a"); }
    }).count();

    long numBs = logData.filter(new Function<String, Boolean>() {
      public Boolean call(String s) { return s.contains("b"); }
    }).count();

    System.out.println("Lines with a: " + numAs + "and lines with b: " + numBs);
  }
}

