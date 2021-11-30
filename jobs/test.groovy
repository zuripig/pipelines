def names = [
	'centos7': ['branch': 'mymain'],
	'centos8': ['branch': 'mymain']
]

names.each { entry -> 
  appName = entry.key


  pipelineJob("seedTest/pipe-${entry.key}") { 
      properties {
          disableConcurrentBuilds()
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