package com.melissa.springboot.app.springbootcrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.melissa.springboot.app.springbootcrud.entities.Product;
import com.melissa.springboot.app.springbootcrud.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

  @Autowired
  private ProductRepository repository;

  @Override
  @Transactional(readOnly = true)
  public List<Product> findAll() {    
    return (List<Product>) repository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Product> findById(Long id) {
    
    return repository.findById(id);
  }

  
  @Transactional
  @Override  
  public Product save(Product product) {    
    return repository.save(product);
  }

  @Transactional
  @Override
  public Optional <Product> update(Long id, Product product) {
    Optional <Product> productOptional= repository.findById(id) ;
    if(productOptional.isPresent()){
      Product productDb= productOptional.orElseThrow();
      productDb.setName(product.getName());
      productDb.setDescription(product.getDescription());
      productDb.setPrice(product.getPrice());
      return Optional.of(repository.save(productDb));
    }
    return productOptional;
  
  }

  @Transactional
  @Override
  public Optional <Product> delete(Long id ) { 
    Optional <Product> productOptional= repository.findById(id) ;
    productOptional.ifPresent(productDb->{
      repository.delete(productDb);
    });
    return productOptional;
  }

 
  
}
