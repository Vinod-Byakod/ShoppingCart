package com.example.Kart;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    static List<Product> products = new CopyOnWriteArrayList<Product>();
    /*static {
        products.add(new Product(100, "Mobile"));
        products.add(new Product(101, "Smart TV"));
        products.add(new Product(102, "Washing Machine"));
        products.add(new Product(103, "Laptop"));
        products.add(new Product(104, "Air Conditioner"));
        products.add(new Product(105, "Refrigerator "));
    }*/
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product addProduct(String name) {
        String productID=UUID.randomUUID().toString();
        Product product =new Product();
        product.setId(productID);
        product.setName(name);
        products.add(product);
        return product;

    }

    @Override
    public String deleteProduct(String id) {
        boolean deleted=false;
        Iterator<Product> iter = products.iterator();
        while (iter.hasNext()) {
            Product product = iter.next();
            if(product.getId().equals(id)){
                products.remove(product);
                deleted=true;
            }

        }
        return deleted ? "Deleted" : "Not found";

    }

    @Override
    public String updateProduct(String id, String name) {

        boolean updated=false;
        Iterator<Product> iter = products.iterator();
        while (iter.hasNext()) {
            Product product = iter.next();
            if(product.getId().equals(id)){
                product.setName(name);
                updated=true;
            }
        }
        return updated ? "Updated successfully" : "Not found";

    }
}
