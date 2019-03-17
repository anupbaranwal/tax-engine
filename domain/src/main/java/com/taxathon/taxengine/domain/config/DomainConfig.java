package com.taxathon.taxengine.domain.config;

import com.taxathon.taxengine.domain.FeeCalculator;
import com.taxathon.taxengine.domain.UAEFeeCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

    @Bean
    public FeeCalculator uaeFeeCalculator() {
        return new UAEFeeCalculator();
    }
}
