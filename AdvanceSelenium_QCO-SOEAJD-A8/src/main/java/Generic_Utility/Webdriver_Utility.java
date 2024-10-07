package Generic_Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Webdriver_Utility {

	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	
	public void windowMaximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * waits for elements to get loaded
	 * @param driver
	 */
	public void pageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * cursor move to element
	 * @param driver
	 * @param ele
	 */
	public void mouseMoveToElement(WebDriver driver,WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		}
	
	/**
	 * switching multiple windows
	 * @param driver
	 * @param partialTitle
	 */
	public void windowSwitching(WebDriver driver,String partialTitle)
	{
		Set<String> allWins = driver.getWindowHandles();

		Iterator<String> it = allWins.iterator();

		while (it.hasNext()) {
			String win = it.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();

			if (title.contains(partialTitle)) {
				break;
			}
		}
	}
	/**
	 * Alert accept
	 * @param driver
	 */
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * Alert cancel
	 * @param driver
	 */
	public void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
		
	}
	
    public static String takeScreenShot(WebDriver driver, String screenShotNames) throws Throwable {
		
		TakesScreenshot takesSceenShot = (TakesScreenshot) driver;
		File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShots/" + screenShotNames +".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
    }

	public static String takeScreenShot1(WebDriver sdriver, String screenShotName) throws Throwable {
		
		TakesScreenshot takesSceenShot = (TakesScreenshot) sdriver;
		File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShots/" + screenShotName +".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}

	
}