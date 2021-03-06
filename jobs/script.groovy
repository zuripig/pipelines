def names = [
	'node12': [branch: 'master', folder: 'nuxt/'],
	'node14': [branch: 'master', folder: 'nuxt/'],
    'node16': [branch: 'master', folder: 'nuxt/'],
    'jenkins': [branch: 'master', folder: ''],
    'php72': [branch: 'master', folder: 'laravel/'],
    'php74': [branch: 'master', folder: 'laravel/'],
    'php8': [branch: 'master', folder: 'laravel/'],
    'php8-tco': [branch: 'master', folder: 'laravel/'],
    'fincalc': [branch: 'master', folder: 'laravel/'],
    'nginx-proxy': [branch: 'master', folder: '']

]

folder("base_images"){  
}

names.each { entry -> 
  appName = entry.value.folder + entry.key
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
              scriptPath("docker/NPjenkinsfile")
          }
      }
  }
}