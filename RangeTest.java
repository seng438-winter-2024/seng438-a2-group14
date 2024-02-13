package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exRange;
    private Range exRange2;
    private Range exRange3;
    private Range exRange4;
    
    @BeforeClass 
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception { 
    	exRange = new Range(-1, 1);
    	exRange2 = new Range(0, 10);
    	exRange3 = new Range(1, 10);
    	exRange4 = new Range(-10, 0);
    }

    //Test getCentralValue() function ******************************************************************************************
    @Test     
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exRange.getCentralValue(), .000000001d);
    }
    @Test
    public void centralValueShouldBePositive() {
    	assertEquals("The central value of 0 and 10 should be 5",
    	        5, exRange2.getCentralValue(), .000000001d);
    }
    @Test
    public void centralValueShouldBeDecimal() {
    	assertEquals("The central value of 1 and 10 should be 5.5",
    	       5.5 , exRange3.getCentralValue(), .000000001d);
    }
    @Test
    public void centralValueShouldBeNegative() {
    	assertEquals("The central value of 0 and 10 should be -5",
    	        -5, exRange4.getCentralValue(), .000000001d);
    }

    //Testing contains() function *******************************************************************************
    @Test
    public void containsEdgeValue() {assertTrue(exRange.contains(-1)); }
    @Test
    public void containsZeroValue() {assertTrue(exRange.contains(0)); }
    @Test
    public void containsNegariveValue() {assertTrue(exRange4.contains(-6)); }
    @Test
    public void containsPositiveValue() {assertTrue(exRange2.contains(5)); }
    @Test
    public void doesntContainAboveUpperBound() {assertFalse(exRange2.contains(11));	}
    @Test
    public void doesntContainBelowLowerBound() {assertFalse(exRange2.contains(-2)); }

    //Testing constrain() Function *******************************************************************************    
    
    /*double constrain(double value)
     * Returns the value within the range that is closest to the specified value.
	- J1. Data contains positive value, valid.
	- J2. Data contains negative value, valid.
	- J3. Data contains zero value, valid.
	- J4. Value is within AUB of Range, valid.
	- J5. Value is within BLB of Range, valid 
	*/    
    
    @Test
    public void constrainShouldBePositiveValue() {
    	assertEquals("The constrain value of 5.4 in range 0 to 10 should be 5.4",
    	        5.4, exRange2.constrain(5.4), .000000001d);
    }
    
    @Test
    public void constrainShouldBeNegativeValue() {
    	assertEquals("The constrain value of -5.4 in range -10 to 0 should be -5.4",
    	        -5.4, exRange4.constrain(-5.4), .000000001d);
    }
    
    @Test
    public void constrainShouldBeZero() {
    	assertEquals("The constrain value of 0 in range 0 to 10 should be 0",
    	        0, exRange2.constrain(0), .000000001d);
    }
    
    @Test
    public void constrainShouldBeUpperBoundaryValue() {
    	assertEquals("The constrain value of 100 in range 0 to 10 should be 10",
    	        10, exRange2.constrain(100), .000000001d);
    }
    @Test
    public void constrainShouldBeLowerBoundaryValue() {
    	assertEquals("The constrain value of -50 in range 0 to 10 should be 0",
    	        0, exRange2.constrain(-50), .000000001d);
    }
    
    //Testing double getUpperBound() Function *******************************************************************************
    /*double getUpperBound():
	- G1. Data contains positive value, valid
	- G2. Data contains negative value, valid
	- G3. Data contains zero value, valid
	*/
    
    
    //Testing Constrain Function *******************************************************************************
    /*
	double getLowerBound():
	Returns the lower bound for the range.
	- H1. Data contains positive value, valid
	- H2. Data contains negative value, valid
	- H3. Data contains zero value, valid
	*/
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
