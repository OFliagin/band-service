package com.fas.miusic.band.bandservice.core.configure

import com.fas.miusic.band.bandservice.infrastructure.datasource.db.BandRepository
import com.fas.miusic.band.bandservice.usecase.DeleteBandUseCase
import com.fas.miusic.band.bandservice.usecase.ExecuteBandUseCase
import com.fas.miusic.band.bandservice.usecase.GetBandUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class UseCaseConfiguration {
    @Autowired
    lateinit var repository : BandRepository

    @Bean
    fun getBandUseCase() : GetBandUseCase {
        return GetBandUseCase(repository)
    }

    @Bean
    fun executeBandUseCase() : ExecuteBandUseCase {
        return ExecuteBandUseCase(repository)
    }

    @Bean
    fun deleteBandUseCase() : DeleteBandUseCase {
        return DeleteBandUseCase(repository)
    }
}