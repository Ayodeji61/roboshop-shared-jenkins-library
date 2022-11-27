def call() {
    pipeline {
        agent any

        options {
            ansiColor('xterm')
        }

        parameters {
            choice(name: 'ENV', choices: ['', 'dev', 'prod'], description: 'Environment')
            choice(name: 'ACTION', choices: ['', 'apply', 'destroy'], description: 'Action')
        }

        stages {

            stage('Terraform') {
                steps {
                    sh '''
            rm -rf .terraform*
            terrafile -f env-${ENV}/Terrafile
            terraform init -backend-config=env-${ENV}/backend.tfvars
            terraform ${ACTION} -auto-approve -var-file=env-${ENV}/main.tfvars
        '''
                }
            }


        }

    }
}