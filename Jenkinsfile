pipeline{
	agent any
	
	stages {
		stage("Build"){
			steps {
				cmd_exec("mvn clean verify")
			}
		}
	}
		
}
