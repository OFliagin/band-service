package com.fas.miusic.band.bandservice.usecase

import com.fas.miusic.band.bandservice.core.model.Band
import com.fas.miusic.band.bandservice.infrastructure.datasource.db.BandRepository
import mu.KotlinLogging

class ExecuteBandUseCase(val repository: BandRepository) {
    private val logger = KotlinLogging.logger {}

    fun save(request: SaveBandRequest): Band {
        logger.info("save band $request")
        return request.mapToBand().let {
            repository.save(it)
        }
    }

    fun update(request: UpdateBandRequest) {
        logger.info("update band $request")
        repository.findById(request.id).orElseThrow()
        repository.updateBandByIdAnd(request.name, request.adressId, request.description, request.id)
    }

    data class UpdateBandRequest(val name: String?, val adressId: Long?, val description: String?, val id: Long)
    data class SaveBandRequest(val name: String, val adressId: Long, val description: String?) {
        fun mapToBand(): Band {
            return Band(name = name, adressId = adressId, description = description)
        }
    }

}