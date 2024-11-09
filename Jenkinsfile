pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo '======= BUILD START ======='
         pwsh(script: './gradlew clean build --info "-Dselenide.headless=true"')
        echo '====== BUILD FINISH ======'
      }
    }

  }
}
