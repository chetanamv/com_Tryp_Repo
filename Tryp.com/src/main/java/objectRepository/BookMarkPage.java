package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookMarkPage {
	
	@FindBy(xpath="(//div[contains(@class,'css-m1v0qk')]/descendant::p)[2]")
	private WebElement BookmarkedPackage;
	
	@FindBy(xpath="//button[@aria-label='Remove bookmark']")
	private WebElement RemovePackage;
	
	public BookMarkPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getBookmarkedPackage() {
		return BookmarkedPackage;
	}

	public WebElement getRemovePackage() {
		return RemovePackage;
	}
	
	
	
	

}
