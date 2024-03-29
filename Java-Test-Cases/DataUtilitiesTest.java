package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.hamcrest.Matcher;
import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValue;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {
	
	/*
	 * these are values created to mock class creation
	 * 
	 */
	private Mockery mockingContext;
	private Values2D values;
	private KeyedValues keyedValues;

	@Before
	public void setUp() throws Exception {
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
		keyedValues = mockingContext.mock(KeyedValues.class);
	}


	/*
	 * this function tests DataUtilities.calculateColumnTotal()
	 * with NULL for input for values2D.
	 */
     @Test
     public void calculateColumnTotalForNullData() {
        try{
            double result = DataUtilities.calculateColumnTotal(null, 0);
            fail("Expected an InvalidParameterException to be thrown");
            } 
        catch (Exception e) {
            assertEquals(null, e.getMessage());
        }
     }

 	/*
 	 * this function tests DataUtilities.calculateColumnTotal()
 	 * with an empty set of data. Using ECT
 	 */
     @Test
     public void calculateColumnTotalForEmpty() {
         mockingContext.checking(new Expectations() {
             {
                 one(values).getRowCount();
             }
         });
         double result = DataUtilities.calculateColumnTotal(values, 0);
         // verify
         assertEquals(result, 0, .000000001d);
     }
     
     
     
  	/*
  	 * this function tests DataUtilities.calculateColumnTotal()
  	 * by inputting an invalid column value. Using ECT UB
  	 */
 	//TEST FAILED AND SHOWED ERROR DUE TO COMPLICATIONS WITH VALUE2D
 	//Assume that functionality of "invalid row/column number will equate to 0"
 	//was not implemented correctly.
   @Test
   public void calculateColumnTotalForThreeValuesInvalidColoumn() {
       mockingContext.checking(new Expectations() {
           {
          	one(values).getRowCount();
				will(returnValue(3));
				one(values).getValue(0, 0);
				will(returnValue(5));
				one(values).getValue(1, 0);
				will(returnValue(2));
				one(values).getValue(2, 0);
				will(returnValue(3));
           }
       });
       try {
           double result = DataUtilities.calculateColumnTotal(values, -5);
           assertEquals(result, 0, .000000001d);
       }
       catch (Exception e) {
           assertEquals(null, e.getMessage());
       }

      
   }

   
 	/*
 	 * this function tests DataUtilities.calculateColumnTotal()
 	 * with a non-empty column set of three. Using ECT
 	 */ 
     @Test
     public void calculateColumnTotalForThreeValues() {
         mockingContext.checking(new Expectations() {
             {
            	one(values).getRowCount();
  				will(returnValue(3));
  				one(values).getValue(0, 0);
  				will(returnValue(5));
  				one(values).getValue(1, 0);
  				will(returnValue(2));
  				one(values).getValue(2, 0);
  				will(returnValue(3));
             }
         });
         
         double result = DataUtilities.calculateColumnTotal(values, 0);
         assertEquals(result, 10.0, .000000001d);
        
     }
     

  	/*
  	 * this function tests DataUtilities.calculateColumnTotal()
  	 * with a non-empty column set with more than one column. Using ECT
  	 */  
    @Test
  	public void calculateColumnTotalWithTwoColoumnsFirstColoumn() {
     	 mockingContext.checking(new Expectations() {
  			{
  				one(values).getRowCount();
  				will(returnValue(3));
  				one(values).getValue(0, 0);
  				will(returnValue(5));
  				one(values).getValue(1, 0);
  				will(returnValue(2));
  				one(values).getValue(2, 0);
  				will(returnValue(3));
  				one(values).getValue(0, 1);
  				will(returnValue(1));
  				one(values).getValue(1, 1);
  				will(returnValue(4));
  				one(values).getValue(2, 1);
  				will(returnValue(6));
  			}
  		});
     	 
  		double result = DataUtilities.calculateColumnTotal(values, 0);
  		assertEquals(10, result, .000000001d);
  		
  	}

    
  	/*
  	 * this function tests DataUtilities.calculateColumnTotal()
  	 * with a non-empty column set with more than one column. Using ECT
  	 */  
    @Test
 	public void calculateColumnTotalWithTwoColoumnsSecondColoumn() {
    	 mockingContext.checking(new Expectations() {
 			{
 				one(values).getRowCount();
 				will(returnValue(3));
 				one(values).getValue(0, 0);
 				will(returnValue(5));
 				one(values).getValue(1, 0);
 				will(returnValue(2));
 				one(values).getValue(2, 0);
 				will(returnValue(3));
 				one(values).getValue(0, 1);
 				will(returnValue(1));
 				one(values).getValue(1, 1);
 				will(returnValue(4));
 				one(values).getValue(2, 1);
 				will(returnValue(6));
 			}
 		});
    	 
 		double result = DataUtilities.calculateColumnTotal(values, 1);
 		assertEquals(11, result, .000000001d);
 		
 	}
    

	/*
	 * this function tests DataUtilities.calculateRowTotal()
	 * with NULL for input for values2D. Using ECT.
	 */
	@Test
	public void calculateRowTotalTest() {
        try{
            double result = DataUtilities.calculateRowTotal(null, 0);
            fail("Expected an InvalidParameterException to be thrown");
            } 
        catch (Exception e) {
            assertEquals(null, e.getMessage());
        }
	}

	/*
	 * this function tests DataUtilities.calculateRowTotal()
	 * with empty set of values in row. Using ECT.
	 */
	@Test
	public void calculateRowTotalifRowsEmptyTest() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        // verify
        assertEquals(result, 0, .000000001d);
	}
	
	
  	/*
  	 * this function tests DataUtilities.calculateRowTotal()
  	 * by inputting an invalid row value. Using ECT UB
  	 */
	//TEST FAILED AND SHOWED ERROR DUE TO COMPLICATIONS WITH VALUE2D
	//Assume that functionality of "invalid row number will equate to 0"
	//was not implemented correctly.
	@Test
	public void calculateRowTotalifInvalidColumnEnteredLB() {
	    mockingContext.checking(new Expectations() {
	        {
	            allowing(values).getColumnCount();
	            will(returnValue(3));
	            allowing(values).getValue(0, 0);
	            will(returnValue(5));
	            allowing(values).getValue(0, 1);
	            will(returnValue(2));
	            allowing(values).getValue(0, 2);
	            will(returnValue(3));
	        }
	    });
	    
	    double result = DataUtilities.calculateRowTotal(values, -5);
	    
	    // verify
	    assertEquals(result, 0, .000000001d);
	}
	
	
	/*
  	 * this function tests DataUtilities.calculateRowTotal()
  	 * by inputting an invalid row value. Using ECT LB
  	 */
	//TEST FAILED AND SHOWED ERROR DUE TO COMPLICATIONS WITH VALUE2D
	//Assume that functionality of "invalid row number will equate to 0"
	//was not implemented correctly.
	@Test
	public void calculateRowTotalifInvalidColumnEnteredUB() {
	    mockingContext.checking(new Expectations() {
	        {
	            allowing(values).getColumnCount();
	            will(returnValue(3));
	            allowing(values).getValue(0, 0);
	            will(returnValue(5));
	            allowing(values).getValue(0, 1);
	            will(returnValue(2));
	            allowing(values).getValue(0, 2);
	            will(returnValue(3));
	        }
	    });
	    
	    double result = DataUtilities.calculateRowTotal(values, 5);
	    
	    // verify
	    assertEquals(result, 0, .000000001d);
	}
	
  	/*
  	 * this function tests DataUtilities.calculateRowTotal()
  	 * with a non-empty column set with more than one Row. Using ECT
  	 */  
	@Test
	public void calculateRowTotalifColumnOnBoundary() {
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(5));
	            one(values).getValue(0, 1);
	            will(returnValue(1));
	            one(values).getValue(0, 2);
	            will(returnValue(4));
	        }
	    });
			double result = DataUtilities.calculateRowTotal(values, 0);
			// verify
			assertEquals(result, 10, .000000001d);
	}
	
	
  	/*
  	 * this function tests DataUtilities.calculateRowTotal()
  	 * with a non-empty column set with more than one Row. Using ECT
  	 */ 
	@Test
	public void calculateRowTotalifColumnInBoundary() {
   	 mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(3));
				one(values).getValue(0, 0);
				will(returnValue(5));
				one(values).getValue(1, 0);
				will(returnValue(1));
				one(values).getValue(2, 0);
				will(returnValue(4));
				one(values).getValue(0, 1);
				will(returnValue(2));
				one(values).getValue(1, 1);
				will(returnValue(4));
				one(values).getValue(2, 1);
				will(returnValue(8));
			}
		});
   	 
		double result = DataUtilities.calculateColumnTotal(values, 1);
		assertEquals(14, result, .000000001d);
	}


  	/*
  	 * this function tests createNumberArray()
  	 * to see if it throws the correct exception with a NULL argument.
  	 */ 
	@Test
	public void createNumberArrayWNullPointer() {
	    try {
	        Number[] result = createNumberArray(null);
	        fail("Expected InvalidParameterException was not thrown");
	    } catch (InvalidParameterException e) {
	        assertTrue(e instanceof InvalidParameterException);
	    }
	}
	
	
 	/*
  	 * this function tests createNumberArray()
  	 * to see if it throws the correct exception with an invalid argument.
  	 */ 
	@Test
	public void CreateNumberArrayWhenNotEmptyInvalidParamException() {
	    double[] data = {'a','b', 'c'};
	    try {
	        Number[] result = DataUtilities.createNumberArray(data);
	        fail("Expected InvalidParameterException was not thrown");
	    } catch (InvalidParameterException e) {
	        assertTrue(e instanceof InvalidParameterException);
	    }
	}
	
	
 	/*
  	 * this function tests createNumberArray()
  	 * to see if it throws any exception with an valid argument.
  	 */ 
	@Test
	public void CreateNumberArrayWhenNotEmptyValidParamException() {
	    double[] data = {5.0 ,1.0, 4.0};
	    Number[] result = DataUtilities.createNumberArray(data);
	}
	
	
	
 	/*
  	 * this function tests DataUtilities.createNumberArray2Dy()
  	 * to see if it throws the correct exception with a NULL argument.
  	 */
    @Test
    public void createNullNumberArray2D() {
        try {
            double[][] data = null;
            Number[][] result = DataUtilities.createNumberArray2D(data);
            fail("Expected an InvalidParameterException to be thrown");
            
        }
         catch (InvalidParameterException e) {
            assertEquals(null, e.getMessage());
        }
        
    }
    
    
 	/*
  	 * this function tests DataUtilities.createNumberArray2Dy()
  	 * to see if it throws the correct exception with an invalid argument.
  	 */
    @Test
    public void createInvalidNumberArray2D() {
        try {
            double[][] data = { { 1, 3, 6 } };
            Number[][] result = DataUtilities.createNumberArray2D(data);
            fail("Expected an InvalidParameterException to be thrown");
            
        }
         catch (InvalidParameterException e) {
            assertEquals(null, e.getMessage());
        }
        
    }
    
    
 	/*
  	 * this function tests DataUtilities.createNumberArray2Dy()
  	 * to see if the values within the dataset are correct.
  	 */
    @Test
    public void createNumberArray2D() {
        double[][] data = { { 5.0, 1.0, 4.0 }, { 3.0, 2.0, 5.0 } };
        Number[][] result = DataUtilities.createNumberArray2D(data);

        assertEquals(data.length, result.length);

        for (int i = 0; i < data.length - 1; i++) {
            
            assertEquals(data[i].length, result[i].length);

            for (int j = 0; j < data[i].length - 1; j++) {
                assertEquals(data[i][j], result[i][j].doubleValue(), .000000001d);
            }
        }
    }
    
    
 	/*
  	 * this function tests getCumulativePercentages(null)
  	 * to see if it throws the correct exception for the NULL argument
  	 */
    @Test
    public void getCumulativePercentagesInvalidParamException() {
	    try {
	    	getCumulativePercentages(null);
	    } catch (InvalidParameterException e) {
	        assertTrue(e instanceof InvalidParameterException);
	    }
    	
    }
    
    
 	/*
  	 * this function tests getCumulativePercentages(null)
  	 * to see if it gets the correct values for positive values.
  	 */
	@Test
	public void getCumulativePercentagesPositiveNumbers() {
		mockingContext.checking(new Expectations() {
			{
				((Values) allowing(keyedValues)).getItemCount();
				will(returnValue(3));
				allowing(keyedValues).getValue(0);
				will(returnValue(3));
				allowing(keyedValues).getValue(1);
				will(returnValue(4));
				allowing(keyedValues).getValue(2);
				will(returnValue(6));
				allowing(keyedValues).getKey(0);
				will(returnValue(0));
				allowing(keyedValues).getKey(1);
				will(returnValue(1));
				allowing(keyedValues).getKey(2);
				will(returnValue(2));
			}
		});

		KeyedValues results = DataUtilities.getCumulativePercentages(keyedValues);
		
		assertEquals(results.getValue(0), 0.23);
		assertEquals(results.getValue(1), 0.54);
		assertEquals(results.getValue(2), 1.0);

	}
	
 	/*
  	 * this function tests getCumulativePercentages(null)
  	 * to see if it gets the correct values for positive AND negative values.
  	 */
	@Test
	public void getCumulativePercentagesNegativeNumbers() {
		mockingContext.checking(new Expectations() {
			{
				((Values) allowing(keyedValues)).getItemCount();
				will(returnValue(3));
				allowing(keyedValues).getValue(0);
				will(returnValue(-1));
				allowing(keyedValues).getValue(1);
				will(returnValue(4));
				allowing(keyedValues).getValue(2);
				will(returnValue(6));
				allowing(keyedValues).getKey(0);
				will(returnValue(0));
				allowing(keyedValues).getKey(1);
				will(returnValue(1));
				allowing(keyedValues).getKey(2);
				will(returnValue(2));
			}
		});

		KeyedValues results = DataUtilities.getCumulativePercentages(keyedValues);
		
		assertEquals(results.getValue(0), -0.11);
		assertEquals(results.getValue(1), 0.44);
		assertEquals(results.getValue(2), 1.0);

		
	}
	

}
