pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo '======= BUILD START ======='
        sh './gradlew clean build --info "-Dselenide.headless=true"'
        echo '====== BUILD FINISH ======'
      }
    }

  }
}
