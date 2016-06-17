package com.mtraina.springapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.mtraina.springapp.domain.Product;

public class ProductDaoImpl extends SimpleJdbcDaoSupport implements ProductDao {

	public List<Product> findProducts() {
		logger.info("Getting products!");
		List<Product> products = getSimpleJdbcTemplate().query(
                "select id, description, price from products", 
                new ProductMapper());
        return products;
	}
	
	public void saveProduct(Product product) {
		int count = getSimpleJdbcTemplate().update(
	            "update products set description = :description, price = :price where id = :id",
	            new MapSqlParameterSource().addValue("description", product.getDescription())
	                .addValue("price", product.getPrice())
	                .addValue("id", product.getId()));
		logger.info("Rows affected: " + count);
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
