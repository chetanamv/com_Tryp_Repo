package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.ObjectUtility;
import genericUtility.WebdriverUtility;

public class LoginPage {

	@FindBy(xpath = "//div[@class='css-129xt7q']")
	private WebElement menuBtn;

	@FindBy(xpath = "//p[text()='Log in here']")
	private WebElement LoginHere;

	@FindBy(id = "email-login")
	private WebElement email;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "login-submit")
	private WebElement LoginBtn;

	@FindBy(xpath = "//div[@class='css-1dzf0xb']//*[name()='svg'][@viewBox='0 0 6 10']")
	private WebElement menuCloseBtn;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLoginHere() {
		return LoginHere;
	}

	public WebElement getMenuBtn() {
		return menuBtn;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}

	public WebElement getMenuCloseBtn() {
		return menuCloseBtn;
	}

	public void loginToApp(String Email, String pass) throws InterruptedException {

		menuBtn.click();
		LoginHere.click();
		email.sendKeys(Email);
		password.sendKeys(pass);
		LoginBtn.click();
		
		Thread.sleep(2000);
		menuCloseBtn.click();
		
		 
		
		
		
		
		
	}

}
