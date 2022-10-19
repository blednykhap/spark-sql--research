package org.sinoptik.jobs

import org.sinoptik.SparkJob

object pass_param extends SparkJob {

  val query1 =
    """
      | SELECT *
      | FROM mci.checkpar
      | WHERE name = '%s'
      |""".stripMargin

  val name = "Two"

  val df1 = sparkSession.sql(query1.format(name));

  df1.show(2, 100, true)

  val query2 =
    """
      | SELECT *
      | FROM %s
      | WHERE id = 1
      |""".stripMargin

  val table = "mci.checkpar"

  val df2 = sparkSession.sql(query2.format(table));

  df2.show(2, 100, true)

  sparkSession.close()
  System.exit(0)


}
