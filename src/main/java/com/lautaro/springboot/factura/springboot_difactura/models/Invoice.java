package com.lautaro.springboot.factura.springboot_difactura.models;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
//@JsonIgnoreProperties({"advisors", "targetSource"})
public class Invoice {
    
    @Autowired
    private Client client;

    @Value("${invoice.description.office}")
    private String description;

    @Autowired
    @Qualifier("default")
    private List<Item> items;

    public Invoice() {
        System.out.println("Creando componente de la factura");
        System.out.println("Cliente: " + client);
        System.out.println("Items: " + items);
    }

    @PostConstruct
    public void init(){
        System.out.println("Factura creada: " + description);
        client.setName(client.getName().toUpperCase());
        description = description + " del cliente: " + client.getName() + " " + client.getLastname();   
    }


    @PreDestroy
    public void destroy(){
        System.out.println("Factura destruida!");
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal(){
        //int total = 0;
        //for (Item item : items) {
        //    total += item.getImporte();
        //}

        int total = items.stream()
        .map(item -> item.getImporte())
        .reduce(0,(sum,importe) -> sum + importe);
        return total;
    }
}
