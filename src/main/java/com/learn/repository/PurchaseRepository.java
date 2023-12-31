package com.learn.repository;

import com.learn.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PurchaseRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void storePurchase(Purchase purchase){
        String sql = "INSERT INTO purchase(product, price) VALUES(?,?)";

        jdbcTemplate.update(sql,purchase.getProduct(),purchase.getPrice());
    }

    public List<Purchase> findAllPurchases(){
        String sql = "SELECT * FROM purchase";

        RowMapper<Purchase> purchaseRowMapper = (r,i) ->{
            Purchase rowObject = new Purchase();
            rowObject.setId(r.getInt("id"));
            rowObject.setProduct(r.getString("product"));
            rowObject.setPrice(r.getBigDecimal("price"));
            return rowObject;
        };

        return jdbcTemplate.query(sql,purchaseRowMapper);
    }
}
