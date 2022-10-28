def call() {
    node {

            common.codeCheckout()
            common.codeQuality()
            common.codeChecks()
            common.artifacts()

    }

}