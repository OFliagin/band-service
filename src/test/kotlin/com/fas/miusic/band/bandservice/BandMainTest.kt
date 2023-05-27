package com.fas.miusic.band.bandservice

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.utility.DockerImageName

@SpringBootTest
abstract class BandMainTest {

    companion object {
        @Container
        val postgres: PostgreSQLContainer<*> = PostgreSQLContainer(DockerImageName.parse("postgres:13.11"))
                .apply {
                    withDatabaseName("test")
                    withUsername("testuser")
                    withPassword("testpassword")
                    start()
                }
        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            val url = postgres::getJdbcUrl
            val userName = postgres::getUsername
            val password = postgres::getPassword
            registry.add("spring.datasource.url", url);
            registry.add("spring.datasource.username", userName);
            registry.add("spring.datasource.password", password);
            registry.add("spring.flyway.url", url);
            registry.add("spring.flyway.user", userName);
            registry.add("spring.flyway.password", password);
        }
    }


    init {
        Class.forName(postgres.driverClassName)
    }


}
