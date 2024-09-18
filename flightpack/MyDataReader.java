package flightpack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyDataReader {
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH");

	public static LocalDateTime dateConvert(String dateTimeString) {
		return LocalDateTime.parse(dateTimeString, formatter);
	}

	/**
	 * @param inputLine the Flight object values in string format
	 * @return inputLine converted into a new Flight object
	 */
	private static Flight lineToReport(String inputLine) {
		String[] items = inputLine.split(",");
		String originName = items[0];
		String originCity = items[1];
		String originState = items[2];

		Airport origin = new Airport(originName, originCity, originState);
		Airport destination = new Airport(items[3], items[4], items[5]);
		int passenger = Integer.parseInt(items[6]);
		int seats = Integer.parseInt(items[7]);
		int distance = Integer.parseInt(items[8]);
		LocalDateTime flightDate = dateConvert(items[9]);
		return new Flight(origin, destination, seats, distance, passenger, flightDate);
	}

	/**
	 * 
	 * @param filePath the multiple Flight objects in string format
	 * @return the filePath converted into an array of Flight objects
	 */
	public static Flight[] readDataFile(String filePath) {
		Flight[] data = new Flight[3000000];
		// Try block to check for exceptions
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			// Declaring a new string
			br.readLine();
			String str;
			int currentIndex = 0;
			// It holds true till there is content in file
			while ((str = br.readLine()) != null) {
				Flight temp = lineToReport(str);
				data[currentIndex] = temp;
				currentIndex++;
			}
		}
		// Catch block to handle the exceptions
		catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
