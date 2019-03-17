package com.taxathon.taxengine.config;

import com.taxathon.taxengine.domain.config.DomainConfig;
import com.taxathon.taxengine.jpa.config.JpaAdapterConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JpaAdapterConfig.class, DomainConfig.class})
public class BootstrapConfig {

}
