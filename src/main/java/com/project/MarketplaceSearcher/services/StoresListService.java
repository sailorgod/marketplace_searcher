package com.project.MarketplaceSearcher.services;

import com.project.MarketplaceSearcher.dto.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoresListService {
    List<Store> getSiteList(String category);
}
