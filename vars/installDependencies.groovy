def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
        stage('Install Dependencies') {
            nodejs(nodeJSInstallationName: config.nodejsVersion) {
                sh 'npm install -g yarn'
                sh 'yarn install'
            }
        }
    }
}