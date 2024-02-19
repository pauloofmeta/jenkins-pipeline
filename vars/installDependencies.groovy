def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    timeout(60) {
       stage('Install Dependencies') {
           nodejs(nodeJSInstallationName: config.nodejsVersion) {
                sh 'npm install -g yarn'
                sh 'yarn install'
            }
       }
    }
}