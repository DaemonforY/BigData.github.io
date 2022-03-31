import org.apache.spark.{SparkConf, SparkContext}

object test {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("test").setMaster("local[*]")
    val sc = new SparkContext(sparkConf)

    val tuples =
    //      sc.textFile(ClassLoader.getSystemResource("word.csv").getPath)
      sc.textFile("sparkSourceAndPractices/src/main/resources/word.csv")
        .flatMap(_.split(","))
        .map((_, 1))
        .reduceByKey(_ + _)
        .collect()

    tuples.foreach(println)
  }

}

