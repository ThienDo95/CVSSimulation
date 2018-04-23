package v1;
import java.util.*;
public class Customer
{
	private int orderOfCustomer;
	private double arrivalTime;
	private double startTime;
	private double endTime;
	private double departureTime;
	private int p;
	
	
	public Customer ()
	{
		
	}
	
	public Customer(int orderOfCustomer)
	{
		super();
		this.orderOfCustomer = orderOfCustomer;
		
		Random arrival = new Random();
		arrivalTime = 0.5 + arrival.nextDouble() * 4.0;
		
		Random start = new Random();
		startTime = 12 + start.nextDouble() * 78;
		
		Random end = new Random();
		endTime = 0.1 + end.nextDouble() * 9.9;
		
		Random depart = new Random();
		departureTime = 1 + depart.nextDouble() * 4;
		
		Random pRand = new Random();
		p = pRand.nextInt() % 5;
	}

	public int getorderOfCustomer()
	{
	
		return orderOfCustomer;
	}
	
	public double getArrivalTime()
	{
	
		return arrivalTime;
	}
	
	public double getStartTime()
	{
	
		return startTime;
	}

	public double getEndTime()
	{
	
		return endTime;
	}
	
	public double getDeparture()
	{
	
		return departureTime;
	}
	
	public int getP()
	{
		return p;
	}
	
	public String toString()
	{
		return "Customer: c" + getorderOfCustomer()  + "\n" +
				 "Arrival Time: " + getArrivalTime() + "\n" +
					"Start Time: " + getStartTime() + "\n" +
						"End Time: " + getEndTime() + "\n" +
							"Depature Time" + getDeparture() + "\n";
	}
}
