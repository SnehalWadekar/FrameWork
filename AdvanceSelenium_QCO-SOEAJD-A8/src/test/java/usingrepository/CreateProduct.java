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
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.ValidatingPage_camp;
import ObjectRepository.VtigerLoginPage;

public class CreateProduct {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();

		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		Webdriver_Utility wlib = new Webdriver_Utility();

		wlib.windowMaximize(driver);
		wlib.pageToLoad(driver);
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

		driver.get(URL);
		
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToVitger(USERNAME, PASSWORD);

		HomePage home = new HomePage(driver);
		home.clickPrdLink();
		
		CreateProductPage prodPage = new CreateProductPage(driver);
		prodPage.clickloopUpImg();
	
	   int ranNum = jlib.getRandonNum();

	   String prdData = elib.getExcelData("Product", 0, 0) + ranNum;
	   System.out.println(prdData);

	
	   prodPage.enterPrdName(prdData);
	   prodPage.clicksaveButton();
	
	
//		ValidatingPage_camp validate = new ValidatingPage_camp(driver);
//		validate.validateCampPage(driver, prdData);
//
//		home.clickOnAdmLink();
		home.logOutFromApp();
	}

}