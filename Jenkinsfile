pipeline {
      agent any
      stages {
            stage('Init') {
                  steps {
                        echo 'Hi, this is our first Pipeline Job'
                        echo 'Testing my Pipeline part now'
                  }
            }
            stage('Build') {
                  steps {
                        echo 'Building Sample Maven Project'
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
