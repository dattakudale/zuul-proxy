pipeline {
	
   agent none
	
    stages {
	  
        stage('build and push') {
	    	agent { 
	    		docker { 
	    					image 'maven:3.3.3' 
	    					args '-v $HOME/.m2:/root/.m2'
	    			} 
	    	} 	
		  
            steps {
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
                sh "mvn compile jib:build -Djib.to.auth.username=${env.GOOGLE_REGISTRY_USERNAME} -Djib.to.auth.password=${env.GOOGLE_REGISTRY_PASSWORD}"
            }
        }
        
    }
     
    
}
