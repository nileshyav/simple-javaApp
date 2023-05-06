def gv
pipeline {
    agent {
    docker {
      image 'abhishekf5/maven-abhishek-docker-agent:v1'
      args '--user root -v /var/run/docker.sock:/var/run/docker.sock' // mount Docker socket to access the host's Docker daemon
    }
  }
    stages {

        stage('init'){
            steps{
                script{
                    gv = load 'script.groovy'
                }
            } 
        }
        
        stage('git checkout'){
            steps{
                sh 'echo passed'
                sh 'ls'
                
            }

        }

        stage("Build"){
            steps{
                // sh 'cd simple-java-app'
                sh 'mvn clean package'
            }

        }

        stage("static code analysis"){
            environment {
        SONAR_URL = "http://54.80.154.228:9000"
            }
            steps{
                withCredentials([string(credentialsId: 'sonarqube', variable: 'SONAR_AU')]){
                    sh 'mvn sonar:sonar -Dsonar.login=$SONAR_AU -Dsonar.host.url=${SONAR_URL}'
                }
            }
        }

        stage("Build image"){
            steps{
            //    withCredentials([usernamePassword(credentialsId: 'docker-cred', passwordVariable: 'pass', usernameVariable: 'user')]) {
            //     sh 'ls'
                
    
            //     sh 'docker build -t javaapp . '
            //     sh "echo $pass | docker login -u $user  --password-stdin"
            //     sh 'docker tag javaapp nileshyav/sample-java-spring-app:${BUILD_NUMBER}'
            //     sh 'docker push nileshyav/sample-java-spring-app:${BUILD_NUMBER} '
            //     }
            script{
                gv.buildImage()
                }
            }
        }
    }
}
