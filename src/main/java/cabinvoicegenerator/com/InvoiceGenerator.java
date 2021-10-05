package cabinvoicegenerator.com;

import java.util.Hashtable;
import java.util.Scanner;

public class InvoiceGenerator {
	Scanner scanner = new Scanner(System.in);
     /*
      * @purpose: To calculate total fare for normal and premium rides.
      */
	public double calculateFare(double distance, int time) {
		double MINIMUM_COST_PER_KILOMETER = 0;
		int COST_PER_TIME = 0;
		int MINIMUM_FARE = 0;

		System.out.println("\nPress 1 - Normal Rides\nPress 2 - Premium Rides");
		int choice = scanner.nextInt();
		if (choice == 1)
		{	
			COST_PER_TIME = 1;
			MINIMUM_COST_PER_KILOMETER = 10;
			MINIMUM_FARE = 5;
         } 
		else if (choice == 2)
		{
            COST_PER_TIME = 2;
			MINIMUM_COST_PER_KILOMETER = 15;
			MINIMUM_FARE = 20;
         } 
		else
		{
		   System.out.println("Invalid Input !!! ");
        }

		double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
		if (totalFare < MINIMUM_FARE) {
			return MINIMUM_FARE;
		} else {
			return totalFare;
		}
	}

	public InvoiceSummary calculateFare(Ride[] rides)
	{
		double totalFare = 0;
		for (Ride ride : rides)
		{
			totalFare = totalFare + this.calculateFare(ride.distance, ride.time);
	    }
		System.out.println(totalFare);
		return new InvoiceSummary(rides.length, totalFare);
	}

	public InvoiceSummary inVoiceService(Hashtable<Integer, Ride[]> listOfRides)
	{
		Ride[] rides = listOfRides.get(1);
		InvoiceSummary inVoiceSummary = calculateFare(rides);
		return inVoiceSummary;
	}
}
