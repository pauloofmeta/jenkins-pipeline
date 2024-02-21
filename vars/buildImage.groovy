def call(String imageName) {
    script {
        packageJSON = readJSON file: 'package.json'
        version = "${packageJSON.version}-${currentBuild.number}"

        echo "Building image with version ${version}"
        sh "docker build -t ${imageName}:${version} ."
    }
}