#!/bin/bash

echo "Building the entire project"
bash mvnw clean install
echo "Project build complete\n"

echo "Building the docker image; fitnesse-sample-docker"
docker image build -t fitnesse-sample-docker .
echo "Docker image build completed"
