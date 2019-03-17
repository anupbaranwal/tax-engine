package com.taxathon.taxengine.jpa.config;

import com.taxathon.taxengine.domain.infra.FxRateCalculationRepository;
import com.taxathon.taxengine.jpa.FxRateCalculationAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaAdapterConfig {

    @Bean
    public FxRateCalculationRepository fxRateCalculationAdapter() {
        return new FxRateCalculationAdapter();
    }
}
