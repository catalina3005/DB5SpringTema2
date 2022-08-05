package com.example.tema4spring1.controllers;

import com.example.tema4spring1.model.Customers;
import com.example.tema4spring1.model.Products;
import com.example.tema4spring1.service.CustomersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("customers")
public class CustomersRestController {
    private final CustomersService customersService;

    @GetMapping
    public List<Customers> getCustomers(){
        return customersService.getAllCustomers();
    }

    @PostMapping
    public Customers saveCustomer(@RequestBody Customers customers){
        return customersService.saveCustomers(customers);
    }
    @GetMapping("/found/{id}")
    public Customers getCustomerById(@PathVariable("id") Integer id) {

        return customersService.getCustomerById(id);
    }
    @GetMapping("/{name}")
    public Customers getCustomerByName(@PathVariable("name") String keyword) {

        return customersService.getAllCustomersByName(keyword);
    }
//    @GetMapping("/name/{name}")
//    public Customers getAllCustomersByName(@PathVariable("name") String name) {
//
//        return customersService.getAllCustomersByName(name);
//    }

//    @ResponseBody
//    @GetMapping("/get/{name}")
//    public Customers getByName(@PathVariable(value = "Name") String name) {
//        return customersService.getCustomerByName(name);
//    }
    @PutMapping
    public Customers updateCustomers(@RequestBody Customers customers){
        return customersService.updateCustomers(customers, customers.getId());
    }

}
