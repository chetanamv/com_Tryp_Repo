package com.tryp.trip_stay;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepository.BookMarkPage;
import objectRepository.PackagesPage;
import objectRepository.TripsPage;
import objectRepository.TripsStayPage;

public class Package_BookmarkTest extends BaseClass {
	@Test(groups="integration")
	public void bookMarkTest() throws Exception {
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
		String selectedPackage = pp.getSelectedPackage_Bookmark().getText();
		System.out.println(selectedPackage);

		// add package to bookmark page
		pp.getBookmarkIcon().click();
		hp.getNavigate_Bookmark().click();
		BookMarkPage bp = new BookMarkPage(driver);
		wu.expicitWait_visibility(driver, bp.getBookmarkedPackage());
		String packBookMarked = bp.getBookmarkedPackage().getText();
		bp.getRemovePackage().click();

		// validate bookmarked package
		Assert.assertTrue(packBookMarked.contains(selectedPackage));
		driver.findElement(By.xpath("//div[@class='css-1dzf0xb']")).click();
		

	}
}
