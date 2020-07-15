pipeline {

    agent any

    stages {

        stage('Build') {
            steps {
		     sh '''
	        	./jenkins/build/mvn.sh mvn -B -DskipTests clean package
			./jenkins/build/build.sh
                ''' 
            }
			post {
                success {
                    archiveArtifacts artifacts: 'Login/target/*.jar', fingerprint: true, allowEmptyResults: true
                }
            }
		
        }                        
        stage('Test') {
            steps {
                sh './jenkins/test/test.sh mvn test'
            }
			post {
                always {
                    junit 'Login/target/surefire-reports/*.xml'
                }
			}
			
		}
        stage('Deploy') {
            steps {
                sh './jenkins/deploy/deploy.sh'           
            }
        }
    }
}
