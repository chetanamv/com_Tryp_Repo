package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(id="trip")
	private WebElement tripsBtn;

	@FindBy(id="package-holiday")
	private WebElement trip_stayBtn;
	
	@FindBy(id="one-way")
	private WebElement one_wayBtn;
	
	@FindBy(xpath = "//div[@class='css-129xt7q']")
	private WebElement menuBtn;
	
	@FindBy(id="sign-out-menu")
	private WebElement signOutBtn;
	
	@FindBy(xpath="//p[text()='Accept']")
	private WebElement cookies;
	
	@FindBy(id="navbar-bookmarks")
	private WebElement Navigate_Bookmark;
	
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getTripsBtn() {
		return tripsBtn;
	}


	public WebElement getTrip_stayBtn() {
		return trip_stayBtn;
	}


	public WebElement getOne_wayBtn() {
		return one_wayBtn;
	}


	public WebElement getMenuBtn() {
		return menuBtn;
	}


	public WebElement getSignOutBtn() {
		return signOutBtn;
	}


	public WebElement getCookies() {
		return cookies;
	}
	


	public WebElement getNavigate_Bookmark() {
		return Navigate_Bookmark;
	}


	public void signOut()
	{
		menuBtn.click();
		signOutBtn.click();
	}
	
}
