pipeline{
    agent any
    stages{
        stage("Gradle Build"){
            steps{
                echo '======= BUILD START ======='
                bat './gradlew clean build --info "-Dselenide.headless=true"'
                echo '====== BUILD FINISH ======'
            }
        }
        stage("TEST REPORT"){    
            steps {
                echo '======= TEST REPORT ======='
                archiveArtifacts artifacts: 'build/reports/tests/', fingerprint: true
                echo '======= TEST REPORT READY======='
            }
        }
    }
}
