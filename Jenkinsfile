pipeline {

    agent any

    stages {

        stage("create and start containers") {
            steps {
            	sh 'pwd && ls'
            	sh 'docker build -t spring_mock .' 
                sh 'docker run -d -p 8080:8080 -p 8778:8778 --name spring_mock spring_mock'
            }
        }

        stage("test") {
            steps {
                echo 'containers started'
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
