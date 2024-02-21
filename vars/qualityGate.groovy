def sonarScanner(String nodejsVersion) {
    nodejs(nodeJSInstallationName: "${nodejsVersion}") {
        withSonarQubeEnv('SonarQube') {
            sh "${SCANNER_HOME}/bin/sonar-scanner"
        }
    }
}

def qualityGateCheck() {
    def qualityGate = waitForQualityGate()
    if (qualityGate.status != 'OK') {
        error "Pipeline aborted due to quality gate failure: ${qualityGate.status}"
    }
}