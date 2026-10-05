package com.tryp.trip_stay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepository.PackagesPage;
import objectRepository.TripsPage;
import objectRepository.TripsStayPage;

public class AccommodationTest extends BaseClass {
	@Test(groups="smoke")
	public void changeAccommodationTest() throws Exception {
		// Search for Package
		hp.getCookies().click();
		TripsPage tp = new TripsPage(driver);
		hp.getTrip_stayBtn().click();
		tp.getWhereToGoBtn().click();
		tp.getDepartfrmBtn().click();
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

		// select package change accommodation and click on Book-Now
		TripsStayPage tsp = new TripsStayPage(driver);
		wu.javaScriptClickOnElement(driver, tsp.getPackages());
		PackagesPage pp = new PackagesPage(driver);
		wu.expicitWait_visibility(driver, pp.getSuggestedHotel());
		String suggested = pp.getSuggestedHotel().getText();
		System.out.println(suggested);
		wu.javaScriptClickOnElement(driver, tsp.getAcc_changeBtn());
		wu.expicitWait_eleClickable(driver, tsp.getViewHotelBtn());
		tsp.getViewHotelBtn().click();
		tsp.getSelectHotel().click();
		
		wu.javaScriptClickOnElement(driver, pp.getAccommodationTab());
		Thread.sleep(3000);
		String selected = pp.getSelectedHotel().getText();
		System.out.println(selected);
		// validate the accommodation changes
		Assert.assertFalse(suggested.contains(selected));

	}
}
