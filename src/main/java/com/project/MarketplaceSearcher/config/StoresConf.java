package com.project.MarketplaceSearcher.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ConfigurationProperties("settings.stores")
@PropertySource("application.yaml")
//TODO Исправить класс конфигурации и application.yaml
public class StoresConf {
    private String url;
    private String name;
    private List<String> categories;
}
