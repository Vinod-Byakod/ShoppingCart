package com.example.Kart;

import java.util.List;
import java.util.Set;

public interface IProductService {
    List<Product> findAll();
    Product addProduct(String name);
    String deleteProduct(String id);
    String updateProduct(String id, String name);

}
