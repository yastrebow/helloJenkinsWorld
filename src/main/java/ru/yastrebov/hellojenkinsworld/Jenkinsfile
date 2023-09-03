pipeline {
    agent any

	stages {
		stage('Build image') {
			steps{
			echo 'Выполняем команды для сборки'
			}
		}
		stage('Testing') {
			steps {
				echo 'Тестируем нашу сборку'
			}
		}
		stage('Deploy') {
			steps {
				echo 'Переносим код в рабочую среду или создаем артефакт'
			}
		}
	}
}