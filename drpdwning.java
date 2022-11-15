package practicising;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import CommonUtils.TestBrowser;

public class drpdwning {
	WebDriver driver;
	
  @Test
  public void Ddrop() throws InterruptedException {
	  driver=TestBrowser.openChrome();
	  driver.get("https://krninformatix.com/sample.html");
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  
	 // Select dd=new Select(driver.findElement(By.id("city")));
	 // dd.selectByIndex(3);
	  
	  Select dd=new Select(driver.findElement(By.id("cities")));
	  dd.selectByVisibleText("Mumbai");
	  dd.selectByIndex(0);
	  dd.selectByValue("2");
	  Thread.sleep(3000);
	  dd.deselectAll();
	  
  }
}
