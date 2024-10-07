package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidatingPage_camp {

	public ValidatingPage_camp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateCampPage(WebDriver driver,String campName)
	{
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();

		if (actData.contains(campName)) {
			System.out.println("campaigns name is created");
		} else {
			System.out.println("campaigns name is not created");
		}
	}
}
