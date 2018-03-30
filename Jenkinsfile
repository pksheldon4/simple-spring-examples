pipeline {
    agent any
    tools {
        maven 'Maven 3.3.9'
        jdk 'Java8 JDK'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
                sh "mvn --version"
            }
        }

        stage ('Build') {
            steps {
                echo 'execute mvn clean install'
                sh "mvn clean install"
            }
        }
        stage ('Deploy Green') {
          steps {
            withCredentials([usernamePassword(credentialsId: 'pksivPivotalId', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
              sh 'cf login -u $USERNAME -p $PASSWORD -a api.run.pivotal.io --skip-ssl-validation'
              sh 'cf push simple-spring-examples-green -n simple-spring-examples-ps-green'
              sh 'cf map-route simple-spring-examples-green cfapps.io -n simple-spring-examples-ps-green'
            }
          }
        }
        stage ('Route Traffic to Green ?') {
          input {
            message "Route traffic to Green instance?"
            ok "Yes"
          }
          steps {
            withCredentials([usernamePassword(credentialsId: 'pksivPivotalId', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
              sh 'cf map-route simple-spring-examples-green cfapps.io -n simple-spring-examples-ps'
            }
          }
        }
        stage ('Unroute Traffic from Blue ?') {
          input {
            message "Stop routing traffic to Blue instance?"
            ok "Yes"
          }
          steps {
            withCredentials([usernamePassword(credentialsId: 'pksivPivotalId', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
              sh 'cf unmap-route simple-spring-examples cfapps.io -n simple-spring-examples-ps'
              sh 'cf unmap-route simple-spring-examples-green cfapps.io -n simple-spring-examples-ps-green'
            }
          }
        }
        stage ('Cleanup Instances?') {
          input {
            message "Delete blue instance, delete temporary green route, rename green application."
            ok "Yes"
          }
          steps {
            withCredentials([usernamePassword(credentialsId: 'pksivPivotalId', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
              sh 'cf delete simple-spring-examples -f'
              sh 'cf delete-route cfapps.io -n simple-spring-examples-ps-green -f'
              sh 'cf rename simple-spring-examples-green simple-spring-examples'
            }
          }
        }
    }
}
