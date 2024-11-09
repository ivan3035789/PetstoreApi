pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Build start'
        bat(script: './gradlew clean build --info "-Dselenide.headless=true"', encoding: 'UTF-8', returnStatus: true)
      }
    }

    stage('Build finish') {
      steps {
        echo 'build finih'
      }
    }

  }
}