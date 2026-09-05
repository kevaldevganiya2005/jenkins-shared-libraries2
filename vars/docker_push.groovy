def call(String dockerHubUsername, String imageName, String imageTag){
  withCredentials([usernamePassword(
    credentialsId: 'dockerhub-creds',
    usernameVariable: 'dockerHubUsername',
    passwordVariable: 'dockerHubPass'
  )]){
    sh 'echo "$dockerHubPass" | docker login -u "${dockerHubUsername}" --password-stdin'
    sh "docker push ${dockerHubUsername}/${imageName}:${imageTag}"
  }
}
