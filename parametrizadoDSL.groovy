job('ejemplo2-job-DSL') {
    description('Job DSL de ejemplo para el curso de Jenkins')
    scm {
        git('https://github.com/macloujulian/jenkins.job.parametrizado.git', 'main') { node ->
            node / gitConfigName('joligato')
            node / gitConfigEmail('joligato@gmail.com')
        }
    }
    parameters {
        stringParam('nombre', defaultValue = 'jose', description = 'Parametro de cadena para el Job Boolean')
        choiceParam('planeta', ['Mercurio', 'Venus', 'Tierra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno', 'Pluton'])
        booleanParam('agente', false)
    }
    triggers {
        cron('H/10 * * * *')
    }
    steps {
        shell('bash jobscript.sh')
    }
    publishers {
        mailer('joligato@gmail.com', true, true)
    }
}