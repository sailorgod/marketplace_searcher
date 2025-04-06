package com.project.MarketplaceSearcher.services;

import com.project.MarketplaceSearcher.config.Store;
import com.project.MarketplaceSearcher.config.StoresList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoresServiceImpl implements StoresService {

    private final StoresList storesList;
    @Override
    public List<Store> getStoresByCategory(String category) {
        if(category.equals("all")){
            return getAllStores();
        }
        List<Store> stores = storesList.getStores();
        List<Store> storesByCategory = new ArrayList<>();
        stores.forEach(s -> {
            s.getCategories().forEach(c -> {
                if(category.equals(c)) {
                    storesByCategory.add(s);
                }
            });
        });
        return storesByCategory;
    }

    @Override
    public List<Store> getAllStores() {
        return storesList.getStores();
    }
}
