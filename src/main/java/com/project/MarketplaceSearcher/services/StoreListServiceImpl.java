package com.project.MarketplaceSearcher.services;

import com.project.MarketplaceSearcher.config.StoresConf;
import com.project.MarketplaceSearcher.config.StoresList;
import com.project.MarketplaceSearcher.dto.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreListServiceImpl implements StoresListService {

    private final StoresList storesList;

    @Override
    public List<Store> getSiteList(String category) {
        List<StoresConf> storesConfList = storesList.getStoresConfList();
        List<Store> stores = new ArrayList<>();
        storesConfList.forEach(s -> {
            s.getCategories().forEach(c -> {
                if(category.equals(c)) {
                    Store store = new Store();
                    stores.add(store);
                }
            });
        });
        return stores;
    }
}
