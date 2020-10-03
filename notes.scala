// Steps
1. Create resource group - rg-srini-dev
2. Create the following resources
  Storage account - storagesrinidev
  Key vault - keyvault-srini-dev
  Azure Databricks Service - databricks-srini-dev
  Azure Cosmos DB account - cosmosdb-srini-dev
  Data factory (V2) - adf-srini-dev
  Service Principal - serviceprincipal-srini // AAD -> App registrations
3. Grant "Contributor" role to the service principal at the resource level
4. Grant "Storage Blob Data Contributor" role to the service principal at the storage level
5. Create a secret in service principal
6. Add the secret in KeyVault
7. Create container in storage - myapp
8. Create cluster in databricks - dev
9. Create secret scope in databricks - keyvault-srini-dev // Connection to Key vault from databricks
  https://docs.microsoft.com/en-us/azure/databricks/security/secrets/secret-scopes
10. Create mountpoint to the storage on databricks
  https://docs.databricks.com/data/data-sources/azure/azure-datalake-gen2.html
11. Store CosmosDB URI and PrimaryKey in Keyvault
12. Download Storage Explorer
  https://azure.microsoft.com/en-us/features/storage-explorer/
13. Upload sample data onto ADLS
14. Install library to access CosmosDB from databricks
  https://docs.databricks.com/data/data-sources/azure/cosmosdb-connector.html
15. Write code to process the data and upload to CosmosDB
16. Create accesstoken in Databricks
  https://docs.microsoft.com/en-us/azure/databricks/dev-tools/api/latest/authentication
17. Create Linked service to access databricks cluster from ADF - databricks_srini_dev
18. Create Pipeline and execute databricks notebooks
