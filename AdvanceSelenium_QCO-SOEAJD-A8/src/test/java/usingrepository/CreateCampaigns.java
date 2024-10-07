package usingrepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import ObjectRepository.CreateCampPage;
import ObjectRepository.HomePage;
import ObjectRepository.ValidatingPage_camp;
import ObjectRepository.VtigerLoginPage;

public class CreateCampaigns {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();
		
		Webdriver_Utility wlib = new Webdriver_Utility();
        File_Utility file = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		wlib.windowMaximize(driver);

		String URL = file.getKeyAndValuePair("url");
		String USERNAME = file.getKeyAndValuePair("username");
		String PASSWORD = file.getKeyAndValuePair("password");

		driver.get(URL);

		// Business Logics
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToVitger(USERNAME, PASSWORD);

		HomePage home = new HomePage(driver);

		home.naviagteCamp(driver);

		CreateCampPage campPage = new CreateCampPage(driver);
		campPage.clickLookUpImg();

		int ranNum = jlib.getRandonNum();

		String campData = elib.getExcelData("Campaigns", 0, 0) + ranNum;
		System.out.println(campData);

		campPage.enterCampNAme(campData);
		campPage.clickSaveButton();

		ValidatingPage_camp validate = new ValidatingPage_camp(driver);
		validate.validateCampPage(driver, campData);

		home.clickOnAdmLink();
		home.logOutFromApp();
//		home.ClickSignOutLink();

	}

}