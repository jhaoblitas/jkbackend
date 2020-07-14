#!/bin/bash

echo "****************"
echo "* Building jar!*"
echo "****************"


docker run -v /root/.m2:/root/.m2 -v $PWD/Login:/Login -w /Login maven:3-alpine "$@"
