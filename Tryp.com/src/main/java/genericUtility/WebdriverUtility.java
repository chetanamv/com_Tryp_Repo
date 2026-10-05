package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {

	public WebDriver launchBrowser(String browser) {
		WebDriver driver;
		if (browser.equalsIgnoreCase("chrome")) {
			final Map<String, Object> chromePrefs = new HashMap<>();
			chromePrefs.put("credentials_enable_service", false);
			chromePrefs.put("profile.password_manager_enabled", false);
			chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one
			final ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("prefs", chromePrefs);
			
			driver = new ChromeDriver(chromeOptions);
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	public void implicitWait(WebDriver driver, int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	// select class methods
	public void selectByVisibleText(WebElement dropdown, String status) {
		Select s = new Select(dropdown);
		s.selectByVisibleText(status);
	}

	public void selectByValue(WebElement dropdown, String value) {
		Select s = new Select(dropdown);
		s.selectByValue(value);
	}

	public void selectByIndex(WebElement dropdown, int index) {
		Select s = new Select(dropdown);
		s.selectByIndex(index);
	}

	// Actions Class methods
	public void moveToElement(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).pause(2).perform();
	}
	public void moveToElementAndClick(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).pause(2).click().perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement drag, WebElement drop) {
		Actions a = new Actions(driver);
		a.dragAndDrop(drag, drop).perform();
	}

	public void scrollToElement(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.scrollToElement(ele);
	}

	// TakeScreenShot of webElement
	public void takeScreenshot(String file, WebElement ele) throws IOException {
		File src = ele.getScreenshotAs(OutputType.FILE);
		File dst = new File(file);
		FileHandler.copy(src, dst);
	}
	// expicitWait
	public void expicitWait_title(WebDriver driver,String title)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains(title));
}
	public void expicitWait_visibility(WebDriver driver,WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
}
	public void expicitWait_alert(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
}
	public void expicitWait_eleClickable(WebDriver driver,WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void swithToWindow(WebDriver driver,String windowId) {
		Set<String> ids = driver.getWindowHandles();
		for(String id:ids)
		{
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().contains(windowId))
			{
				break;
			}
		}
		
		
	}
	public WebDriver switchToFrame(WebDriver driver,int index)
	{
		return driver.switchTo().frame(index);
	}
	
	public WebDriver switchToFrame(WebDriver driver,WebElement ele)
	{
		return driver.switchTo().frame(ele);
	}
	
	public void takeScreenShot(WebDriver driver,String filePath) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
	File src	=ts.getScreenshotAs(OutputType.FILE);
	File dst=new File(filePath);
	FileHandler.copy(src, dst);
	
	}
	
	public void javaScriptClickOnElement(WebDriver driver, WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}
/*
 * public void expicitWait_title(WebDriver driver,W) { WebDriverWait wait = new
 * WebDriverWait(driver,Duration.ofSeconds(20));
 * wait.until(ExpectedConditions.elementToBeClickable(null); }
 */
	
}
