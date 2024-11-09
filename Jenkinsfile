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
    }
}
