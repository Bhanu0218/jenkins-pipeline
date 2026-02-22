pipeline {
    agent any

    environment {
        IMAGE_NAME = "bhanu0218/jenkins-app"
        IMAGE_TAG = "${BUILD_NUMBER}"
    }

    stages {
        stage('Build Image') {
            steps {
                script {
                    docker.build("${IMAGE_NAME}:${IMAGE_TAG}")
                }
            }
        }

        stage('Push Image') {
            steps {
                script {
                    docker.withRegistry('', 'dockerhub-credentials-id') {
                        docker.image("${IMAGE_NAME}:${IMAGE_TAG}").push()
                    }
                }
            }
        }

        stage('Deploy to EC2') {
                    steps {
                        sshagent(['ec2-ssh-key-id']) {
                            bat "ssh ec2-user@YOUR_EC2_PUBLIC_IP \"export IMAGE_TAG=${BUILD_NUMBER} && docker-compose down && docker-compose pull && docker-compose up -d\""
                        }
                    }
                }
    }
}