package practicising;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class staticparamtrzn {
	static WebDriver driver;
	String url="https://demo.actitime.com/login.do";
	String username="admin",password="manager";
	
	
  @Test
  public void meterizatn() throws Exception {
	  staticparamtrzn p1=new staticparamtrzn();
	  staticparamtrzn.openBrowser();
	  staticparamtrzn.openActitime(url);
	  staticparamtrzn.login(username,password);
	  staticparamtrzn.logout();
	  
	  
  }  
	  public static void logout() {
	driver.close();
	
}
	public static void openBrowser() {
		  System.setProperty("webdriver.chrome.driver", ".\\src\\test\\java\\Drivers\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize(); 
	  }
	  public static void openActitime(String url) {
		  driver.get(url);
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

	  }
	  public static void login(String username,String password) throws Exception {
		  findElement(By.id("username")).sendKeys(username);
		  findElement(By.name("pwd")).sendKeys(password);
		  findElement(By.xpath("//div[text()='Login ']")).click();
	  }
	  
  
  public static WebElement findElement(By by)throws Exception{
	  WebElement elem=driver.findElement(by);
	  if(driver instanceof JavascriptExecutor) {
		 (( JavascriptExecutor)driver).executeScript("arguments[0].style.border='2px solid red'", elem);
		 }return elem;
		 
  }
}
