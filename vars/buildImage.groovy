def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
        stage('Build Image') {
            packageJSON = readJSON file: 'package.json'
            version = "${packageJSON.version}-${currentBuild.number}"
            echo "Building image with version ${version}"
            sh "docker build -t ${config.imageName}:${version} ."
        }
    }
}