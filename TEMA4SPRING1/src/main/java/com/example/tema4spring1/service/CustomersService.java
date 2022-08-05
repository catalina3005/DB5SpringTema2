package com.example.tema4spring1.service;
import com.example.tema4spring1.Repository.CustomersRepository;
import com.example.tema4spring1.model.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
//@Service
//public class CustomersService {
//    @Autowired
//    private CustomersRepository repo;
//
//    public List<Customers> listAll(String keyword) {
//        if (keyword != null) {
//            return repo.search(keyword);
//        }
//        return repo.findAll();
//    }

@Service
public class CustomersService {

    @Autowired
    CustomersRepository customersRepository;

    List<Customers> list = new ArrayList<>();

    //Get all customers
    public List<Customers> getAllCustomers() {
        return (List<Customers>) customersRepository.findAll();
    }
    public Customers getCustomerById(Integer id) {

        return customersRepository.findById(id).get();
    }
   public Customers getAllCustomersByName(String name) {

        return customersRepository.findByName(name).get();    }

    //Insert customers
    public Customers saveCustomers(Customers customer) {
        return customersRepository.save(customer);
    }
    //all customers
    private CustomersRepository repo;

    public List<Customers> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return (List<Customers>) repo.findAll();
    }
    //Update customers
    public Customers updateCustomers(Customers customer, Integer id) {
        Customers c = customersRepository.findById(id).get();

       if (Objects.nonNull(customer.getName()) && !"".equalsIgnoreCase(customer.getName())) {
            c.setName((customer.getName()));
        }
       if (Objects.nonNull(customer.getEmail()) && !"".equalsIgnoreCase(customer.getEmail())) {
            c.setEmail((customer.getEmail()));
        }
        return customersRepository.save(c);

    }

    //Delete customers
   public void deleteCustomersById(Integer id) {
        customersRepository.deleteById(id);
    }

    public Customers findByName(String name) {

            return customersRepository.findByName(name).get();
        }

}