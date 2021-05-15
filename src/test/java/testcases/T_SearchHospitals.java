package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseUI;

public class T_SearchHospitals extends BaseUI {
	
	
	@Test
	public void hospitalSearch() throws InterruptedException, IOException {
		logger = report.createTest("HospitalSearch");
		setPropertiesFile();
		

		getElement("xpathHospitalSearchURL").click();
		waitLoad(2);
		getElement("xpath_location").click();
		getElement("xpath_cross").click();
		
		enterText("xpath_location", "city");
		waitLoad(2);
		getElement("xpath_locationClick").click();
		waitLoad(5);
		
		getElement("xpathsort1").click();
		waitLoad(5);

		getElement("xpathAllFilters").click();
		getElement("xpathHasParking").click();

		for (int i = 0; i < 18; i++) {
			scrollBy();
		}

		sortHospitalsByRating(3.5);
		writeExcel("HospitalNames");
	}
	
	public static T_TopCities nextPage1() {
		// sending driver to next page
		return nextPage();
	}

}
