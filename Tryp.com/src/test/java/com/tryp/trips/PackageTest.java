package com.tryp.trips;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepository.CheckOutPage;
import objectRepository.PackagesPage;
import objectRepository.TripsPage;

public class PackageTest extends BaseClass {
	@Test(groups="smoke")
	public void bookPackageTest() throws Exception {
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
		tp.getTravelerBtn().click();
		tp.getTravellerIncrementBtn().click();
		tp.getSearchBtn().click();
		Thread.sleep(2000);
		
		// Validate the result
		Assert.assertTrue(orgPlace.contains(tp.getDisplayed_origin_place().getText()));
		Assert.assertTrue(tp.getDisplayed_dest_place().getText().contains(DestPlace));

		// select package and click on Book-Now
		wu.javaScriptClickOnElement(driver, tp.getPackages());
		wu.javaScriptClickOnElement(driver, tp.getBookNowBtn());

		// validate selected package
		PackagesPage pp = new PackagesPage(driver);
		Assert.assertTrue(pp.getSelectedPackage().getText().contains(DestPlace));
		CheckOutPage cp= new CheckOutPage(driver);
		cp.getCloseCheckoutPage().click();
	}
	
}


