def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    pipeline {
        agent any

        stages {
            stage('Checkout') {
                steps {
                    checkout scm
                }
            }

            stage('Install Dependencies') {
                steps {
                    installDependencies(config.nodejsVersion)
                }
            }

            stage('Build and Tests') {
                steps {
                    buildAndTests(config.nodejsVersion)
                }
            }

            stage('Quality Gate') {
                environment {
                    SCANNER_HOME = tool 'SonarQubeScanner';    
                }
                steps {
                    script {
                        qualityGate.sonarScanner(config.nodejsVersion)
                        qualityGate.qualityGateCheck()
                    }
                    
                }
            }

            stage('Build Image') {
                steps {
                    buildImage(config.imageName)
                }
            }
        }
    }
}