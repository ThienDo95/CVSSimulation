package v1;
import java.util.concurrent.*;
import java.io.*;

public class Driver
{
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args)  throws IOException
	{
		int i;
		
		double dHat = 0;
		double q = 0;
		double qHat = 0;
		double uHat = 0;
		double integralB = 0;
		double Tn = 0;
		final int queueLimit = 10;
				
		LinkedBlockingQueue<Customer> queue = new LinkedBlockingQueue<Customer>(queueLimit);
		
		do
		{
			System.out.println("\n"+"Application's Options: ");
			System.out.println("                       ");
			System.out.println("1. Insert number of customer");
			System.out.println("2. Print info of customer: ");
			System.out.println("3. Print info of single queue: ");
			System.out.println("4. Exit Program");
			System.out.println("                       ");
			System.out.println("Choose your option: " + "\n");
			String input = stdin.readLine().trim();
			i = Integer.parseInt(input);
			
			if (i > 0 && i < 5)
			{
				switch(i)
				{
					case 1:
						System.out.println("Enter number of customer you have in line: ");
						String number = stdin.readLine().trim();
						int n = Integer.parseInt(number);
					
						for(int c = 1; c <= n; c++)
						{
							Customer customer = new Customer(c);
							queue.add(customer);
						}
						
					break;
					case 2:
						
						for(Customer customers: queue)
						{
							customers.toString();
						}
						
						break;
					case 3:
						double sumOfArrivalTime = 0;
						double sumOfStartTime = 0;
						double sumOfEndTime = 0;
						double sumOfDepart = 0;
						
						int sumOfP = 0;
						//Get sum of everything(time) of customers inside a queue
						for(Customer customers: queue)
						{
							sumOfArrivalTime += customers.getArrivalTime();
							sumOfStartTime += customers.getStartTime();
							sumOfEndTime += customers.getEndTime();
							sumOfDepart += customers.getDeparture();
							sumOfP += customers.getP();
						}
						
						double dTemp = sumOfEndTime + sumOfStartTime;
						dHat = dTemp / queueLimit;
						System.out.println(dHat);
						
						double qTemp = sumOfEndTime + sumOfP;
						qHat = qTemp;
						System.out.println(qHat);
						
						Tn = sumOfDepart + sumOfStartTime + sumOfEndTime - sumOfArrivalTime;
						System.out.println(Tn);
						
						integralB = sumOfDepart;
						System.out.println(integralB);
						
						uHat = (Tn - integralB)/Tn;
						System.out.println(uHat);
						break;
					case 4:
						System.out.println("Bye");
						break;
				}
			}
		}while(i < 4 || i > 4);
	}
}