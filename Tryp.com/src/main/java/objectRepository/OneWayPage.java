package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OneWayPage {
	@FindBy(xpath="//div[@class=' css-j93siq']")
	private WebElement departBtn;
	
	@FindBy(xpath="(//div[@class=' css-18euh9p'])[2]")
	private WebElement WhereToGoBtn;
	
	@FindBy(xpath="(//div[@class='chakra-stack css-1j1ny18'])[1]")
	private WebElement destinationPlace;
	
	@FindBy(xpath="//span[@class=' css-1h8gyx6']")
	private WebElement destinationName;
	
	public OneWayPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getDepartBtn() {
		return departBtn;
	}

	public WebElement getWhereToGoBtn() {
		return WhereToGoBtn;
	}

	public WebElement getDestinationPlace() {
		return destinationPlace;
	}

	public WebElement getDestinationName() {
		return destinationName;
	}
	
	
	

}
