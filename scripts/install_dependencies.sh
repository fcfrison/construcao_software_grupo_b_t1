#!/bin/bash

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
sudo docker build -t const_softw:latest .