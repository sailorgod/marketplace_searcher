package com.project.MarketplaceSearcher.services;

import com.project.MarketplaceSearcher.config.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoresService {
    List<Store> getStoresByCategory(String category);
    List<Store> getAllStores();
}
