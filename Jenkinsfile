pipeline {
	
   agent any 
	
    stages {
	  
        stage('build') {
	    agent { docker { image 'maven:latest' } }  	
		
            steps {
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
                sh 'mvn clean install'
            }
        }
        
        stage('Make Container') {
	      steps {
			    sh "docker build -t zuul-proxy:${env.BUILD_ID} ."
			    sh "docker tag zuul-proxy:${env.BUILD_ID} zuul-proxy:latest"
	      }
    	}
    }
     
    
}
