pipeline {
    agent any

    triggers {
        pollSCM 'H/2 * * * *'
    }

    environment {
        // If needed, define environment variables
    }

    stages {
        stage('Build & Test') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn clean test'
                    } else {
                        bat 'mvn clean test'
                    }
                }
            }
        }
    }

    post {
        always {
            // Archive TestNG/Surefire reports
            junit '**/target/surefire-reports/*.xml'
            
            // Archive HTML reports and Screenshots
            archiveArtifacts artifacts: 'target/surefire-reports/**/*, test-output/**/*', allowEmptyArchive: true
        }
        failure {
            // Email on build failure
            mail to: 'admin@example.com',
                 subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                 body: "Something is wrong with ${env.BUILD_URL}"
        }
    }
}
