package com.cursor.springdata.service;

import com.cursor.springdata.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product create(Product product);

    Product update(Product product);

    List<Product> getAll();

    Product getById(Long id);

    void delete(Long id);

    List<Product> findProductsByFinalYearOfAppointment(int finalYearOfAppointment);

    List<Product> findProductByPriceLessThan();

    List<Product> findProductByYearOfManufactureAndFinalYearOfAppointment(int yearOfManufacture, int finalYearOfAppointment);
}
