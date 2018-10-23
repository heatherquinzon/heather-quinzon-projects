
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author heath
 */
public class VendingMachineDaoTest {
    
    private VendingMachineDao dao = new VendingMachineDaoMemImpl();
    
    public VendingMachineDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInventory method, of class VendingMachineDao.
     */
    @Test
    public void testGetInventory() throws Exception {
        Inventory inv = new Inventory();
        inv.setItemName("A1");
        inv.setItemDesc("Tears");
        inv.setCost(BigDecimal.valueOf(0.75));
        inv.setInventoryAmount(20);
        
        Inventory fromDao = dao.getInventory("A1");
        
        assertEquals(fromDao.getItemName(), inv.getItemName());
        assertEquals(fromDao.getItemDesc(), inv.getItemDesc());
        //assertEquals(fromDao.getInventoryAmount(), inv.getInventoryAmount());
        assertEquals(fromDao.getCost(), inv.getCost());
       
    }
    
    @Test
    public void testImproperInvNames() throws Exception {
        Inventory fromDao1 = dao.getInventory("A6");
        assertNull(fromDao1);
        
        Inventory fromDao2 = dao.getInventory("");
        assertNull(fromDao2);
        
        Inventory fromDao3 = dao.getInventory("a2");
        assertNull(fromDao3);
    }

    /**
     * Test of getAllInventory method, of class VendingMachineDao.
     */
    @Test
    public void testGetAllInventory() throws Exception {
        List<Inventory> allInventory = dao.getAllInventory();
        assertNotNull(allInventory);
    }

    /**
     * Test of updateInventoryAmount method, of class VendingMachineDao.
     */
    @Test
    public void testUpdateInventoryAmountSuccess() throws Exception {
        Inventory inv = dao.getInventory("A1");
        int removedVendItem = dao.updateInventoryAmount(inv);
        
        assertEquals(inv.getInventoryAmount(), removedVendItem);
    }
    
}
