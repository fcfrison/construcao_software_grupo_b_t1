#!/bin/bash
#!/bin/bash

# Stop the running container
if sudo docker ps -q --filter "name=const_softw_app" | grep -q .; then
    echo "Stopping const_softw container"
    sudo docker stop const_softw_app
    sudo docker rm -v const_softw_app
else
    echo "No const_softw container running"
fi 

echo "Application stopped" 
echo "test"