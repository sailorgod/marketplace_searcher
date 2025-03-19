package com.project.MarketplaceSearcher.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "settings.stores")
@PropertySource("application.yaml")
public class StoresList {
    private List<StoresConf> storesConfList;
}
