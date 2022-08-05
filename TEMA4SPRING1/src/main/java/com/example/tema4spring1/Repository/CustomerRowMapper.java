package com.example.tema4spring1.Repository;
import com.example.tema4spring1.model.Customers;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customers> {
    @Override
    public Customers mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customers customer = new Customers(rs.getString("email"),
                rs.getString("name"));
        return customer;
    }
}
