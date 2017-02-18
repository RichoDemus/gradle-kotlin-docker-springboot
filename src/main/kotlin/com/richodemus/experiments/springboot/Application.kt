package com.richodemus.experiments.springboot

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean


@SpringBootApplication
open class Application {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }

    @Bean
    open fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner {
        return MyCommandlineRunner(ctx)
    }

    open class MyCommandlineRunner(val ctx: ApplicationContext) : CommandLineRunner {
        override fun run(vararg args: String?) {
            println("Let's inspect the beans provided by Spring Boot:")
            ctx.beanDefinitionNames.asList().sorted().forEach(::println)
        }
    }
}
