package com.tryp.one_way;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepository.CheckOutPage;
import objectRepository.IncludeLocationsPage;
import objectRepository.OneWayPage;
import objectRepository.PackagesPage;
import objectRepository.TripsPage;

public class Package_ChackoutTest extends BaseClass {
	
	@Test(groups="integration")
	public void addPackageToCheckout() throws Exception {
		//1.Navigate to one-way page 
		hp.getCookies().click();
		hp.getOne_wayBtn().click();
		
		//2.search for package
		TripsPage tp = new TripsPage(driver);
		tp.getWhereToGoBtn().click();
		OneWayPage op= new OneWayPage(driver);
		tp.getDepartfrmBtn().click();
		
		tp.getPlaceBtn().click();
		String orgPlace = tp.getPlaceName().getText();
		op.getWhereToGoBtn().click();
		
		//2.1 capture destination place name
		op.getDestinationPlace().click();
		String DestPlace = op.getDestinationName().getText();
		System.out.println(DestPlace);
		tp.getWhenBtn().click();
		tp.getFromDate().click();
		tp.getTodate().click();
		tp.getTravelerBtn().click();
		tp.getTravellerIncrementBtn().click();
		tp.getSearchBtn().click();
		
		//3.select carriers and click on book-now
		IncludeLocationsPage ip= new IncludeLocationsPage(driver);
		ip.getSelectTransport().click();
		wu.javaScriptClickOnElement(driver, tp.getBookNowBtn());
	
		//Navigate to checkout page and capture updated destination place name
		CheckOutPage cp= new CheckOutPage(driver);
		cp.getViewMore().click();
		String dest =cp.getDestPlace().getText();
		System.out.println(dest);
		
		// verify the package with destination place in checkout page
		PackagesPage pp = new PackagesPage(driver);
		Assert.assertTrue(dest.contains(DestPlace));
		cp.getCloseCheckoutPage().click();

}
	@Test(groups="system")
	public void Home_PaymentPage() throws Exception {
		//1.Navigate to one-way page 
		//hp.getCookies().click();
		hp.getOne_wayBtn().click();
		
		//2.search for package
		TripsPage tp = new TripsPage(driver);
		tp.getWhereToGoBtn().click();
		OneWayPage op= new OneWayPage(driver);
		tp.getDepartfrmBtn().click();
		tp.getPlaceBtn().click();
		String orgPlace = tp.getPlaceName().getText();
		op.getWhereToGoBtn().click();
		
		//2.1 capture destination place name
		op.getDestinationPlace().click();
		String DestPlace = op.getDestinationName().getText();
		System.out.println(DestPlace);
		tp.getWhenBtn().click();
		tp.getFromDate().click();
		tp.getTodate().click();
		tp.getSearchBtn().click();
		
		//3.select carriers and click on book-now
		IncludeLocationsPage ip= new IncludeLocationsPage(driver);
		ip.getSelectTransport().click();
		wu.javaScriptClickOnElement(driver, tp.getBookNowBtn());
		
		//enter all passenger details
		CheckOutPage cp= new CheckOutPage(driver);
		cp.getFirstName().sendKeys(eu.ReadData("passengerDetails", 1, 0));
		cp.getLastName().sendKeys(eu.ReadData("passengerDetails", 1, 1));
		WebElement nationality = cp.getNationality();
		wu.selectByVisibleText(nationality,eu.ReadData("passengerDetails", 1, 2));
		WebElement gender = cp.getGender();
		wu.selectByValue(gender,eu.ReadData("passengerDetails", 1, 3));
		cp.getPhoneNo().sendKeys(eu.ReadData("passengerDetails", 1, 4));
		cp.getDate().sendKeys(eu.ReadData("passengerDetails", 1, 5));
		WebElement month = cp.getMonth();
		wu.selectByVisibleText(month, eu.ReadData("passengerDetails", 1, 6));
		cp.getYear().sendKeys(eu.ReadData("passengerDetails", 1, 7));
		wu.javaScriptClickOnElement(driver,cp.getCheckDetailsBtn());
		cp.getNextBtn1().click();
		cp.getNextBtn2().click();
		//cp.getConfirmDetails().click();
		String paymentWindow = cp.getPaymentBtn().getText();
		
		//verify for the payment window
		Assert.assertEquals(paymentWindow,"Payment");
		wu.expicitWait_visibility(driver, cp.getCloseCheckoutPage());
		wu.javaScriptClickOnElement(driver, cp.getCloseCheckoutPage());
}
}
