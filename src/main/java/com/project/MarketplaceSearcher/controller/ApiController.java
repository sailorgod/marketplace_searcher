package com.project.MarketplaceSearcher.controller;

import com.project.MarketplaceSearcher.config.Store;
import com.project.MarketplaceSearcher.dto.Product;
import com.project.MarketplaceSearcher.services.StoresService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ApiController {

    private final StoresService storesService;

    @GetMapping("api/stores")
    public ResponseEntity<List<Store>> getStoresByCategory(@RequestParam String category) {
        return ResponseEntity.ok(storesService.getStoresByCategory(category));
    }

    @GetMapping("api/all_stores")
    public ResponseEntity<List<Store>> getAllStores(){
        return ResponseEntity.ok(storesService.getAllStores());
    }

    //TODO Заменить хардкод на сервис с поиском
    @GetMapping("api/products")
    public ResponseEntity<List<Product>> getProducts(@RequestParam String category,
                                                     @RequestParam String query) {
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setLink("1");
        product.setName("Product");
        product.setImage(0);
        product.setPrice(1000);
        product.setDiscountPrice(990);
        for (int i = 0; i < 10; i++) {
            products.add(product);
        }
        return ResponseEntity.ok(products);
    }

    //TODO Заменить хардкод на сервис популярных товаров
    @GetMapping("api/popular")
    public ResponseEntity<List<Product>> popularProductsToday() {
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setLink("1");
        product.setName("Product");
        product.setImage(0);
        product.setPrice(1000);
        product.setDiscountPrice(990);
        for (int i = 0; i < 10; i++) {
            products.add(product);
        }
        return ResponseEntity.ok(products);
    }

}
