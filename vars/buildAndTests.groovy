def call(String nodejsVersion) {
    nodejs(nodeJSInstallationName: "${nodejsVersion}") {
        sh 'yarn test --coverage'
    }
}