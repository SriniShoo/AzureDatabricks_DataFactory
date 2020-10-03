// Databricks notebook source
val configs = Map(
  "fs.azure.account.auth.type" -> "OAuth",
  "fs.azure.account.oauth.provider.type" -> "org.apache.hadoop.fs.azurebfs.oauth2.ClientCredsTokenProvider",
  "fs.azure.account.oauth2.client.id" -> "5bef548d-201f-457f-894f-f79ab951c200",
  "fs.azure.account.oauth2.client.secret" -> dbutils.secrets.get(scope="keyvault-srini-dev",key="serviceprincipal-srini"),
  "fs.azure.account.oauth2.client.endpoint" -> "https://login.microsoftonline.com/82606aba-7563-492c-b332-8e92e2bb3760/oauth2/token")

// Optionally, you can add <directory-name> to the source URI of your mount point.
dbutils.fs.mount(
  source = "abfss://myapp@storagesrinidev.dfs.core.windows.net/",
  mountPoint = "/mnt/storagesrinidev/myapp",
  extraConfigs = configs)

// COMMAND ----------

// MAGIC %fs ls /mnt/storagesrinidev/myapp

// COMMAND ----------

dbutils.fs.unmount("/mnt/storagesrinidev/myapp")
