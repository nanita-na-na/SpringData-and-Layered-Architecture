package com.cursor.springdata.service.impl;

import com.cursor.springdata.model.Product;
import com.cursor.springdata.repository.ProductRepository;
import com.cursor.springdata.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findProductsByFinalYearOfAppointment(int finalYearOfAppointment) {
        return productRepository.findProductsByFinalYearOfAppointmentLessThan(finalYearOfAppointment);
    }

    @Override
    public List<Product> findProductByPriceLessThan() {
        return productRepository.findProductByPriceLessThan(50);
    }

    @Override
    public List<Product> findProductByYearOfManufactureAndFinalYearOfAppointment(int yearOfManufacture, int finalYearOfAppointment) {
        return productRepository.findProductByYearOfManufactureAndFinalYearOfAppointment(yearOfManufacture, finalYearOfAppointment);
    }
}