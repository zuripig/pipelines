# Base image builder

>▶︎ Requires Job DSL plugin and Environment Injector plugin to be installed in Jenkins. ◀︎

A 'seed' project is created on the Jenkins server. This job uses the Job DSL plugin, having being given the location of the groovy script that defines the pipelines that require creating.

This groovy script contains the information needed to build the pipelines, such as piepline names, repository locations and branch identifiers. It also contains the location and name of the Jenkinsfile that will be used to build the base images, and passes this along with environmental variables, into each new pipeline configuration.

Once the seed job has been run, the Jenkins server will now have a folder containing all the created pipelines. These pipelines will each execute the Jenkinsfile given by the groovy script. Each pipeline will then build, scan and output its own base image. It will do this for each base image by getting the corresponding Dockerfiles from the base-images Github repo.

![[images/git1.png|width=100px]]

*Base images located at nexuspointltd/base-images*
