package testCaseUsingBaseclass;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.ValidatingPage_camp;

public class CreateOrganizationTest extends BaseClass {
	
	@Test
	public void createOrganization() throws Throwable {

		Webdriver_Utility wlib = new Webdriver_Utility();
        File_Utility file = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		HomePage home = new HomePage(driver);

		home.clickOrgLink();
			
		CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
		orgPage.clickOrgPlusSign();
		
		int ranNum = jlib.getRandonNum();
		 
		String organizationData = elib.getExcelDataUsingDataFormatter("Org1", 0, 0)+ranNum;
		String phoneNum = elib.getExcelDataUsingDataFormatter("Org1", 2, 0);
		String emailId = elib.getExcelDataUsingDataFormatter("Org1", 3, 0); 
//		orgPage.orgData(organizationData, phoneNum, emailId);
		  orgPage.orgData(organizationData, phoneNum,emailId);
		  orgPage.clickOnSaveButton();
		  
		  Thread.sleep(2000);
		  home.logOutFromApp();
		


}

}
