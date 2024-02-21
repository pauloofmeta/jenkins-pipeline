def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
        stage('Build Image') {
            sh 'docker build -t ${config.imageName} .'
        }
    }
}