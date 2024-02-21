def call() {
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