pipeline {
    agent any
    tools {
        maven 'maven_3_5_0'
    }
    stages {
        stage("Code Checkout"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Jassii/DevOps-Automation']])
            }
        }
        stage("Code Analysis"){
            environment {
                SONAR_URL = "http://localhost:9000"
            }
            steps{
                script{
                    withCredentials([string(credentialsId: 'sonarqube', variable: 'SONAR_AUTH_TOKEN')]) {
                        sh 'mvn sonar:sonar -Dsonar.login=$SONAR_AUTH_TOKEN -Dsonar.host.url=${SONAR_URL}'
                    }
                }
            }
        }
        stage("Build Maven Application"){
            steps{
                sh 'mvn clean install'
            }
        }
        stage("Build Docker Image"){
            steps{
                script{
                    sh "docker image build -t jasjeet1009/devops-automation:${BUILD_NUMBER} ."
                }
            }
        }
        stage("Push Docker Image to Hub"){
            steps{
                script{
                    // login to docker hub
                    withCredentials([usernamePassword(
                    credentialsId: "docker",  //i have already set this credentials in the Manage Jenkins
                    usernameVariable: "USER",
                    passwordVariable: "PASS"
                )]) {
                        sh "docker login -u '$USER' -p '$PASS'"
                    }
                    //now we can oush the image
                    sh "docker push jasjeet1009/devops-automation:${BUILD_NUMBER}"
                }
            }
        }
        stage('Update Deployment File') {
        environment {
            GIT_REPO_NAME = "DevOps-Automation"
            GIT_USER_NAME = "Jassii"
        }
        steps {
            withCredentials([string(credentialsId: 'github', variable: 'GITHUB_TOKEN')]) {
                sh '''
                    BUILD_NUMBER=${BUILD_NUMBER}
                    sed -i "s|image: jasjeet1009/devops-automation:.*|image: jasjeet1009/devops-automation:${BUILD_NUMBER}|g" application-manifests/deployment.yaml
                    git add application-manifests/deployment.yaml
                    git commit -m "Update deployment image to version ${BUILD_NUMBER}"
                    git push https://${GITHUB_TOKEN}@github.com/${GIT_USER_NAME}/${GIT_REPO_NAME} HEAD:main
                '''
            }
        }
    }
        
    }
}