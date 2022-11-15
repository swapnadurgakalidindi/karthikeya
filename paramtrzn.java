package practicising;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class paramtrzn {
	WebDriver driver;
	String url="https://demo.actitime.com/login.do";
	String username="admin",password="manager";
	
	
  @Test
  public void meterizatn() throws Exception {
	  paramtrzn p1=new paramtrzn();
	  p1.openBrowser();
	  p1.openActitime(url);
	  p1.login(username,password);
	  p1.logout();
	  
	  
  }  
	  public void logout() {
	driver.close();
	
}
	public void openBrowser() {
		  System.setProperty("webdriver.chrome.driver", ".\\src\\test\\java\\Drivers\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize(); 
	  }
	  public void openActitime(String url) {
		  driver.get(url);
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

	  }
	  public void login(String username,String password) throws Exception {
		  findElement(By.id("username")).sendKeys(username);
		  findElement(By.name("pwd")).sendKeys(password);
		  findElement(By.xpath("//div[text()='Login ']")).click();
	  }
	  
  
  public WebElement findElement(By by)throws Exception{
	  WebElement elem=driver.findElement(by);
	  if(driver instanceof JavascriptExecutor) {
		 (( JavascriptExecutor)driver).executeScript("arguments[0].style.border='2px solid red'", elem);
		 }return elem;
		 
  }
}
