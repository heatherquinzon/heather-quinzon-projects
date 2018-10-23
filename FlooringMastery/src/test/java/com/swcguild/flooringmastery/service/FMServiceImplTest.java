/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmastery.service;

import com.swcguild.flooringmastery.dao.FMDao;
import com.swcguild.flooringmastery.dao.FMDaoImpl;
import com.swcguild.flooringmastery.dao.FMDaoPersistenceException;
import com.swcguild.flooringmastery.dao.FMDaoUnlistedDateException;
import com.swcguild.flooringmastery.dto.Orders;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author heath
 */
public class FMServiceImplTest {

    private FMService service;

    public FMServiceImplTest() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        service
                = ctx.getBean("service", FMService.class);
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

//    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//    LocalDate date = LocalDate.parse("06/10/2013", formatter1);
//    String formatted1 = date.format(formatter1);
//    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMddyyyy");
//    String formatted2 = date.format(formatter2);
    /**
     * Test of getAllOrders method, of class FMDaoStubImpl.
     */
    @Test
    public void testGetAllOrders() throws Exception {
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse("06/12/2013", formatter1);
        String formatted1 = date.format(formatter1);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMddyyyy");
        String formatted2 = date.format(formatter2);

        assertEquals(1, service.getAllOrders(date).size());
    }

    /**
     * Test of getOrder method, of class FMDaoStubImpl.
     */
    @Test
    public void testGetOrder() throws Exception {
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse("06/12/2013", formatter1);
        String formatted1 = date.format(formatter1);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMddyyyy");
        String formatted2 = date.format(formatter2);
        Orders ord1 = service.getOrder(date, 1);

        assertNotNull(ord1);
    }

    @Test
    public void testGetInvalidOrder() throws Exception {
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse("06/12/2013", formatter1);
        String formatted1 = date.format(formatter1);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMddyyyy");
        String formatted2 = date.format(formatter2);

        try {
            Orders ord1 = service.getOrder(date, 2);
            fail("The exception was not thrown");
        } catch (FMDaoPersistenceException ex) {
            return;
        }
    }

    @Test
    public void testEditOrder() throws Exception {
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse("06/12/2013", formatter1);
        String formatted1 = date.format(formatter1);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMddyyyy");
        String formatted2 = date.format(formatter2);

        Orders ord = service.getOrder(date, 1);

        ord.setCustomerName("Wise");

        service.editOrder(date, ord);

        assertEquals("Wise", ord.getCustomerName());
    }

    @Test
    public void testEditInvalidOrderNum() throws Exception {
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse("06/12/2013", formatter1);
        String formatted1 = date.format(formatter1);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMddyyyy");
        String formatted2 = date.format(formatter2);

        try {
            Orders ord = service.getOrder(date, 2);
            ord.setCustomerName("Wise");
            service.editOrder(date, ord);
            fail("Expected exception now thrown");
        } catch (FMDaoPersistenceException ex) {
            return;
        }

    }

    /**
     * Test of removeOrder method, of class FMDaoStubImpl.
     */
    @Test
    public void testRemoveOrder() throws Exception {
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse("06/12/2013", formatter1);
        String formatted1 = date.format(formatter1);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMddyyyy");
        String formatted2 = date.format(formatter2);

        //file only has 1 order, only 1 int orderNumber
        try {
            service.removeOrder(date, 2);
            fail("Expected exception not thrown");
        } catch (FMDaoPersistenceException ex) {
            return;
        }
    }

    /**
     * Test of calculations method, of class FMServiceImpl.
     */
    @Test
    public void testCalculations() throws Exception {
        Orders newOrder = new Orders();
        newOrder.setTaxRate(new BigDecimal("6.25"));
        newOrder.setArea(100.00);
        newOrder.setCostPerSquareFoot(new BigDecimal("5.15"));
        newOrder.setLaborCostPerSquareFoot(new BigDecimal("4.75"));

        BigDecimal expectedMC = new BigDecimal("515.00");
        BigDecimal expectedLC = new BigDecimal("475.00");
        BigDecimal expectedTax = new BigDecimal("61.88");
        BigDecimal expectedTotal = new BigDecimal("1051.88");

        newOrder = service.calculations(newOrder);

        assertEquals(expectedMC, newOrder.getMaterialCost());
        assertEquals(expectedLC, newOrder.getLaborCost());
        assertEquals(expectedTax, newOrder.getTax());
        assertEquals(expectedTotal, newOrder.getTotal());

    }

    /**
     * Test of setOrderNum method, of class FMServiceImpl.
     */
    @Test
    public void testSetOrderNum() throws Exception {

        Orders newOrder = new Orders();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse("06/12/2013", formatter1);
        String formatted1 = date.format(formatter1);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMddyyyy");
        String formatted2 = date.format(formatter2);

        List<Orders> ordList = service.getAllOrders(date);

        newOrder = service.setOrderNum(newOrder);

        assertEquals(2, newOrder.getOrderNumber());

    }

}
