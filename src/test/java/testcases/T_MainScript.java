package testcases;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseUI;

public class T_MainScript extends BaseUI{
	
	@Parameters ("browser")
	@BeforeTest(groups= {"smoke"})
	public void openBrowser(String browser) {
		logger = report.createTest("OpenBrowser");
		setPropertiesFile();
		invokeBrowser(browser);
		openURL("testurl");
	}
	
	@AfterTest(groups= {"smoke"})
	public void closeTheBrowser() {
		quitBrowser();
		endReport();
	}
	
	@Test(priority = 0,groups= {"regression","smoke"})
	public void hospitalSearch() throws InterruptedException, IOException {
		T_SearchHospitals hp=BaseUI.nextPage0();
		hp.hospitalSearch();
		
	}
	
	@Test(priority=1,groups= {"regression","smoke"})
	public void topCities() throws InterruptedException, IOException {
		T_TopCities tc=T_SearchHospitals.nextPage1();
		tc.topCities();
		
	}
	
	@Test(priority=2,groups= {"regression","smoke"})
	public void getAlerts() throws InterruptedException, IOException {
		T_AlertMessage am=T_TopCities.nextPage3();
		am.getAlert();
		
	}
}
