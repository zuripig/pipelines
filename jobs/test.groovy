// multibranchPipelineJob('seedTest/testPipeline') {
//   steps {
//     shell('echo Hello World!')
//   }
// }


// pipelineJob("$basePath/dev/admin") { 
//     properties {
//         disableConcurrentBuilds()
//     }

//     environmentVariables {
//         env('APP', 'admin')
//         env('REPO', 'apex-suite-core')
//         env('DEPLOY_ACCOUNT_ID', "156498023621")
//         env('BRANCH', 'master')
//     }

//     logRotator {
//         numToKeep(5)
//     }
    
//     definition {
//         cpsScm {
//             scm {
//                 git('git@github.com:nexuspointltd/nexuspoint-pipelines.git', 'master')
//             }
//             scriptPath("apex-tenants/Jenkinsfile")
//         }
//     }
// }

multibranchPipelineJob('pipeline') {
    branchSources {
        git {
            // id('123456789') // IMPORTANT: use a constant and unique identifier
            remote('https://github.com/zuripig/pipelines.git')
            // credentialsId('github2')
            // includes('JENKINS-*')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}