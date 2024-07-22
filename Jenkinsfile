pipeline {

    agent any

    stages {

        stage("create and start containers") {
            steps {
                sh 'docker run -d -p 8080:8080 -p 8778:8778 --name spring_mock spring_mock'
                sh 'docker compose -f /home/jensa/spring_mock/compose-postgres-prometheus/compose.yml up -d'
                sh 'docker compose -f /home/jensa/spring_mock/compose-kafka/compose.yml up -d'
            }
        }

        stage("test") {
            steps {
                echo 'containers started'
            }
        }

    }
}