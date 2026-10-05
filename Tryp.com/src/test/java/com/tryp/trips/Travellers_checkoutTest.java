package com.tryp.trips;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepository.CheckOutPage;
import objectRepository.PackagesPage;
import objectRepository.TripsPage;

public class Travellers_checkoutTest extends BaseClass {
	@Test(groups="integration")
	public void increaseNoTravellers() throws Exception {
		// Search for Package
		hp.getCookies().click();
		TripsPage tp = new TripsPage(driver);
		tp.getWhereToGoBtn().click();
		tp.getDepartfrmBtn().click();
		tp.getPlaceBtn().click();
		String orgPlace = tp.getPlaceName().getText();
		tp.getDestinationplace().click();
		String DestPlace = tp.getDestPlaceName().getText();
		tp.getWhenBtn().click();
		tp.getFromDate().click();
		tp.getTodate().click();
		tp.getSearchBtn().click();
		Thread.sleep(2000);
		
		//select package
		wu.javaScriptClickOnElement(driver, tp.getPackages());
		PackagesPage pp= new PackagesPage(driver);
		
		//increase No of travelers and save
		wu.javaScriptClickOnElement(driver,pp.getTravellersBtn());
		tp.getTravellerIncrementBtn().click();
		pp.getTravellerSaveBtn().click();
		
		// capture travelers no.in package page
		wu.expicitWait_visibility(driver, tp.getBookNowBtn());
		String updatedNoTravellers = pp.getTravellersBtn().getText();
		
		//Navigate to checkOut page and capture travelers no
		wu.javaScriptClickOnElement(driver, tp.getBookNowBtn());
		CheckOutPage cp= new CheckOutPage(driver);
		String travelersNo = cp.getTravelersNo().getText();
		
		//validate update travelers number in checkout page
		Assert.assertTrue(travelersNo.contains(updatedNoTravellers));
		cp.getCloseCheckoutPage().click();
		
	}
}
