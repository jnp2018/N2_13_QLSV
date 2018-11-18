/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author quy`
 */
public class CrunchifyIsSocketAliveUtilityTest {
    
    public CrunchifyIsSocketAliveUtilityTest() {
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

    /**
     * Test of main method, of class CrunchifyIsSocketAliveUtility.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CrunchifyIsSocketAliveUtility instance = new CrunchifyIsSocketAliveUtility();
        instance.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isSocketAliveUitlitybyCrunchify method, of class CrunchifyIsSocketAliveUtility.
     */
    @Test
    public void testIsSocketAliveUitlitybyCrunchify() {
        System.out.println("isSocketAliveUitlitybyCrunchify");
        String hostName = "";
        int port = 0;
        CrunchifyIsSocketAliveUtility instance = new CrunchifyIsSocketAliveUtility();
        boolean expResult = false;
        boolean result = instance.isSocketAliveUitlitybyCrunchify(hostName, port);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
