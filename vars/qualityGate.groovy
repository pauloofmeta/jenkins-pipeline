def sonarScanner() {
    environment {
        SCANNER_HOME = tool 'SonarQubeScanner';    
    }

    withSonarQubeEnv('SonarQube') {
        sh "${SCANNER_HOME}/bin/sonar-scanner"
    }
}

def waitForQualityGate() {
    def qualityGate = waitForQualityGate()
    if (qualityGate.status != 'OK') {
        error "Pipeline aborted due to quality gate failure: ${qualityGate.status}"
    }
}