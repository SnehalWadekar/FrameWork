package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidatingPage_product {

	public ValidatingPage_product (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateCampPage(WebDriver driver,String prdName)
	{
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

		if(actData.contains(prdName))
		{
		System.out.println("product name is created");
		}
		else
		{
		System.out.println("product name not created");
		}
	}
}
