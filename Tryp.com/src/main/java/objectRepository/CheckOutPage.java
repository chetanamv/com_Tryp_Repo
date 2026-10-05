package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
	@FindBy(xpath="//div[@class='css-1jnycmq']")
	private WebElement viewMore;
	
	@FindBy(xpath="//p[contains(@class,'css-t63aw1')]")
	private WebElement destPlace;
	
	@FindBy(xpath="//p[contains(@class,'css-oplopc')]")
	private WebElement travelersNo;
	
	@FindBy(xpath="(//p[@class='chakra-text css-t63aw1'])[2]")
	private WebElement returnPlace;
	
	@FindBy(xpath="(//div[contains(@class,'chakra-form__error-message')])[1]")
	private WebElement errorMsg;
	
	@FindBy(name="firstname")
	private WebElement firstName;
	
	@FindBy(name="surname")
	private WebElement lastName;
	
	@FindBy(name="nationality")
	private WebElement nationality;
	
	@FindBy(name="gender")
	private WebElement gender;
	
	@FindBy(id="custom-phone-input")
	private WebElement phoneNo;
	
	@FindBy(xpath="//input[@placeholder='DD']")
	private WebElement date;
	
	@FindBy(xpath="//select[contains(@class,'css-we7h07')]")
	private WebElement month;
	
	@FindBy(xpath="//input[@placeholder='YYYY']")
	private WebElement year;
	@FindBy(id="checkout-contact-details")
	private WebElement checkDetailsBtn;
	
	@FindBy(xpath="//p[text()='Next step']")
	private WebElement nextBtn1;
	
	@FindBy(xpath="//button[contains(@class,'css-yl61gu')]")
	private WebElement nextBtn2;
	
	@FindBy(id="confirm-details")
	private WebElement confirmDetails;
	
	@FindBy(xpath="//h2[text()='Payment']")
	private WebElement paymentBtn;
	
	@FindBy(xpath="//div[@class='css-113vlvm']")
	private WebElement closeCheckoutPage;
	
	public CheckOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getViewMore() {
		return viewMore;
	}

	public WebElement getDestPlace() {
		return destPlace;
	}

	public WebElement getTravelersNo() {
		return travelersNo;
	}

	public WebElement getReturnPlace() {
		return returnPlace;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getNationality() {
		return nationality;
	}

	public WebElement getGender() {
		return gender;
	}

	public WebElement getPhoneNo() {
		return phoneNo;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getYear() {
		return year;
	}

	public WebElement getCheckDetailsBtn() {
		return checkDetailsBtn;
	}

	public WebElement getNextBtn1() {
		return nextBtn1;
	}

	public WebElement getNextBtn2() {
		return nextBtn2;
	}

	public WebElement getConfirmDetails() {
		return confirmDetails;
	}

	public WebElement getPaymentBtn() {
		return paymentBtn;
	}

	public WebElement getCloseCheckoutPage() {
		return closeCheckoutPage;
	}

	public WebElement getErrorMsg() {
		return errorMsg;
	}
	
	
	
	
	
	

}
