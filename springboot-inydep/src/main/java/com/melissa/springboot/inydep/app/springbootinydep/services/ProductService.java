package com.melissa.springboot.inydep.app.springbootinydep.services;
import java.util.List;
import com.melissa.springboot.inydep.app.springbootinydep.models.Product;

public interface ProductService {
  
  List<Product> findALL();
  
  Product findById(Long id);
}
