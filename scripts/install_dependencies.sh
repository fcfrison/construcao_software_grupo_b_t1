#!/bin/bash

# Install Docker if not present
if ! command -v docker &> /dev/null
then
    sudo apt-get update
    sudo apt-get install -y docker.io
    sudo systemctl start docker
    sudo systemctl enable docker
    echo "Docker installed successfully."
else
    echo "Docker is already installed."
fi

# Navigate to the directory containing the Dockerfile
cd /home/ubuntu

# Check if Dockerfile exists
if [ ! -f "Dockerfile" ]; then
    echo "Error: Dockerfile not found in /home/ubuntu"
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