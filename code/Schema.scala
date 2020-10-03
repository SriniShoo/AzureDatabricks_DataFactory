// Databricks notebook source
case class StudentsPerformance(
  gender: String,
  race: String,
  education: String,
  lunch: String,
  status: String,
  math: Int,
  reading: Int,
  writing: Int
)

// COMMAND ----------

case class BhavCopy(
  code: Int,
  name: String,
  group: String,
  scType: String,
  open: Double,
  high: Double,
  low: Double,
  close: Double,
  last: Double,
  prevClose: Double,
  numTrades: Long,
  numShares: Long,
  netTurnover: Double,
  tdcloind: String,
  isin: String,
  date: String,
  filler2: String,
  fillter3: String
)
