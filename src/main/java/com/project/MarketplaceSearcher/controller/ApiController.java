package com.project.MarketplaceSearcher.controller;

import com.project.MarketplaceSearcher.dto.Product;
import com.project.MarketplaceSearcher.dto.Store;
import com.project.MarketplaceSearcher.services.StoresListService;
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

        private final StoresListService storesListService;

//        @GetMapping("api/products?category={category}")
//        public ResponseEntity<List<Site>> sitesListRequest(@RequestParam String category) {
//            return ResponseEntity.ok(siteListService.getSiteList(category));
//        }

            @GetMapping("api/stores")
            public ResponseEntity<List<Store>> storeListResponse(@RequestParam String category) {
                return ResponseEntity.ok(storesListService.getSiteList(category));
            }

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
                products.add(product);
                return ResponseEntity.ok(products);
            }

}
