package testCaseUsingBaseclass;

import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import ObjectRepository.CreateCampPage;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.ValidatingPage_camp;
import ObjectRepository.VtigerLoginPage;

public class CreateProductTest extends BaseClass{
	@Test
	public void createProduct() throws Throwable {

		Webdriver_Utility wlib = new Webdriver_Utility();
        File_Utility file = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
	

		HomePage home = new HomePage(driver);
		home.clickPrdLink();
		
		CreateProductPage prodPage = new CreateProductPage(driver);
		prodPage.clickloopUpImg();
	
	   int ranNum = jlib.getRandonNum();

	   String prdData = elib.getExcelData("Product", 0, 0) + ranNum;
	   System.out.println(prdData);

	
	   prodPage.enterPrdName(prdData);
	   prodPage.clicksaveButton();
		
		home.logOutFromApp();
		

	}

}
