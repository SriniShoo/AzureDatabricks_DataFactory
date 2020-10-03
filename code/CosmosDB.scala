// Databricks notebook source
dbutils.widgets.removeAll()
dbutils.widgets.text("dataset", "", "Data Set")
val dataset = dbutils.widgets.get("dataset")

// COMMAND ----------

import com.microsoft.azure.cosmosdb.spark.CosmosDBSpark
import com.microsoft.azure.cosmosdb.spark.config.Config

val uri = dbutils.secrets.get(scope="keyvault-srini-dev", key="cosmosdb-srini-dev-uri")
val primaryKey = dbutils.secrets.get(scope="keyvault-srini-dev", key="cosmosdb-srini-dev-primarykey")
val database = "myapp"

val configMap = Map(
  "Endpoint" -> uri,
  "Masterkey" -> primaryKey,
  "Database" -> database,
  "Collection" -> dataset,
  "Upsert" -> "true"
)
val config = Config(configMap)

// COMMAND ----------

val df = spark.read.parquet(s"/mnt/storagesrinidev/myapp/dev/data/stage/${dataset}")
CosmosDBSpark.save(df, config)
