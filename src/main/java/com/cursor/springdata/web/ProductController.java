package com.cursor.springdata.web;

import com.cursor.springdata.model.Product;
import com.cursor.springdata.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/products/")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/product")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @PutMapping("/update")
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    @GetMapping(value = "/product")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @DeleteMapping(value = "/product")
    public void delete(@RequestParam Long id) {
        productService.delete(id);
    }

    @GetMapping(value = "/product/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @GetMapping(value = "/product/final")
    public List<Product> getByFinalYearOfAppointment(@RequestParam int years) {
        return productService.findProductsByFinalYearOfAppointment(years);
    }

    @GetMapping("/cheap")
    public List<Product> getProductLess50() {
        return productService.findProductByPriceLessThan();
    }

    @GetMapping("/findByYears/{first}/{second}")
    public List<Product> findProductByYearOfManufactureAndFinalYearOfAppointment(@PathVariable int first, @PathVariable int second) {
        return productService.findProductByYearOfManufactureAndFinalYearOfAppointment(first, second);
    }
}