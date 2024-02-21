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
                installDependencies(config.nodejsVersion)
            }

            stage('Build and Tests') {
                buildAndTests(config.nodejsVersion)
            }

            stage('Quality Gate') {
                qualityGate()
            }

            stage('Build Image') {
                buildImage(config.imageName)
            }
        }
    }
}