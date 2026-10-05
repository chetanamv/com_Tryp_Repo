package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PackagesPage {
	
	@FindBy(xpath="//div[@class='css-1ki54i']/p[contains(@class,'spw7z4')]")
	private WebElement SelectedPackage;
	
	@FindBy(xpath="//span[contains(@class,'css-1lpqu1e')]")
	private WebElement selectedPackage_Bookmark;
	
	@FindBy(xpath="//div[@class='css-1a03dr']")
	private WebElement BookmarkIcon;

	@FindBy(xpath="//button/p[text()='Accommodation']")
	private WebElement accommodationTab;
	
	@FindBy(xpath="//h4[@class='chakra-heading css-nngcfr']")
	private WebElement suggestedHotel;
	
	@FindBy(xpath="(//h4[contains(@class,'chakra-heading')])[1]")
	private WebElement selectedHotel;
	
	@FindBy(id="change-passengers")
	private WebElement travellersBtn;
	
	@FindBy(id="save-button")
	private WebElement TravellerSaveBtn;
	
	public PackagesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSelectedPackage() {
		return SelectedPackage;
	}

	public WebElement getAccommodationTab() {
		return accommodationTab;
	}

	public WebElement getSelectedHotel() {
		return selectedHotel;
	}

	public WebElement getSuggestedHotel() {
		return suggestedHotel;
	}
	
	public WebElement getSelectedPackage_Bookmark() {
		return selectedPackage_Bookmark;
	}

	public WebElement getBookmarkIcon() {
		return BookmarkIcon;
	}

	public WebElement getTravellersBtn() {
		return travellersBtn;
	}

	public WebElement getTravellerSaveBtn() {
		return TravellerSaveBtn;
	}
	
	
	
	

}
