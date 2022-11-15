package practicising;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Tagging {
	WebDriver driver;
	
  @Test
  public void astLocatr() {
	  System.setProperty("webdriver.chrome.driver", ".\\src\\test\\java\\Drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize(); 
	  driver.get("https://demo.actitime.com/login.do");
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  
	 List<WebElement>links= driver.findElements(By.tagName("a"));
	 int count=links.size();
	  System.out.println(count);
	  
	  for(WebElement link:links) {
		  String str=link.getText();
		  System.out.println(str);
		  
	  }
	  
	  
	  
	  
	  
  }
}
