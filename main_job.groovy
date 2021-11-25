job('seed/seed-job') {
  scm {
    git ('https://github.com/zuripig/pipelines.git')
  }
  steps {
    dsl {
      external('jobs/*.groovy')
    }
  }
}
