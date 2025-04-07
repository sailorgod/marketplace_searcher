package com.project.MarketplaceSearcher.services;

import com.project.MarketplaceSearcher.dto.ProductResults;
import org.springframework.stereotype.Service;

@Service
public interface SearchProductsService {
    public ProductResults getProductResults(String query, String category);
}
