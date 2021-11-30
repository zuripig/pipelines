job('thejob') {
  scm {
    git ('https://github.com/zuripig/pipelines.git')
  }
  steps {
    dsl {
      external('jobs/*.groovy')
    }
  }
}
