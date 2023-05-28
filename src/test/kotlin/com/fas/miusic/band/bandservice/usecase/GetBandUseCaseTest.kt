package com.fas.miusic.band.bandservice.usecase

import com.fas.miusic.band.bandservice.BandMainTest
import com.fas.miusic.band.bandservice.core.model.Band
import mu.KotlinLogging
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.util.CollectionUtils


class GetBandUseCaseTest : BandMainTest() {
    private val logger = KotlinLogging.logger {}


    @Autowired
    lateinit var getBandUseCase: GetBandUseCase

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    @AfterEach
   fun contextLoads() {
       jdbcTemplate
               .update(
                       "TRUNCATE TABLE band ")
   }


    @Test
    fun getBandAll() {
        logger.info("get all bands")
        insertBands(listOf( Band( "band1", "description1", 1), Band( "band2", "description2", 2)))
        val bands =  getBandUseCase.getAll()
        Assertions.assertEquals(bands.size, 2)
        Assertions.assertTrue(bands.stream().map { band -> band.name }.collect(java.util.stream.Collectors.toList()).containsAll(listOf("band1", "band2")))
    }

    @Test
    fun getBandOne() {
        insertBands(listOf( Band( "band1", "description1", 1), Band( "band2", "description2", 2)))
        val bands =  getBandUseCase.getAll()
        Assertions.assertFalse(CollectionUtils.isEmpty(bands))
        val id = bands[0].id
        var band = getBandUseCase.getBand(id!!)
        Assertions.assertEquals(bands[0], band)
    }



    fun insertBands(bands: List<Band>) {
        bands.forEach { band ->
            jdbcTemplate
                    .update(
                            "INSERT INTO band (name, description, adress_id)" +
                                    " VALUES ('${band.name}', '${band.description}', ${band.adressId})")
        }
    }
}