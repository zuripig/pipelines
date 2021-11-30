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
        cps {
            scm {
                git('git@github.com:zuripig/pipelines.git', 'mymain')
            }
            scriptPath("jobs/pipe.groovy")
        }
    }
}