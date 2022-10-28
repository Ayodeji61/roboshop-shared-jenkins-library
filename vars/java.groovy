def call() {
    node {

            common.codeCheckout()
            stage('Compile Code') {
                sh 'mvn compile'
            }
            common.codeQuality()
            common.codeChecks()
            common.artifacts()
    }

}