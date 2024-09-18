package flightpack;

import java.util.ArrayList;

public class MyAnalyzer {
	/**
	 * @param flights
	 * @param state
	 * @return every unique airport name in the state given
	 */
	public static ArrayList<String> getAirports(Flight[] flights, String state) {
		ArrayList<String> names = new ArrayList<>();
		for (int i = 0; i < flights.length; i++) {
			if (flights[i].getOrigin().getState().equals(state) && !names.contains(flights[i].getOrigin().getName())) {
				names.add(flights[i].getOrigin().getName());
			}
		}
		return names;
	}

	/**
	 * @param flights
	 * @param airport
	 * @return the maximum amount of passengers a flight carried from the given
	 *         airport
	 */
	public static int maxPassengers(Flight[] flights, String airport) {
		int maxPass = 0;
		for (int i = 0; i < flights.length; i++) {
			if (flights[i].getDestination().getName().equals(airport) && maxPass < flights[i].getPassengers()) {
				maxPass = flights[i].getPassengers();
			}
		}
		return maxPass;
	}

	/**
	 * @param flights
	 * @return the percentage of flights with no empty seats
	 */
	public static double percentageNoEmptySeats(Flight[] flights) {
		int notEmpty = 0;
		for (int i = 0; i < flights.length; i++) {
			if (flights[i].getPassengers() == flights[i].getSeats()) {
				notEmpty++;
			}
		}
		return notEmpty / flights.length;
	}

	/**
	 * @param flights
	 * @param airport
	 * @param state
	 * @param year
	 * @return the average number of passengers that flied from the given airport to
	 *         the given state in the given year
	 */
	public static double avgPassengerFromToState(Flight[] flights, String airport, String state, int year) {
		int sum = 0;
		int length = 0;
		for (int i = 0; i < flights.length; i++) {
			if (flights[i].getFlightDate().getYear() == year && flights[i].getOrigin().getName().equals(airport)
					&& flights[i].getDestination().getState().equals(state)) {
				sum += flights[i].getPassengers();
				length++;
			}
		}
		return sum / length;
	}
}