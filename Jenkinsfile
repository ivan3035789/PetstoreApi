pipeline {
  agent any
  stages {
    stage('Build') {
      agent any
      steps {
        echo '======= BUILD START ======='
        pwsh(script: './gradlew clean build --info "-Dselenide.headless=true"', returnStatus: true, returnStdout: true)
        echo '====== BUILD FINISH ======'
      }
    }

  }
}