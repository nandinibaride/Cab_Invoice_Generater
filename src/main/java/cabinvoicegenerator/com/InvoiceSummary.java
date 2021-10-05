package cabinvoicegenerator.com;

import java.util.Objects;

public class InvoiceSummary {
	
	private final int numberOfRides;
	private final double totalFare;
	private final double averageFare;

	public InvoiceSummary(int numberOfRides, double totalFare) {
		
		this.numberOfRides = numberOfRides;
		this.totalFare = totalFare;
		this.averageFare = this.totalFare/this.numberOfRides;
	}

	@Override
	public int hashCode() {
		return Objects.hash(averageFare, numberOfRides, totalFare);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceSummary other = (InvoiceSummary) obj;
		return Double.doubleToLongBits(averageFare) == Double.doubleToLongBits(other.averageFare)
				&& numberOfRides == other.numberOfRides
				&& Double.doubleToLongBits(totalFare) == Double.doubleToLongBits(other.totalFare);
	}

}