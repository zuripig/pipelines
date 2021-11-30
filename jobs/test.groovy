// job('seedTest/testJob') {
//   steps {
//     shell('echo Hello World!')
//   }
// }


pipelineJob('seedTest/testPipe') { 
    properties {
        disableConcurrentBuilds()
    }
    definition {
        cpsScm {
            scm {
                git('git@github.com:zuripig/pipelines.git', 'mymain')
            }
            scriptPath("docker/Jenkinsfile")
        }
    }
}