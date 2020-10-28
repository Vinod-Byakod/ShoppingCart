package com.example.Kart;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    List<Product> products;
    @Autowired
    private IProductService productService;


    @RequestMapping(path = "/product")
    ResponseEntity<Product> getProduct() {
        List<Product> products = productService.findAll();


        StringBuilder listProduct = new StringBuilder();
        listProduct.append("<h2> ID :  Product Name  </h2>");
        for(Product product : products){

            listProduct.append("<h3>"+product.getId() +"  "+product.getName() +"</h3>");

        }
        String html=  "<html>\n" + "<header><title>Welcome</title></header>\n" +

                "<body>\n" + listProduct + "</body>\n" + "</html>";
         return new ResponseEntity(listProduct,HttpStatus.OK);
    }


    @RequestMapping(path = "/insert/{name}")
    ResponseEntity<String> insertProduct(@PathVariable String name) {
        Product product =productService.addProduct(name);
        return new ResponseEntity(product,HttpStatus.OK);
    }

    @RequestMapping(path = "/update/{id}/{name}")
    ResponseEntity<String> updateProduct(@PathVariable String id, @PathVariable String name) {
       String status= productService.updateProduct(id, name);
        return new ResponseEntity(status,HttpStatus.OK);
    }

    @RequestMapping(path = "/delete/{id}")
    ResponseEntity<String> deleteProduct(@PathVariable String id) {
       String status= productService.deleteProduct(id);
        return new ResponseEntity(status,HttpStatus.OK);
    }

}
