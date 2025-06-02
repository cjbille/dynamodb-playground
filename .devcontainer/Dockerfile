FROM mcr.microsoft.com/devcontainers/base:ubuntu

SHELL ["/bin/bash", "-c"]    
USER vscode
RUN curl -s "https://get.sdkman.io" | bash \
&& source "$HOME/.sdkman/bin/sdkman-init.sh" \
&& sdk install sdk install java 21.0.2-graalce  \
&& sdk install maven 3.9.9 \
&& cd /home/vscode \
&& curl "https://d1ni2b6xgvw0s0.cloudfront.net/v2.x/dynamodb_local_latest.tar.gz" -o "dynamodb.tar.gz" \
&& tar zxvf dynamodb.tar.gz

USER root
RUN cd /home/vscode \
&& curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip" \
&& unzip awscliv2.zip \
&& ./aws/install
