package com.fas.miusic.band.bandservice.usecase

import com.fas.miusic.band.bandservice.infrastructure.datasource.db.BandRepository
import mu.KotlinLogging

class DeleteBandUseCase(val repository: BandRepository) {
    private val logger = KotlinLogging.logger {}

    fun deleteBand(id: Long) {
        logger.info("delete band $id")
        repository.deleteById(id)
    }
}