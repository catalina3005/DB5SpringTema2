package com.example.tema4spring1.Repository;


import com.example.tema4spring1.model.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
//public interface CustomersRepository extends JpaRepository<Customers, Long> {
//
//    @Query("SELECT c FROM Customers c " +
//            "WHERE c.name LIKE %?1%"
//            )
//    public List<Customers> search(String name);
//}
public interface CustomersRepository extends CrudRepository<Customers, Integer> {
//   Optional <Customers> findById(Integer id);
//    Optional <Customers> findByName(String name);
//
//   List<Customers> findAll();
//   void delete(Customers customer);

    Optional<Customers> findById(Integer id);
   Optional<Customers> findByName(String keyword);
    @Query("SELECT c FROM Customers c " +
            "WHERE c.name LIKE %?1%"
            )
    public List<Customers> search(String keyword);}
//public class CustomersRepository {
//   JdbcTemplate jdbcTemplate;
//   public Customers findByName(String name) {
//       String statement = "SELECT * FROM customers WHERE name = ?";
//      return jdbcTemplate.queryForObject(statement, new CustomerRowMapper(), name);
//   }
