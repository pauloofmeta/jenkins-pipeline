def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
        stage('Quality Gate') {
            environment {
                SCANNER_HOME = tool 'SonarQubeScanner';    
            }

            steps {
                withSonarQubeEnv('SonarQube') {
                    sh "${SCANNER_HOME}/bin/sonar-scanner"
                }
                waitForQualityGate abortPipeline: true
            }
        }
    }
}