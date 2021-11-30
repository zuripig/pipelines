multibranchPipelineJob('seedTest/testPipeline') {
  steps {
    shell('echo Hello World!')
  }
}
