package com.cursor.springdata.repository;

import com.cursor.springdata.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findProductsByFinalYearOfAppointmentLessThan(int finalYearOfAppointment);

    List<Product> findProductByPriceLessThan(int price);

    @Query("SELECT y FROM Product y WHERE y.yearOfManufacture =:yearOfManufacture AND y.finalYearOfAppointment =:finalYearOfAppointment")
    List<Product> findProductByYearOfManufactureAndFinalYearOfAppointment(int yearOfManufacture, int finalYearOfAppointment);
}