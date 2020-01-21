pipeline {
      agent any
      stages {
            stage('Checkout') {
                  steps {
                        echo 'Hi, this is our first Pipeline Job'
                        git 'https://github.com/devopsfoundary/java_backend.git'
                  }
            }
            stage('Build') {
                  steps {
                        echo 'Building Sample Maven Project'
                        sh "mvn -Dmaven.test.failure.ignore=true clean package"            
                  }
            }
            stage('Deploy') {
                  steps {
                        echo "Deploying in Testing Server"
                  }
            }
            stage('Deploy to Stage') {
                  steps {
                        echo "Deploying in Stage Server"
                  }
            }
      }
}
