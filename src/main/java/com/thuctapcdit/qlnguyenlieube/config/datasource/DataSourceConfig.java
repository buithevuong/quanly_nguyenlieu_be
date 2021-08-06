package com.thuctapcdit.qlnguyenlieube.config.datasource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {
	@Primary
    @Bean(name = "musicDataSourceProperties")
    @ConfigurationProperties("database.datasource")
    public DataSourceProperties musicDataSourceProperties() {
        return new DataSourceProperties();
    }


}
