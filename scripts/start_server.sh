#!/bin/bash
if [ ! -f "Dockerfile" ]; then
    echo "Error: Dockerfile not found in $PWD"
    exit 1
fi

# Build the Docker image
sudo docker build -t const_softw:latest .

# Check if the build was successful
if [ $? -eq 0 ]; then
    echo "Docker image built successfully"
else
    echo "Error: Docker image build failed"
    exit 1
fi
sudo docker run -d --restart always --name const_soft_app -p 8080:8080 const_softw