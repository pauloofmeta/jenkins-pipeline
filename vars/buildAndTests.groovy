def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
        stage('Build and Tests') {
            nodejs(nodeJSInstallationName: "${config.nodejsVersion}") {
                sh 'yarn build'
                sh 'yarn test --coverage'
            }
        }
    }
}