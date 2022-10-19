package org.sinoptik

import org.apache.spark.sql.SparkSession

abstract  class SparkJob extends App{

  lazy implicit val sparkSession = SparkSession
    .builder()
    .appName("Spark SQL Research")
    .master("yarn")
    .config("spark.hadoop.fs.defaultFS", "hdfs://192.168.231.146:8020")
    .config("spark.hadoop.yarn.resourcemanager.address", "192.168.231.146:8050") // :8032
    .config("spark.yarn.jars", "hdfs://192.168.231.146:8020/user/Sinoptik/jars/*.jar")
    .config("hive.metastore.uris", "thrift://192.168.231.146:9083")
    //.config("hive.metastore.warehouse.dir", "hdfs://192.168.231.146:8020/apps/hive/warehouse")
    .enableHiveSupport()
    .getOrCreate()

}
