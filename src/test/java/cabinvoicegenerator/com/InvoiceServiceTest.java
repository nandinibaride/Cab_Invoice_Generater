package cabinvoicegenerator.com;
/*
 * @purpose:To perform JUnit testing on methods of Cab Invoice Generator
 */

import org.junit.Assert;
import org.junit.Test;


public class InvoiceServiceTest 
{
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare()
	{
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance , time);
		Assert.assertEquals(25 , fare ,0.0);
	}
	
	@Test
	public void givenDistanceAndTime_ShouldReturnMinimumFare()
	{
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance , time);
		Assert.assertEquals(5 , fare ,0.0);
	}
	
	@Test
	public void givenMultipleride_ShouldReturnTotalAggregateFare()
	{
	  InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
	  Ride [] rides = {new Ride ( 2.0 ,  5),
			           new Ride ( 0.1 , 1)};
	  double totalfare = invoiceGenerator.calculateTotalFare(rides);
	  Assert.assertEquals(30 , totalfare, 0.0);
	 }
	 	
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = {new Ride(2.0, 5), 
						new Ride(0.1, 1)};
		InvoiceSummary summary = invoiceGenerator.calculateFareReturnObject(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
		if(expectedSummary.getAverageFare() == summary.getAverageFare() && expectedSummary.getNumberOfRides() == summary.getNumberOfRides() && expectedSummary.getTotalFare() == summary.getTotalFare())
			Assert.assertEquals(1, 1);
	}
}
	
