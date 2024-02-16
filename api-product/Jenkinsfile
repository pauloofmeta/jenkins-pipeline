pipeline {
    agent any

    stages {
        stage ('Test') {
            // agent {
            //     docker { image 'node:lts-alpine' }
            // }
            steps {
                nodejs(nodeJSInstallationName: 'node21.6.1') {
                    sh 'yarn'
                    sh 'yarn test --coverage'
                }
            }
        }

        stage ('Quality Gate') {
            environment {
                SCANNER_HOME = tool 'SonarQubeScanner';    
            }

            steps {
                withSonarQubeEnv('SonarQube') {
                    sh "${SCANNER_HOME}/bin/sonar-scanner"
                }
            }
        }

        stage ('Build Image') {
            steps {
                script {
                    dockerapp = docker.build("pauloss/api-product:${env.BUILD_ID}")
                }
            }
        }
    }
}