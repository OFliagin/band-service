package com.fas.miusic.band.bandservice.core.configure

import com.fas.miusic.band.bandservice.infrastructure.datasource.db.BandRepository
import com.fas.miusic.band.bandservice.usecase.GetBandUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class UseCaseConfiguration {



    @Bean
    fun getBandUseCase(repository : BandRepository) : GetBandUseCase {
        return GetBandUseCase(repository)
    }
}