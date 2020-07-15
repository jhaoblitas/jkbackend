#!/bin/bash

echo "****************"
echo "* Building jar!*"
echo "****************"
   
sudo chmod -R 777 Login/
RUTA=/home/hector/Desktop/jenkins/jenkins_home/workspace/login-backend
docker run -v /root/.m2:/root/.m2 -v $RUTA/Login:/Login -w /Login maven:3-alpine "$@"
