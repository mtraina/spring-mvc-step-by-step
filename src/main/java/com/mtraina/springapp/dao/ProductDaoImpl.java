package com.mtraina.springapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.mtraina.springapp.domain.Product;

public class ProductDaoImpl extends SimpleJdbcDaoSupport implements ProductDao {

	public List<Product> findProducts() {
		List<Product> products = getSimpleJdbcTemplate().query(
                "select id, description, price from products", 
                new ProductMapper());
        return products;
	}
	
	private static class ProductMapper implements ParameterizedRowMapper<Product> {

        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product prod = new Product();
            prod.setId(rs.getInt("id"));
            prod.setDescription(rs.getString("description"));
            prod.setPrice(new Double(rs.getDouble("price")));
            return prod;
        }
    }

}
