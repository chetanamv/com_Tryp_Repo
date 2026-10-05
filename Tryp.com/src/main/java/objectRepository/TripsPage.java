package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TripsPage {

	@FindBy(xpath="//p[text()='Where to?']")
	private WebElement whereToGoBtn;
	
	@FindBy(xpath="//div[@class='css-1ki54i']")
	private WebElement departfrmBtn;
	
	@FindBy(xpath="//div[@class=' css-1b6f37n']/div/descendant::p[text()='New Delhi']")
	private WebElement placeBtn;
	
	@FindBy(xpath="//div[@class=' css-pk5bw7']")
	private WebElement placeName;
	
	@FindBy(xpath="//img[@alt='Italy']")
	private WebElement destinationplace;
	
	@FindBy(xpath="//span[contains(@class,'1h8gyx6')]")
	private WebElement DestPlaceName;
	
	@FindBy(xpath="//div[@class='css-l0413z']")
	private WebElement whenBtn;
	
	@FindBy(xpath="//div[@class='rdrMonthName' and text()='October 2026']/../child::div[@class='rdrDays']/button/descendant::span[text()='10']")
	private WebElement fromDate;
	@FindBy(xpath="//div[@class='rdrMonthName' and text()='October 2026']/../child::div[@class='rdrDays']/button/descendant::span[text()='12']")
	private WebElement todate;
	@FindBy(id="travelers-pill")
	private WebElement travelerBtn;
	
	@FindBy(xpath="(//button[@class='css-1ssg4ie'])[1]")
	private WebElement travellerIncrementBtn;
	
	@FindBy(id="make-search-desktop")
	private WebElement searchBtn;
	
	@FindBy(xpath="(//div[@class='css-2ldqdl']/descendant::h3)[1]")
	private WebElement displayed_dest_place;
	
	@FindBy(xpath="(//div[@class='css-2ldqdl']/descendant::p[contains(@class,'css-er0ddv')])[2]")
	private WebElement displayed_origin_place;
	
	@FindBy(xpath="(//div[@class='css-2ldqdl']/descendant::button)[2]")
	private WebElement packages;
	
	@FindBy(id="book-button-desktop")
	private WebElement bookNowBtn;
	
	public TripsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getWhereToGoBtn() {
		return whereToGoBtn;
	}

	public WebElement getDepartfrmBtn() {
		return departfrmBtn;
	}

	public WebElement getPlaceBtn() {
		return placeBtn;
	}

	public WebElement getDestinationplace() {
		return destinationplace;
	}

	public WebElement getWhenBtn() {
		return whenBtn;
	}

	public WebElement getFromDate() {
		return fromDate;
	}

	public WebElement getDisplayed_dest_place() {
		return displayed_dest_place;
	}

	public WebElement getDisplayed_origin_place() {
		return displayed_origin_place;
	}

	public WebElement getTravelerBtn() {
		return travelerBtn;
	}

	public WebElement getTravellerIncrementBtn() {
		return travellerIncrementBtn;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getPackages() {
		return packages;
	}

	public WebElement getBookNowBtn() {
		return bookNowBtn;
	}

	public WebElement getDestPlaceName() {
		return DestPlaceName;
	}

	public WebElement getPlaceName() {
		return placeName;
	}

	public WebElement getTodate() {
		return todate;
	}
	
	
	
	
}
