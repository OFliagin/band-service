package com.fas.miusic.band.bandservice.usecase

import com.fas.miusic.band.bandservice.core.model.Band
import com.fas.miusic.band.bandservice.infrastructure.datasource.db.BandRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GetBandUseCase {


    @Autowired
    lateinit var repository: BandRepository

    fun getBand(id: Long) : Band {
        var findById = repository.findById(id)
        return findById.orElseThrow()
    }

    fun getAll(): List<Band> {
        return repository.findAll().toList()
    }

}