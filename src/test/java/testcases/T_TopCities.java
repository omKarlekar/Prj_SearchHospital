package testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import base.BaseUI;

public class T_TopCities extends BaseUI{
	
    public T_TopCities(WebDriver driver) {
    	this.driver=(RemoteWebDriver) driver;
    }
	@Test
	public void topCities() throws InterruptedException, IOException {
		
		logger = report.createTest("getTopCities");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		setPropertiesFile();
		navigateto("testurl");
		getElement("xpathDiagnostic").click();
		
		
		displayCities();
		writeExcel("TopCities");
	
	}
	
	public static T_AlertMessage nextPage3() {
		// sending driver to next page
		return nextPage2();
	}

}
