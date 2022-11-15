package practicising;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CommonUtils.TestBrowser;

public class paramst {
	WebDriver driver;
	
	
	@Parameters({"Browser"})

	@BeforeTest
	public void openBrowser(String Browser) {
		if(Browser.equals("Chrome")) {
			driver=TestBrowser.openChrome();
		}else {
			driver=TestBrowser.openFirefox();
		}
	
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	@Test
	public void bfrAft() {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
	}
	@AfterTest
	public void logout() throws InterruptedException {
		Thread.sleep(10000);
		driver.close();

	}
}
