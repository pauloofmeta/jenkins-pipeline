def call(String nodejsVersion) {
    nodejs(nodeJSInstallationName: "${nodejsVersion}") {
        sh 'npm install -g yarn'
        sh 'yarn install'
    }
}