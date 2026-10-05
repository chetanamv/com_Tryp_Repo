package genericUtility;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener, ISuiteListener {
	public static ExtentReports report;
	//public ExtentTest test;
	

	public void onStart(ISuite suite) {
		System.out.println("Report configuration");

		// Spark report config
		JavaUtility ju= new JavaUtility();
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report1"+ju.time()+".html");
		spark.config().setDocumentTitle("Tryp Test Suite Result");
		spark.config().setReportName("Tryp report");
		spark.config().setTheme(Theme.DARK);

		// Add Env info and and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "Window-11");
		report.setSystemInfo("browser", "chrome-100");
	}

	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("=========" + result.getMethod().getMethodName() + "===start=====");
		 ExtentTest test = report.createTest(result.getMethod().getMethodName());
		 ObjectUtility.setTest(test);
		 test.log(Status.INFO, result.getMethod().getMethodName()+"=======Started=======");

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("=========" + result.getMethod().getMethodName() + "===end=====");
		ObjectUtility.getTest().log(Status.PASS, result.getMethod().getMethodName()+"=======Success=======");
	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		String methodName = result.getMethod().getMethodName();
		/*
		 * WebdriverUtility wu = new WebdriverUtility(); JavaUtility ju = new
		 * JavaUtility(); try { String time = ju.time();
		 * wu.takeScreenShot(BaseClass.sdriver, "./ScreenShots/" + methodName + time +
		 * ".png"); } catch (IOException e) { e.printStackTrace(); }
		 */
		JavaUtility ju= new JavaUtility();
		ObjectUtility ou=new ObjectUtility();
		TakesScreenshot ts = (TakesScreenshot) ou.getDriver();
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		ObjectUtility.getTest().addScreenCaptureFromBase64String(filepath,testName+"_"+ju.time());
		ObjectUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName()+"=======Failed=======");

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("=========" + result.getMethod().getMethodName() + "===skipped=====");
		ObjectUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName()+"=======Failed=======");
	}

}
