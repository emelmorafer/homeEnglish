pipeline{
	//where and how to execute the Pipeline
	agent {
    	label 'Slave_Induccion'
	}
	
	options {
		buildDiscarder(logRotator(numToKeepStr: '5')) 
		disableConcurrentBuilds()
	}
	
	tools {
		jdk 'JDK8_Centos'
		gradle 'Gradle4.5_Centos'
	}
	
	stages{
		stage('Checkout') {
			steps{
				echo "------------>Checkout<------------"
				checkout(
					[
						$class: 'GitSCM', 
						branches: [[name: 'master']], 
						doGenerateSubmoduleConfigurations: false, 
						extensions: [], 
						gitTool: 'Git_Centos', 
						submoduleCfg: [], 
						userRemoteConfigs: 
						[
							[
								credentialsId: 'GitHub_emelmorafer', 
								url: 'https://github.com/emelmorafer/homeEnglish'
							]
						]
					]
				)
				sh '​gradle​ --b ​./homeEnglish/build.gradle clean compileJava​'
			}
		}
			
		stage('Compile & Unit Tests') {
			steps{
				echo "------------>Unit Tests<------------"
				sh 'gradle --b ./build.gradle compileJava'
			}
		}
		
		stage('Static Code Analysis') {
			steps{
				echo "------------>Análisis de código estático con Sonar<------------"
				withSonarQubeEnv('Sonar') {
					sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
				}
			}
		}
		
		stage('Build') {
			steps{
				echo "------------>Build<------------"			
				//Construir sin tarea test que se ejecutó previamente
				sh 'gradle --b ./build.gradle build -x test'
			}
		}
	}
	
	
	post{
	
		success {
			echo "This will run only if successful"	
			//send notifications about a Pipeline to an email		
			junit 'build/test-results/test/*.xml'
			mail (to: 'emel.mora@ceiba.com.co',
			     subject: "Success Pipeline: ${currentBuild.fullDisplayName}",
			     body: "Everything is ok with ${env.BUILD_URL}")
		}
	
		failure {
			echo "This will run only if failed"
			//send notifications about a Pipeline to an email
			mail (to: 'emel.mora@ceiba.com.co',
			     subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
			     body: "Something is wrong with ${env.BUILD_URL}")
		}		
	
	}

}