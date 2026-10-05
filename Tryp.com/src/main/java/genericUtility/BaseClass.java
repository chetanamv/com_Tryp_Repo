package genericUtility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import objectRepository.HomePage;
//import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	// public- utility file are in different package
		public DataBaseUtility du = new DataBaseUtility();
		public PropertyFileUtility pu = new PropertyFileUtility();
		public WebdriverUtility wu = new WebdriverUtility();
		public ExcelFileUtility eu = new ExcelFileUtility();
		public JavaUtility ju = new JavaUtility();
		public WebDriver driver;
		public WebDriver sdriver;
		public HomePage hp;

		@BeforeSuite(groups = { "smoke", "regrassion" })
		public void DbConnection() {
			System.out.println("============connect to DB, Report config============");

		}

		@Parameters("Browser")
		@BeforeClass(groups = { "smoke", "regrassion" })
		public void LaunchBrowser() throws Exception {
			System.out.println("===============Launch Browser================");
			// String b=browser;
			// driver = wu.launchBrowser(b); //---------------CrossBrowserTesting
			//System.out.println(pu.getProprty("browser"));
			String Browser= System.getProperty("browser", pu.getProperty("browser"));
			driver = wu.launchBrowser(Browser);
			sdriver = driver;
			ObjectUtility.setDriver(driver);
			wu.maximize(driver);
			wu.implicitWait(driver, 20);
		}

		@BeforeMethod(groups = { "smoke", "regrassion" })
		public void LoginToApp() throws Exception {
			System.out.println("===============Login to Application================");
			String URL=System.getProperty("url", pu.getProperty("url"));
			String EMAIL=System.getProperty("email", pu.getProperty("email"));
			String PASSWORD=System.getProperty("password", pu.getProperty("password"));
			
			driver.get(URL);
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(EMAIL, PASSWORD);
			hp = new HomePage(driver);
			
			
		}

		@AfterMethod(groups = { "smoke", "regrassion" })
		public void LogoutFromApp() {
			System.out.println("===============Logout form Application========");
			wu.javaScriptClickOnElement(driver,hp.getMenuBtn());
			wu.javaScriptClickOnElement(driver, hp.getSignOutBtn());

		}

		@AfterClass(groups = { "smoke", "regrassion" })
		public void CloseBrowser() {
			System.out.println("===============Close Browser================");
			driver.quit();
		}

		@AfterSuite(groups = { "smoke", "regrassion" })
		public void CloseDb() {
			System.out.println("======close Data Base, Report backup======= ");
			
		}
		
}