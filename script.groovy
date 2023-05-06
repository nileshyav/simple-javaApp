

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-cred', passwordVariable: 'pass', usernameVariable: 'user')]) {
                sh 'ls'
                sh 'docker build -t javaapp . '
                sh "echo $pass | docker login -u $user  --password-stdin"
                sh 'docker tag javaapp nileshyav/sample-java-spring-app:${BUILD_NUMBER}'
                sh 'docker push nileshyav/sample-java-spring-app:${BUILD_NUMBER} '
                }
} 

return this
