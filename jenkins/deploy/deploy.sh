#!/bin/bash

echo "########################"
echo "*** Deploy container ***"
echo "########################"

cd jenkins/deploy/ && docker-compose -f docker-compose-deploy.yml up -d
