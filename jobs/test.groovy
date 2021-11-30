// multibranchPipelineJob('seedTest/testPipeline') {
//   steps {
//     shell('echo Hello World!')
//   }
// }


pipelineJob('seedTest/testPipe') { 
    properties {
        disableConcurrentBuilds()
    }

    logRotator {
        numToKeep(5)
    }
    
    definition {
        cpsScm {
            scm {
                git('git@github.com:zuripig/pipelines.git', 'mymain')
            }
            scriptPath("jobs/*.groovy")
        }
    }
}