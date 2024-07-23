pipeline {

    agent any

    stages {

        stage("create and start containers") {
            steps {
            	sh 'docker build --no-cache -t spring_mock .' 
            }
        }

        stage("deploy") {
            steps {
                sh 'docker run -d -p 8080:8080 -p 8778:8778 --name spring_mock spring_mock'
            }
        }

        stage("test") {
            steps {
                sh 'curl http://localhost:8080/user'
            }
        }

    }
	post {
	// Clean after build
	always {
	    cleanWs(cleanWhenNotBuilt: true,
		    deleteDirs: true,
		    disableDeferredWipeout: true,
		    notFailBuild: true,
		    patterns: [[pattern: '.gitignore', type: 'INCLUDE'],
		               [pattern: '.propsfile', type: 'EXCLUDE']])
        }
    }
}
