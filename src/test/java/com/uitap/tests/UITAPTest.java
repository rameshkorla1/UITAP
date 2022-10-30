package com.uitap.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.uitap.actions.Actions;
import com.uitap.pages.UIHomePage;

@Listeners(com.uitap.reportlisteners.Listeners.class)
public class UITAPTest  extends Actions{
	
	UIHomePage homePage;
	
	@Test(priority=1)
	public void sampleAppTest()
	{
		homePage = new UIHomePage(driver);
		homePage.clickOnSampleApplink();
		homePage.waitToLoadPage(2);
		homePage.sampleAppLogin("non-empty", "pwd");
		homePage.waitToLoadPage(2);
		homePage.verifyUserLoginSuccess("Welcome, non-empty!");
	}
	
	@Test(priority=2)
	public void OverlappedElementTest()
	{
		homePage = new UIHomePage(driver);
		homePage.clickOnOverLappedElementLink();
		homePage.waitToLoadPage(2);
		homePage.enterTextIntoNamefield("Hello World", "TechSoft");
	}
	
	@Test(priority=3)
	public void TextInputTest()
	{
		homePage = new UIHomePage(driver);
		homePage.clickOnTextInputLink();
		homePage.waitToLoadPage(2);
		homePage.updatingButtonName("Submit Button");
	}
	
 
}
