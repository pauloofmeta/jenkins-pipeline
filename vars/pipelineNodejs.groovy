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
                steps {
                    qualityGate()
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