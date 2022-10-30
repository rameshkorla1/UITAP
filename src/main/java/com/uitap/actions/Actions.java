package com.uitap.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions 
{
      public WebDriver driver;
      public Properties properties;
      
      public void init_Driver() throws IOException
      {
    	  properties = new Properties();
    	  String filePath = System.getProperty("user.dir")+"/resources/uitap.properties";
    	  FileInputStream fis = new FileInputStream(filePath);
    	  properties.load(fis);
    	  
    	  String browser = properties.getProperty("browser");
    	  
    	  if(browser.equals("chrome"))
    	  {
    		  WebDriverManager.chromedriver().setup();
    		  driver = new ChromeDriver();
    	  }
    	  else if(browser.equals("firefox"))
    	  {
    		  WebDriverManager.firefoxdriver().setup();
    		  driver = new FirefoxDriver();
    	  }
    	  else {
    		  System.out.println("Please pass the correct browset vlaue: "+browser);
    	  }
      }
      
    public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
  	{
  		TakesScreenshot ts = (TakesScreenshot)driver;
  		File source = ts.getScreenshotAs(OutputType.FILE);
  		File file = new File(System.getProperty("user.dir") + "//Reports//" + testCaseName + ".png");
  		FileUtils.copyFile(source, file);
  		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";	
  	}
    
    /**
     * Launching the Browser and Close the browser methods
     * @throws IOException 
     * */
    
    @BeforeMethod
    public void startApp() throws IOException
    {
    	init_Driver();
    	driver.get(properties.getProperty("AppUrl"));
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   	
    }
    
    @AfterMethod
    public void tearDown()
    {
    	driver.quit();
    }
}
