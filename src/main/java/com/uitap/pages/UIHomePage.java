package com.uitap.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class UIHomePage {
	
	public WebDriver driver;
	
	public UIHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/* *
	 * Sample App Scenario 
	 * */
	
	@FindBy(xpath="//*[@id='overview']/div/div[4]/div[2]/h3/a")
	WebElement SampleApp;
	
	@FindBy(css="input[name='UserName']")
	WebElement Username;
	
	@FindBy(css="input[name='Password']")
	WebElement Password;
	
	@FindBy(css="button[id='login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[@id='loginstatus']")
	WebElement successMsg;
	
	
	public void clickOnSampleApplink()
	{
		SampleApp.click();
	}
	
	public void sampleAppLogin(String user, String password)
	{
		Username.sendKeys(user);
		Password.sendKeys(password);
		loginBtn.click();
	}
	
	public void verifyUserLoginSuccess(String expected)
	{
		String actual = successMsg.getText();
		Assert.assertEquals(expected, actual);
		System.out.println("The Alert message is:" +actual);
	}
	
	/* *
	 * Overlapped Element Handling 
	 * */
	@FindBy(xpath="//*[@id='overview']/div/div[5]/div[1]/h3/a")
	WebElement OverlappedElement;
	
	@FindBy(xpath="//input[@id='id']")
	WebElement textID;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement Name;
	
	public void clickOnOverLappedElementLink()
	{
		OverlappedElement.click();
	}
	
	public void enterTextIntoNamefield(String text, String nametext)
	{
		textID.sendKeys(text);
		waitToLoadPage(2);
		//Scroll Into view for Element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Name);
		Name.sendKeys(nametext);
		System.out.println("The text is:" +Name.getAttribute("value"));
	}
	
	/* *
	 * Text Input Scenario 
	 * */
	
	@FindBy(xpath="//a[@href='/textinput']")
	WebElement textInputLink;
	
	@FindBy(xpath="//input[@id='newButtonName']")
	WebElement setNewButtonName;
	
	@FindBy(xpath="//button[@id='updatingButton']")
	WebElement updateButtonName;
	
	public void clickOnTextInputLink()
	{
		textInputLink.click();
	}
	
	public void updatingButtonName(String text)
	{
		setNewButtonName.sendKeys(text);
		waitToLoadPage(3);
		updateButtonName.click();
		waitToLoadPage(1);
		System.out.println("The Button name is:" +updateButtonName.getText());
	}

	public void waitToLoadPage(int seconds)
	{
		try {
			Thread.sleep(1000*seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
