/**
 * Description : TestFacebook.java -Main test running test cases
 * Author      : Sheetal Chaudhari
 * Date        : 19/05/2020
 */
package com.bridgelabz.facebook.test;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Facebook.Facebook.BaseTest;
import Facebook.Facebook.FacebookLoginPage;
import Facebook.Facebook.FacebookDashboardPage;

public class TestFacebook extends BaseTest {
	@BeforeTest
	public void setUp() throws InterruptedException, IOException {
		initialize();
	}

	@Test(description = "After loging to facebook, posting the story on a wall")
	public void testAutomatingFacebookLoginAndLogout() throws InterruptedException, AWTException {

		FacebookLoginPage login = new FacebookLoginPage(driver);
		FacebookDashboardPage dashboard = new FacebookDashboardPage(driver);
		login.facebookLoginPage();
		Thread.sleep(3000);
		dashboard.addingPost();
		Thread.sleep(1000);
		dashboard.logoutFromApplication();
		Thread.sleep(1000);
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
}
