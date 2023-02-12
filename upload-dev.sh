#!/bin/bash
#nohup deploy-intra > deploy-intra-std.out 2> deploy-intra.err < /dev/null &
args=("$@")

projectName=/"jwt"
versionNumber=revision"${args[0]}"
imageTagPrefix=/staging
host=localhost:8888
imageFullName="${host}${imageTagPrefix}${projectName}":"${versionNumber}"
echo "${imageFullName}"

# --build-arg PROFILE=dev
./gradlew clean build
docker build -t staging"${projectName}":latest --build-arg JAR_FILE=jwt-1.0-SNAPSHOT.jar -f dockerfiles/dev/Dockerfile .
docker tag staging"${projectName}":latest "${imageFullName}"
docker push "${imageFullName}"

#revision:1
#