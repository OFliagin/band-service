package com.fas.miusic.band.bandservice.usecase

import com.fas.miusic.band.bandservice.core.model.Band
import com.fas.miusic.band.bandservice.infrastructure.datasource.db.BandRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class SaveBandUseCase(val repository: BandRepository) {
    val logger = KotlinLogging.logger {}


    fun saveBand(band: Band) : Band {
        logger.info("save band $band")
        return repository.save(band)
    }

}