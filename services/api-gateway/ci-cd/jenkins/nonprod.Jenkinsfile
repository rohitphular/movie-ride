node {

    sh """
        echo $JAVA_HOME
        echo $M2_HOME
    """

    stage('Checkout') {
        sh 'echo Branch checkout completed'
    }

    stage('Clean') {
        sh '''
            cd services/api-gateway
            mvn clean
        '''
    }

    stage('Compile') {
        sh '''
            cd services/api-gateway
            mvn compile
        '''
    }

    stage('Package') {
        sh '''
            cd services/api-gateway
            mvn package
        '''
    }

    stage('Login ECR') {
        sh '''
            aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 134826874601.dkr.ecr.us-east-1.amazonaws.com
        '''
    }

    stage('Tag Image') {
        sh '''
            echo ${BUILD_NUMBER}
            docker tag api-gateway:latest 134826874601.dkr.ecr.us-east-1.amazonaws.com/api-gateway:nonprod-${BUILD_NUMBER}
        '''
    }

    stage('Push to ECR') {
        sh '''
            docker push 134826874601.dkr.ecr.us-east-1.amazonaws.com/api-gateway:nonprod-${BUILD_NUMBER}
        '''
    }

}