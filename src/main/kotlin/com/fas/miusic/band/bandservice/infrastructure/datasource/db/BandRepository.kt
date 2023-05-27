package com.fas.miusic.band.bandservice.infrastructure.datasource.db

import com.fas.miusic.band.bandservice.core.model.Band
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BandRepository : CrudRepository<Band, Long> {

}