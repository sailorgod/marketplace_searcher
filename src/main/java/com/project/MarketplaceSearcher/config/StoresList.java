package com.project.MarketplaceSearcher.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "settings")
@PropertySource("application.yaml")
public class StoresList {
    private List<Store> stores;
}
