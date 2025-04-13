pipeline {
    agent any
    parameters {
        // 手动选择分支，添加了 dev 和 test 分支供选择
        choice(name: 'BRANCH', choices: 'main\ndev\ntest', description: '选择要构建的分支')
        // 手动选择模块
        choice(name: 'MODULE', choices: 'gateway\nauth\nmanager\ndata', description: '选择要构建的模块')
    }
    environment {
        DOCKER_COMPOSE_FILE = 'dc3/docker-compose.yml'
    }
    stages {
        stage('Checkout') {
            steps {
                script {
                    echo "正在从分支 ${params.BRANCH} 获取代码..."
                    // 检出代码
                    checkout([$class: 'GitSCM',
                        branches: [[name: "*/${params.BRANCH}"]],
                        userRemoteConfigs: [[url: 'https://bgithub.xyz/siwenbailei/iot-dc3.git']]
                    ])
                }
            }
        }
        stage('Deploy with Docker Compose') {
            steps {
                script {
                    echo "正在使用 Docker Compose 启动 ${params.MODULE}..."
                    // 使用 docker-compose 启动指定模块并强制重新构建镜像
                    sh "docker-compose -f ${env.DOCKER_COMPOSE_FILE} up -d --build ${params.MODULE}"
                }
            }
        }
    }
    post {
        success {
            echo "模块 ${params.MODULE} 部署成功！"
        }
        failure {
            echo "模块 ${params.MODULE} 部署失败，请检查日志。"
        }
    }
}
