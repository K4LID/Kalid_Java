package flightpack;

import java.util.ArrayList;
import java.util.Scanner;

public class program1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String file = sc.nextLine();
		MyDataReader mdr = new MyDataReader();
		long start1 = System.currentTimeMillis();
		Flight[] flights = mdr.readDataFile(file);
		long end1 = System.currentTimeMillis();
		System.out.println((end1 - start1) + " milliseconds to read the file");
		MyAnalyzer obj = new MyAnalyzer();
		long start2 = System.currentTimeMillis();
		ArrayList<String> q1 = obj.getAirports(flights, "Maine");
		long end2 = System.currentTimeMillis();
		System.out.println("name of all the airports in the state of Maine: [" + q1.toString() + "]");
		System.out.println((end2 - start2) + " milliseconds for task 4.a");
		long start3 = System.currentTimeMillis();
		int q2 = obj.maxPassengers(flights, "PWM");
		long end3 = System.currentTimeMillis();
		System.out.println("the maximum number of passengers coming to PWM with one flight: " + q1.toString());
		System.out.println((end3 - start3) + " milliseconds for task 4.b");
		long start4 = System.currentTimeMillis();
		double q3 = obj.percentageNoEmptySeats(flights);
		long end4 = System.currentTimeMillis();
		System.out.println("the percentage of the flights with no empty seats: " + q3);
		System.out.println((end4 - start4) + " milliseconds for task 4.c");
		long start5 = System.currentTimeMillis();
		double q4 = obj.avgPassengerFromToState(flights, "PWM", "Florida", 2009);
		long end5 = System.currentTimeMillis();
		System.out.println("the average number of passengers on flights from PWM to FL in 2009: " + q4);
		System.out.println((end5 - start5) + " milliseconds for task 4.d");
		sc.close();
	}
}