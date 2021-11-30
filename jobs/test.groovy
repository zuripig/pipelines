def names = [
	'centos7': ['branch': 'mymain'],
	'centos8': ['branch': 'mymain'],
  'centos6': ['branch': 'mymain']
]

names.each { entry -> 
  appName = entry.key
  repoBranch = entry.value.branch

  pipelineJob("seedTest/pipe-${entry.key}") { 
      properties {
          disableConcurrentBuilds()
      }

      environmentVariables {
          env('APP', "pip-"+appName)
	        env('BRANCH', branchName)
      }
      definition {
          cpsScm {
              scm {
                  git('https://github.com/zuripig/pipelines.git', 'mymain')
              }
              scriptPath("docker/Jenkinsfile")
          }
      }
  }
}