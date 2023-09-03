pipeline {
    agent any

	stages {
		stage('Build image') {
			steps{
			echo 'Execute build-commands'
			}
		}
		stage('Testing') {
			steps {
				echo 'Test our build'
			}
		}
		stage('Deploy') {
			steps {
				echo 'Move code in the working environment or create artifacts'
			}
		}
	}
}