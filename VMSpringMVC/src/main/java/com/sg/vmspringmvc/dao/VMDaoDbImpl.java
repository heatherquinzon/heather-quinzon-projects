/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.dao;

import com.sg.vmspringmvc.dto.Inventory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author heath
 */
@Repository
public class VMDaoDbImpl implements VMDao{
    
    private static final String SQL_GET_INVENTORY =
            "select * from inventory where id = ?";
    private static final String SQL_GET_ALL_INVENTORY =
            "select * from inventory";
    private static final String SQL_UPDATE_INVENTORY_AMOUNT =
            "update vandingMachine "
            + "set inventoryAmount = ?"
            + "where id = ?";
    
    @Inject
    private JdbcTemplate jdbc;

    @Override
    public Inventory getInventory(String itemName) throws VendingMachineDaoPersistenceException {
        try {
            return jdbc.queryForObject(SQL_GET_INVENTORY, 
                    new InventoryMapper(), itemName);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Inventory> getAllInventory() throws VendingMachineDaoPersistenceException {
        return jdbc.query(SQL_GET_ALL_INVENTORY, 
                new InventoryMapper());
    }

    @Override
    public int updateInventoryAmount(Inventory item) throws VendingMachineDaoPersistenceException {
        int num = item.getInventoryAmount() - 1;
        
        return jdbc.update(SQL_UPDATE_INVENTORY_AMOUNT, num);
    }
    
    private static final class InventoryMapper implements RowMapper<Inventory> {
        
        public Inventory mapRow(ResultSet rs, int rowNum) throws SQLException {
            Inventory inv = new Inventory();
            inv.setItemName(rs.getString("id"));
            inv.setItemDesc(rs.getString("itemName"));
            inv.setCost(rs.getBigDecimal("cost"));
            inv.setInventoryAmount(rs.getInt("inventoryAmount"));
            return inv;
        }
        
    }
    
    
}
