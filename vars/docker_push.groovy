def call(String dockerHubUsername, String imageName, String imageTag){
  withCredentials([usernamePassword(
    credentialsId: 'dockerhub-creds',
    usernameVariable: 'dockerHubUsername',
    passwordVariable: 'dockerHubPass'
  )]){
    sh 'echo "$dockerHubpass" | docker login -u "${dockerHubUser}" --password-stdin'
    sh 'docker push ${dockerHubUsername}/${imageName}:${imageTag}'
  }
}
