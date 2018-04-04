#!/bin/sh

set -e

echo "Downloading Cloud Foundry cli"
curl -L "https://cli.run.pivotal.io/stable?release=linux64-binary&source=github" | tar -zx
mv cf /usr/bin

cd simple-spring-examples

mvn clean package
echo "Build complete"

cf --version
