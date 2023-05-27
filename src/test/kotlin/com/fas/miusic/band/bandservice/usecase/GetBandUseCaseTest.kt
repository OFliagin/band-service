package com.fas.miusic.band.bandservice.usecase

import com.fas.miusic.band.bandservice.BandMainTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate


class GetBandUseCaseTest : BandMainTest() {



    @Autowired
    lateinit var getBandUseCase: GetBandUseCase

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    @BeforeEach
   fun contextLoads() {
       println("+++++++++++++++++++++++++++++++++++++INSERT+++++++++++++++++++++++++++++++")
       jdbcTemplate
               .update(
                       "INSERT INTO band (name, description, adress_id)" +
                               " VALUES ('Test', 'description', 1)")
        println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
   }


    @Test
    fun getBandTest() {
        var band =  getBandUseCase.getAll()
        println("+++++++++++++++++++++++++++++++++++RES+++++++++++++++++++++++++++++++++")
        println(band)
    }
}