package com.tryp.trip_stay;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepository.CheckOutPage;
import objectRepository.PackagesPage;
import objectRepository.TripsPage;
import objectRepository.TripsStayPage;

public class Home_Checkout extends BaseClass {
	@Test(groups="system")
	public void checkoutNegativeTest() throws Exception {
		// Search for Package
		hp.getCookies().click();
		TripsPage tp = new TripsPage(driver);
		hp.getTrip_stayBtn().click();
		tp.getWhereToGoBtn().click();
		tp.getDepartfrmBtn().click();
		wu.expicitWait_visibility(driver, tp.getPlaceBtn());
		tp.getPlaceBtn().click();
		String orgPlace = tp.getPlaceName().getText();
		tp.getDestinationplace().click();
		String DestPlace = tp.getDestPlaceName().getText();
		tp.getWhenBtn().click();
		tp.getFromDate().click();
		tp.getTodate().click();
		tp.getTravelerBtn().click();
		tp.getTravellerIncrementBtn().click();
		tp.getSearchBtn().click();

		// select package 
		TripsStayPage tsp = new TripsStayPage(driver);
		wu.javaScriptClickOnElement(driver, tsp.getPackages());
		
		//change accommodation 
		wu.expicitWait_eleClickable(driver, tsp.getAcc_changeBtn());
		wu.javaScriptClickOnElement(driver, tsp.getAcc_changeBtn());
		wu.expicitWait_eleClickable(driver, tsp.getViewHotelBtn());
		tsp.getViewHotelBtn().click();
		tsp.getSelectHotel().click();
		
		//click on Book-Now
		wu.expicitWait_visibility(driver, tp.getBookNowBtn());
		wu.javaScriptClickOnElement(driver, tp.getBookNowBtn());
		
		//Navigate to checkout page and click on next button without providing passengers details
		CheckOutPage cp= new CheckOutPage(driver);
		wu.javaScriptClickOnElement(driver,cp.getCheckDetailsBtn());
		String errorMsg = cp.getErrorMsg().getText();
		System.out.println(errorMsg);
		
		//verify the Error msg
		Assert.assertEquals(errorMsg, "Field is required.");
		cp.getCloseCheckoutPage().click();
		

	}
}
