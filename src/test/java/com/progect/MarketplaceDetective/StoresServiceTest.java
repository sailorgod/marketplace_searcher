package com.progect.MarketplaceDetective;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

//TODO Завершить тесты
@SpringBootTest
public class StoresServiceTest {

//    private StoresService storesService;

    @Test
    public void getSitesByCategoryWhenCategoryNameIsDigital() {
//        List<Store> stores = storesService.getSitesByCategory("Техника");
        assertEquals("пук", "пукалка");
    }


//    private StoresList getStores() {
//        StoreConf dns = new StoreConf();
//        StoreConf ozon = new StoreConf();
//        StoreConf yandexMarket = new StoreConf();
//        dns.setName("DNS");
//        dns.setUrl("DNS");
//        ozon.setName("OZON");
//        ozon.setUrl("OZON");
//        yandexMarket.setName("Яндекс Маркет");
//        yandexMarket.setUrl("YANDEX");
//        List<StoreConf> stores = new ArrayList<>();
//        stores.add(dns);
//        stores.add(ozon);
//        stores.add(yandexMarket);
//        StoresList storesList = new StoresList();
//        storesList.setStores(stores);
//        return storesList;
//    }
}
