// в каждом МС должен быть Dockerfile?

pipeline {
    agent any // как задаются агенты? Сколько их необходимо - как это определяется? В каком случае нужно их определять для каждого stage?
//    Для Kubernetes что нужно указывать?
//    agent { node { label "docker" } } - в каком случае используется нода?

    // какие блоки и в каком случае здесь нужны? 'environment' - всегда?
    tools {
            maven 'apache-maven-3.0.1' // указывать версию обязательно?
        }
    options {
        // Timeout counter starts AFTER agent is allocated
        timeout(time: 1, unit: 'SECONDS')
        }
    parameters {
        // для чего нужны? Чем отличаются от environment?
    }
    triggers {
            // чем определяется необходимость?
        }
	stages { // необходимое и достаточное количество этапов - ? (checkout, build, test, deploy)
		stage('GitHub Checkout') { // как правильно задать условие запуска билда при изменении ветки? Как предусмотреть запуск билда при создании ПР?

            input {
                 // в каком случае используется?
            }

		    when {

		    // Built-in Conditions - ?

		        branch 'master' // этого достаточно для отслеживания или нужно прописывать 'expression'

                expression {
                BRANCH_NAME == 'develop' || BRANCH_NAME == 'master' && CODE_CHANGES == true
                }
            }
            steps {
            	git 'https://github.com/yastrebow/helloJenkinsWorld'
            }
		stage('Maven Build') {
			steps{
                sh "mvn clean package" //наверное, каким-то образом должно задаваться хранилище артефактов?
			}
		}
		stage('Test') { // какими командами запускается тестирование? Как определяется механизм (что/где/когда)?
			steps {
				echo 'Test our build'
			}
		}
		stage('Deploy') { //
		    when {
		        branch 'master'
		    }
			steps {
			 sh "docker login -u=$REGISTRY_AUTH_USR -p=$REGISTRY_AUTH_PSW ${env.REGISTRY_ADDRESS}" // секьюритная история
             sh "docker stack deploy ${env.DEPLOY_STACK_NAME} -c ${env.COMPOSE_FILE} --with-registry-auth" // или Docker-compose надо использовать?
			}
		}
	}
}

// Pipeline - для каждого отдельного МС-ы? Взаимодействие МС прописывается в конфигах?
// должны быть в каждом МС манифесты написаны?