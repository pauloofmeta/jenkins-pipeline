def call() {
    node {
        stage('Checkout') {
            checkout scm
        }
    }
}