package com.lautaro.springboot.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import com.lautaro.springboot.factura.springboot_difactura.models.Item;
import com.lautaro.springboot.factura.springboot_difactura.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    //@Primary
    @Bean
    List<Item> itemsInvoice() {
        Product p1 = new Product("Camara Sony", 800);
        Product p2 = new Product("Bicicleta Bianchi 26", 1200);
        return Arrays.asList(new Item(p1, 2), new Item(p2, 4));    
    }

    @Bean("default")
    List<Item> itemsInvoiceOffice() {
        Product p1 = new Product("Yerbero", 800);
        Product p2 = new Product("Television", 1200);
        Product p3 = new Product("Parlante", 1500);
        Product p4 = new Product("Termo", 1900);
        return Arrays.asList(new Item(p1, 2), new Item(p2, 4), new Item(p3, 3), new Item(p4, 1));    
    }
}
