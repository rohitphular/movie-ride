pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                sh 'echo Branch checkout completed'
            }
        }

        stage('Clean') {
            steps {
                dir('services/api-gateway') {
                    sh 'mvn clean'
                }
            }
        }

        stage('Compile') {
            steps {
                dir('services/api-gateway') {
                    sh 'mvn compile'
                }
            }
        }

        stage('Package & Build docker image') {
            steps {
                dir('services/api-gateway') {
                    sh 'mvn package'
                }
            }
        }

        stage('Push to docker hub') {
            environment {
                DOCKER_HUB_LOGIN = credentials('docker-user')
            }

            steps {
                sh 'docker login --username=$DOCKER_HUB_LOGIN_USR --password=$DOCKER_HUB_LOGIN_PSW'
                sh 'docker image tag api-gateway:latest rohitphular/api-gateway:local-latest'
                sh 'docker image push rohitphular/api-gateway:local-latest'
            }
        }
    }
}