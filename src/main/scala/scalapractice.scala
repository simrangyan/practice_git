import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object scalapractice {
  def main(args: Array[String]): Unit = {
    val logger: Logger = Logger.getLogger(getClass.getName)

    val sparkconf = new SparkConf()
    sparkconf.set("spark.app.name", "myfirstapplication")
    sparkconf.set("spark.master", "local[*]");

    val spark = SparkSession.builder()
      .config(sparkconf)
      .getOrCreate()


    val df = spark.read
      .format("csv")
      .option("header", true)
      .option("inferSchema", true)
      .option("path", "C:/Data/cust.csv")
      .load()
    df.show()
  }
}
