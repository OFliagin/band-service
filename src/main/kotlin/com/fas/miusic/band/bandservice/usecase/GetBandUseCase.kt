package com.fas.miusic.band.bandservice.usecase

import com.fas.miusic.band.bandservice.core.model.Band
import com.fas.miusic.band.bandservice.infrastructure.datasource.db.BandRepository
import mu.KotlinLogging

class GetBandUseCase(val repository: BandRepository) {
    private val logger = KotlinLogging.logger {}

    fun getBand(id: Long) : Band {
        logger.info("get band by id $id")
        val findById = repository.findById(id).orElseThrow()
        logger.debug { "band found ${findById.id}" }
        return findById
    }

    fun getAll(): List<Band> {
        logger.info("get all bands")
        val bands = repository.findAll().toList()
        logger.debug { "bands found ${bands.size}" }
        return bands
    }
}