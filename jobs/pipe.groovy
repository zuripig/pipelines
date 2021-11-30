pipelineJob('seedTest/testPipe') {
  steps {
    shell('echo Hello World!')
  }
}