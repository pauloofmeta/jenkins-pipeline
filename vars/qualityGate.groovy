def sonarScanner() {
    environment {
        SCANNER_HOME = tool 'SonarQubeScanner';    
    }

    withSonarQubeEnv('SonarQube') {
        sh "${SCANNER_HOME}/bin/sonar-scanner"
    }
}

def waitForQualityGate() {
    waitForQualityGate abortPipeline: true
}