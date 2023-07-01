package com.fas.miusic.band.bandservice.infrastructure.datasource.db

import com.fas.miusic.band.bandservice.core.model.Band
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface BandRepository : CrudRepository<Band, Long> {


    @Modifying
    @Query("update Band b" +
            " set b.name = :name, b.adressId = :adressId, b.description = :description  " +
            "where b.id = :id")
    fun updateBandByIdAnd(@Param("name") name: String?,
                          @Param("adressId") adressId: Long?,
                          @Param("description") description: String?
                          , @Param("id") id: Long) : Int

    @Modifying
    @Query("update Band b" +
            " set b.deleted = true " +
            "where b.id = :id")
    fun delete(@Param("id") id: Long): Int

}