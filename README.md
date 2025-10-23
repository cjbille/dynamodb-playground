# DynamoDB Playground
This project meant for testing, prototyping, and interacting with DynamoDB locally with Quarkus

# Prerequisites
- Verify at least Java 17 or later is installed
- Download DynamoDB locally following instructions here: https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.DownloadingAndRunning.html
- Make .aws dir in home: `mkdir ~/.aws`
- Add credentials file to `~/.aws` dir:
```
cat << EOF > ~/.aws/credentials
[default]
aws_access_key_id = accessKeyId
aws_secret_access_key = secretAccessKey
EOF
```
- Add config file to `~/.aws` dir:
```
cat << EOF > /~.aws/config
[default]
region = us-east-1
EOF
```
- Start DynamoDB: `java -Djava.library.path=/Path/To/DynamoDBLocal_lib -jar /Path/To/DynamoDBLocal.jar -sharedDb
`

# DynamoDB Commands
This section lists basic DynamoDB commands

## List Tables
- `aws dynamodb list-tables --endpoint-url http://localhost:8000`

## Create Table
```
--table-name players \
--attribute-definitions \
  AttributeName=playerId,AttributeType=S \
  AttributeName=country,AttributeType=S \
--key-schema \
  AttributeName=playerId,KeyType=HASH \
  AttributeName=country,KeyType=RANGE \
--billing-mode PAY_PER_REQUEST \
--endpoint-url http://localhost:8000
```
- Attributes in `key-schema` must also be in `attribute-definitions`
- Partition Key is known as a HASH attribute
- Sort Key is known as a Range attribute

## Describe Table
`aws dynamodb describe-table --table-name players --endpoint-url http://localhost:8000`

## Put Item to Table
`aws dynamodb put-item --table-name players --item '{"playerId": {"S": "player01"}, "country": {"S": "USA"}}' --endpoint-url http://localhost:8000`
