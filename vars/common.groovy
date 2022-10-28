def codeQuality() {
    stage('Code Quality') {
        echo 'Code Quality'
        }
    }


def codeChecks() {
    if ( env.BRANCH_NAME == "main" || env.TAG_NAME ==~ ".*" ) {

        stage('Style & Lint Checks') {
            echo 'Style Checks'
        }

        stage('Unit Tests') {
            echo 'Unit Tests'
        }
    }
}

def artifacts() {
    if ( env.TAG_NAME ==~ ".*" ) {

        stage('Download Dependecies') {
            echo 'Download Dependencies'
        }

        stage('Prepare Artifacts') {
            echo 'Prepare Artifacts'
        }
        }
    }