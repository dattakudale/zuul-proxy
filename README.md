# zuul-proxy


## Build with maven 
mvn clean install

## Docker command

docker build -t zuul-proxy:v1 .

## Run with Docker

docker run zuul-proxy:v1


## Run with Kubernetes  using google cloud and use your porject.


docker tag zuul-proxy:v1 gcr.io/appsutility-141503/zuul-proxy:v1

gcloud docker -- push gcr.io/appsutility-141503/zuul-proxy:v1

## If you want run and validate

kubectl run zuul-proxy --image=gcr.io/appsutility-141503/zuul-proxy:v1


## Deploy spring boot using Kubernet deployment file

kubectl create -f zuul-proxy-service.yaml	

## Update deployment with v2 version 

kubectl set image deployment/zuul-proxy zuul-proxy=gcr.io/appsutility-141503/zuul-proxy:v2


## Create multiple instances ( Replicas )   , below will create 3 instances of zuul proxy 

kubectl scale deployment zuul-proxy --replicas=3



