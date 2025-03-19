package com.project.MarketplaceSearcher.dto;

import lombok.Data;

@Data
public class Product {

    private String name;
    private String link;
    //TODO Заменить на файл
    private int image;
    private int price;
    private int discountPrice;

}
