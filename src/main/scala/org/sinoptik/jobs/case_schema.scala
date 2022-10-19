package org.sinoptik.jobs

import org.apache.spark.sql.Encoders
import org.sinoptik.SparkJob
import org.sinoptik.entities.case_test

object case_schema extends SparkJob {

  val mySchema = Encoders.product[case_test].schema
  mySchema.printTreeString()

}
