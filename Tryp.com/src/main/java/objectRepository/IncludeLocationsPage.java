package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IncludeLocationsPage {
	
	@FindBy(xpath="(//button[@id='change-transport'])[1]")
	private WebElement selectTransport;
	
	public IncludeLocationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSelectTransport() {
		return selectTransport;
	}
	
	

}
