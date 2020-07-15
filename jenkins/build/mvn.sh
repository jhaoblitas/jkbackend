#!/bin/bash

echo "****************"
echo "* Building jar!*"
echo "****************"

RUTA=/home/hector/Desktop/jenkins/jenkins_home/workspace/login-backend
sudo chmod 777 $RUTA/Login/
docker run -v /root/.m2:/root/.m2 -v $RUTA/Login:/Login -w /Login maven:3-alpine "$@"
