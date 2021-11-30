// multibranchPipelineJob('seedTest/testPipeline') {
//   steps {
//     shell('echo Hello World!')
//   }
// }


pipelineJob('seedTest/testPipe') { 
    properties {
        disableConcurrentBuilds()
    }
    definition {
        cps {
            scm {
                git('git@github.com:zuripig/pipelines.git', 'mymain')
            }
            scriptPath("jobs/*.groovy")
        }
        steps {
          shell('echo HIYA!')
        }
    }
}