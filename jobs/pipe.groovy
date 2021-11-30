pipelineJob('pipeJob') {
    definition {
        cps {
            script(readFileFromWorkspace('jobs/pipe.groovy'))
            sandbox()
        }
    }
}