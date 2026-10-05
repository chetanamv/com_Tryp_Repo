package com.tryp.one_way;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepository.CheckOutPage;
import objectRepository.IncludeLocationsPage;
import objectRepository.LoginPage;
import objectRepository.OneWayPage;
import objectRepository.TripsPage;

public class ChangeTransport_CheckoutTest extends BaseClass {

	@Test(groups="system")
	public void addReturnTransportToOneWayTrip() throws Exception {
		// 1.Navigate to one-way page
		/*
		 * LoginPage lp= new LoginPage(driver); wu.expicitWait_visibility(driver,
		 * lp.getMenuCloseBtn()); lp.getMenuCloseBtn().click();
		 */
		hp.getCookies().click();
		hp.getOne_wayBtn().click();

		// 2.search for package
		TripsPage tp = new TripsPage(driver);
		tp.getWhereToGoBtn().click();
		OneWayPage op = new OneWayPage(driver);
		tp.getDepartfrmBtn().click();
		tp.getPlaceBtn().click();
		String orgPlace = tp.getPlaceName().getText();
		op.getWhereToGoBtn().click();

		// 2.1 capture destination place name
		op.getDestinationPlace().click();
		String DestPlace = op.getDestinationName().getText();
		System.out.println(DestPlace);
		tp.getWhenBtn().click();
		tp.getFromDate().click();
		tp.getTodate().click();
		tp.getTravelerBtn().click();
		tp.getTravellerIncrementBtn().click();
		tp.getSearchBtn().click();

		// 3.select carriers and click on book-now
		IncludeLocationsPage ip = new IncludeLocationsPage(driver);
		ip.getSelectTransport().click();
		Thread.sleep(2000);

		wu.javaScriptClickOnElement(driver, driver.findElement(By.xpath("//button[contains(@class,'css-xy3qjn')]")));
		driver.findElement(By.xpath("(//span[text()='Select'])[1]")).click();
		wu.expicitWait_visibility(driver, tp.getBookNowBtn());
		wu.javaScriptClickOnElement(driver, tp.getBookNowBtn());

		// Navigate to checkout page and capture updated return place
		CheckOutPage cp = new CheckOutPage(driver);
		cp.getViewMore().click();
		wu.expicitWait_visibility(driver, cp.getReturnPlace());
		String returnPlace = cp.getReturnPlace().getText();
		System.out.println(returnPlace);
		
		// verify the return place
		Assert.assertTrue(returnPlace.contains(DestPlace));
		cp.getCloseCheckoutPage().click();
	}
}
