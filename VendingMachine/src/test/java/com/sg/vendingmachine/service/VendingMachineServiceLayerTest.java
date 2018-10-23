package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoMemImpl;
import com.sg.vendingmachine.dao.VendingMachineDaoPersistenceException;
import com.sg.vendingmachine.dto.Currency;
import com.sg.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author heath
 */
public class VendingMachineServiceLayerTest {

    private VendingMachineServiceLayer service;
    private Currency currency = new Currency();

    public VendingMachineServiceLayerTest() {
        VendingMachineDao dao = new VendingMachineDaoMemImpl();
        service = new VendingMachineServiceLayerImpl(dao);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getInventoryException() throws Exception {
        
        try {
            Inventory invalidName = service.getInventory("A11");
            fail("Invalid Item name");
        } catch (VendingMachineDaoPersistenceException ex){
            //should never get here
        }
    }

    @Test
    public void testReturnChange() throws Exception {
        Inventory inv = service.getInventory("A1");
        BigDecimal userMoney = BigDecimal.valueOf(1.00);
        BigDecimal change = service.returnChange(inv, userMoney);

        BigDecimal expectedChange = BigDecimal.valueOf(0.25);

        assertEquals(change, expectedChange);
    }

    @Test
    public void testReturnChangeException() throws Exception {

        Inventory inv = service.getInventory("A1");
        BigDecimal userMoney = BigDecimal.valueOf(0.50);

        try {
            BigDecimal change = service.returnChange(inv, userMoney);
            fail("Throws the InsuffecientFundsException");
        } catch (InsuffecientFundsException ex) {
        }
    }

    /**
     * Test of calculatedChange method, of class VendingMachineServiceLayer.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCalculatedChange() throws Exception {
        Inventory inv = service.getInventory("A1");
        BigDecimal userMoney = BigDecimal.valueOf(1.00);
        BigDecimal change = service.returnChange(inv, userMoney);
        BigDecimal expectedChange = BigDecimal.valueOf(0.25);
        assertEquals(change, expectedChange);

        Currency calcChange = new Currency();
        calcChange.setUserMoney(change);
        BigDecimal quarters;
        quarters = calcChange.getUserMoney().divide(new BigDecimal("0.25"), 0, RoundingMode.FLOOR);
        calcChange.setQuarters(quarters);

        assertSame(BigDecimal.valueOf(1), calcChange.getQuarters());

    }

}
