package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import base.BaseUI;

public class T_AlertMessage extends BaseUI{
	public T_AlertMessage(WebDriver driver) {
    	this.driver=(RemoteWebDriver) driver;
    }
	
	@Test
	public void getAlert() throws InterruptedException {
		logger = report.createTest("getAlert");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		setPropertiesFile();
		driver.navigate().back();
		getElement("xpathForProviders").click();
		

		getElement("xpathCorporateWellness").click();
		
		switchToOtherWindow();
		
		waitLoad(2);
		enterText("name_id", "invalidKeys1");
		enterText("orgname_id", "invalidKeys2");
		enterText("email_id", "invalidKeys3");
		enterText("phoneno_id", "invalidKeys4");
		SelectElementInList(getElement("xpathDropdown"), "organization_size");
		
		getElement("xpathSubmit").click();
		
		getAlertText();
	}

}
