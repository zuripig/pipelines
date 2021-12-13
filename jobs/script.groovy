def names = [
	'nuxt/node12': ['branch': 'mymain'],
	'nuxt/nod14': ['branch': 'mymain'],
    'nuxt/node16': ['branch': 'mymain'],
    'jenkins': ['branch': 'mymain'],
    'laravel/php72': ['branch': 'mymain'],
    'laravel/php74': ['branch': 'mymain'],
    'nginx-proxy': ['branch': 'mymain']

]

folder("base-images"){  
}

names.each { entry -> 
  appName = entry.key
  repoBranch = entry.value.branch

  pipelineJob("base_images/pipe-${entry.key}") { 
      properties {
          disableConcurrentBuilds()
      }

      environmentVariables {
          env('APP', appName)
	        env('BRANCH', repoBranch)
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