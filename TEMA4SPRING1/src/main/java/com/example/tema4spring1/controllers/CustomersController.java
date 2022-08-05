package com.example.tema4spring1.controllers;

import com.example.tema4spring1.Repository.CustomersRepository;
import com.example.tema4spring1.model.Customers;
import com.example.tema4spring1.service.CustomersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CustomersController {

    private final CustomersService customersService;

    @GetMapping("customer")
    public String getCustomers(Model model){
        model.addAttribute("customer", customersService.getAllCustomers());
        return "customer";
    }

    @GetMapping("customers/{id}")
    public String getCustomerById(Model model, @PathVariable("id") Integer id){
        model.addAttribute("getById",customersService.getCustomerById(id));
        return "customers";}
    @Autowired
    private final CustomersService service;
    @RequestMapping("/keyword")

    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Customers> listCustomers = customersService.listAll(keyword);
        model.addAttribute("listCustomers", listCustomers);
        model.addAttribute("keyword", keyword);

        return "customers";}
//        @GetMapping("customers/{name}")
//        public String getAllCustomersByName(Model model, @PathVariable("name") String name){
//            model.addAttribute("getByName",customersService.getAllCustomersByName(name));
//            return "customers";}
//    }
//    @GetMapping("customers/{name}")
//    public String getCustomerByName(Model model, @PathVariable("name") String name){
//        model.addAttribute("getByName",customersService.getCustomerByName(name));
//        return "customers";
    }




