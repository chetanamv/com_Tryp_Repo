package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TripsStayPage {
	
	@FindBy(xpath="(//div[@class='css-2ldqdl']/descendant::button[contains(@id,'view-deal')])[2]")
	private WebElement packages;
	
	@FindBy(xpath="//div[contains(@class,'css-1tpeq0c')]/descendant::p[text()='Change']")
	private WebElement Acc_changeBtn;
	
	@FindBy(xpath="//button[@id='view-hotel']")
	private WebElement viewHotelBtn;
	
	@FindBy(xpath="//button/p[text()='Select']")
	private WebElement selectHotel;
	
	
	
	public TripsStayPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPackages() {
		return packages;
	}

	public WebElement getAcc_changeBtn() {
		return Acc_changeBtn;
	}

	public WebElement getViewHotelBtn() {
		return viewHotelBtn;
	}

	public WebElement getSelectHotel() {
		return selectHotel;
	}
	
	
	

}
