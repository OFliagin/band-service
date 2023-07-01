package com.fas.miusic.band.bandservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["com.fas.miusic.band.bandservice.infrastructure.datasource.db"])
class BandServiceApplication

fun main(args: Array<String>) {
    runApplication<BandServiceApplication>(*args)
}
