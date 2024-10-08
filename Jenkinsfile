pipeline {
    agent any

    environment {
        // Define any environment variables if needed
        MAVEN_HOME = tool name: 'Maven 3.9.8', type: 'maven'
        SONAR_TOKEN = credentials('sonar-cloud-token')
        SONAR_ORGANIZATION = 'bhargavivennam'
        BRANCH_NAME = 'main'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from GitHub
                git url: 'https://github.com/bhargavivennam/user_details.git', branch: "${BRANCH_NAME}"
            }
        }

        stage('Build') {
            steps {
                // Run Maven build
                sh "${MAVEN_HOME}/bin/mvn clean install"
            }
        }

        stage('Test') {
            steps {
                // Run tests
                sh "${MAVEN_HOME}/bin/mvn test"
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarCloud') {
                sh "./mvnw sonar:sonar -Dsonar.login=${SONAR_TOKEN} -Dsonar.organization=$SONAR_ORGANIZATION -Dsonar.branch.name=$BRANCH_NAME"
                }
            }
        }

        //SONAR
        //Docker Image

        // stage('Deploy') {
        //     steps {
        //         // Deploy to an environment (e.g., staging or production)
        //         // You can customize this step based on your deployment strategy
        //         sh "${MAVEN_HOME}/bin/mvn deploy"
        //     }
        // }
    }

    post {
        // always {
        //     junit '**/target/surefire-reports/*.xml'
        // }
        success {
            echo 'Build and Test were successful!'
        }
        failure {
            echo 'Build or Test failed.'
        }
    }
}
