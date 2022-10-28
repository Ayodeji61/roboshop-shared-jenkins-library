def call() {
    env.APPTYPE = "nodejs"
    node {
        try {
            common.codeQuality()
            common.codeChecks()
            common.artifacts()
        } catch (Exception e) {
            mail bcc: '', body: "Build Failed ${RUN_DISPLAY_URL}", cc: '', from: 'dejispot@gmail.com', replyTo: '', subject: 'BUILD FAILURE', to: 'dejispot@gmail.com'
        }

    }

}