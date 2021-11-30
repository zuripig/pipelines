pipelineJob('pipeJob') {
    definition {
        cps {
            script(readFileFromWorkspace('pipe.groovy'))
            sandbox()
        }
    }
}