def names = [
	'node12': [branch: 'mymain', repo: 'nuxt/'],
	'node14': [branch: 'mymain', repo: 'nuxt/'],
    'node16': [branch: 'mymain', repo: 'nuxt/'],
    'jenkins': [branch: 'mymain', repo: ''],
    'php72': [branch: 'mymain', repo: 'laravel/'],
    'php74': [branch: 'mymain', repo: 'laravel/'],
    'nginx-proxy': [branch: 'mymain', repo: '']

]

folder("base_images"){  
}

names.each { entry -> 
  appName = entry.value.repo + entry.key
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