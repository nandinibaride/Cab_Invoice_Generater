	package cabinvoicegenerator.com;

import java.util.Hashtable;

public class InvoiceGenerator
	{
		public static final double MINIMUM_COST_PER_KILOMETER = 10.0;
		public static final int COST_PER_TIME = 1;
		public static final int MINIMUM_FARE = 5;
		
		public double  calculateFare(double distance , int time)
		{
			double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
			if(totalFare < MINIMUM_FARE)
			  {
				return MINIMUM_FARE;
			  }
			else
		      {
				return totalFare;
			  }
		 }
		
		public InvoiceSummary calculateFare(Ride [] rides)
		{
			double totalFare = 0;
			for(Ride ride: rides)
			    {
				 totalFare = totalFare + this.calculateFare(ride.distance , ride.time);
				}
			System.out.println(totalFare);
	        return new InvoiceSummary(rides.length,totalFare);
		}
		
		public InvoiceSummary inVoiceService(Hashtable<Integer, Ride[]> listOfRides){
	        Ride[] rides = listOfRides.get(1);
	        InvoiceSummary inVoiceSummary = calculateFare(rides);
	        return inVoiceSummary;
		}
   }
	 
