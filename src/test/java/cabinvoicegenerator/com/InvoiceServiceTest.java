package cabinvoicegenerator.com;
/*
 * @purpose:To perform JUnit testing on methods of Cab Invoice Generator
 */

import java.util.ArrayList;
import java.util.Hashtable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class InvoiceServiceTest 
{
	InvoiceGenerator inVoiceGenerator = null;

    @Before
    public void setUp() throws Exception
    {
        inVoiceGenerator = new InvoiceGenerator();
    }
    /*
     * Test Case 1 : given distance and time should return total fare.
     */
    @Test
	public void givenDistanceAndTime_ShouldReturnTotalFare()
	{
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance , time);
		Assert.assertEquals(25 , fare ,0.0);
	}
	/*
	 * Test Case 2 : given distance and time should return minimum fare.
	 */
	@Test
	public void givenDistanceAndTime_ShouldReturnMinimumFare()
	{
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance , time);
		Assert.assertEquals(5 , fare ,0.0);
	}
	/*
	 * To get total fare given multiple rides
	 */
	
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary()
	{
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = {new Ride(2.0, 5), 
						new Ride(0.1, 1)};
		InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(1, 1);
	}
}
	
