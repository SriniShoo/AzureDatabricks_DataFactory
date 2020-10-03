// Databricks notebook source
// MAGIC %run /Shared/Learn/Schema

// COMMAND ----------

import org.apache.spark.sql.Encoders

dbutils.widgets.removeAll()
dbutils.widgets.text("dataset", "", "Data Set")
val dataset = dbutils.widgets.get("dataset")
val schema = if(dataset == "StudentsPerformance") Encoders.product[StudentsPerformance].schema else if(dataset == "BhavCopy") Encoders.product[BhavCopy].schema else throw new Exception(s"Invalid dataset '${dataset}' passed")

// COMMAND ----------

val df = spark.read
   .option("header","true")
   .schema(schema)
   .csv(s"/mnt/storagesrinidev/myapp/dev/data/input/${dataset}.csv")
df.write.mode(SaveMode.Overwrite).parquet(s"/mnt/storagesrinidev/myapp/dev/data/stage/${dataset}")
display(df)
