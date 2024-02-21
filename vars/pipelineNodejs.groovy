def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    installDependencies {
        nodejsVersion = config.nodejsVersion
    }

    buildAndTests {
        nodejsVersion = config.nodejsVersion
    }

    qualityGate()

    buildImage {
        imageName = config.imageName
    }
}