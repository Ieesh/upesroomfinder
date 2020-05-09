package upes.roomfinder;

import java.io.InputStream;
import java.util.ArrayList;

public class MyHandler {
	private static final int DEFAULT_HOUR = 0;
	private static final int DEFAULT_MINUTE=0;

	private Search search;
	private String building, buildingPass;
	private String[]day, stringToUpdate;
	int currentHour, currentMinute;
	private static final String[]buildingChoices = {"ninethblock", "tenthblock", "eleventhblock"};

	public MyHandler(String building, String day, int currentHour, int currentMinute, InputStream input) {
		this.building = building;
		decipherDay(day);
		this.currentHour = currentHour;
		this.currentMinute = currentMinute;
		search = new Search(input);
		fixStrings();
		performSearch();
		getUpdatedListings();
	}
	public MyHandler(String building, String day,InputStream input) {
		this.building = building;
		decipherDay(day);
		currentHour = DEFAULT_HOUR;
		currentMinute = DEFAULT_MINUTE;
		search = new Search(input);
		fixStrings();
		performSearch();
		getUpdatedListings();
	}

	public MyHandler(String building, String day,InputStream input, ArrayList scannerData) {
		this.building = building;
		decipherDay(day);
		currentHour = DEFAULT_HOUR;
		currentMinute = DEFAULT_MINUTE;
		search = new Search(input);
		search.setConflictList(scannerData);
		fixStrings();
		performSearch();
		getUpdatedListings();
		//search.printEntries();
	}


	public void performSearch() {
		search.findEntries(buildingPass, day, currentHour, currentMinute);
	}

	public void fixStrings() {
		if (building.equalsIgnoreCase(buildingChoices[0])) {
			buildingPass = "ANXCN";
			stringToUpdate = Keywords.ninethblock;
		}else if (building.equalsIgnoreCase(buildingChoices[1])){
			buildingPass = "ANXNO";
			stringToUpdate = Keywords.tenthblock;
		}else if (building.equalsIgnoreCase(buildingChoices[2])){
			buildingPass = "ANXSO";
			stringToUpdate = Keywords.eleventhblock;

		}else {
			buildingPass = building;
			stringToUpdate = Keywords.blank;
		}
	}

	public void getUpdatedListings() {
		search.updateListings(stringToUpdate);
	}

	/**
	 * This takes the day input and matches it to the arrays in keywords. Vital for searching.
	 * @param input is the day passed in from the Activity ResultsActivity
	 */
	public void decipherDay(String input) {
		if (input.equalsIgnoreCase("Monday")) {
			day = Keywords.getMondayCases();
		}else if (input.equalsIgnoreCase("Tuesday")) {
			day = Keywords.getTuesdayCases();
		}else if (input.equalsIgnoreCase("Wednesday")) {
			day = Keywords.getWednesdayCases();
		}else if (input.equalsIgnoreCase("Thursday")) {
			day = Keywords.getThursdayCases();
		}else if (input.equalsIgnoreCase("Friday")){
			day = Keywords.getFridayCases();
		}else {

		}
	}

	public void skipTimeSearch() {
		search.skipTimeSearch();
	}

	public ArrayList getResults(){
		return search.getResults();
	}
	public ArrayList getAllClassrooms() {
		return search.getAllClassrooms();
	}
	public ArrayList getDetailedRooms(){
		return search.getDetailedRooms();
	}
	public ArrayList getRawScannerData() {return  search.getRawScannerData();}
}
