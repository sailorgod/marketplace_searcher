package com.project.MarketplaceSearcher.config;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class Store {
    private String url;
    private String name;
    private List<String> categories;
}
