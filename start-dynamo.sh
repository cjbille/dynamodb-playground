#!/usr/bin/env bash

mkdir -p /home/vscode/.aws

cat << EOF > /home/vscode/.aws/credentials
[default]
aws_access_key_id = foo
aws_secret_access_key = bar
EOF

cat << EOF > /home/vscode/.aws/config
[default]
region = local
EOF

java -Djava.library.path=/home/vscode/DynamoDBLocal_lib -jar /home/vscode/DynamoDBLocal.jar -sharedDb
