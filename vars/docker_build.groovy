def call(String dockerHubUser, String imageName, String imageTag){
  sh "docker build -t ${dockerHubUser}/${imageName}:${imageTag} ." 
}
