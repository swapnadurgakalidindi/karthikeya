package practicising;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Provider {
	WebDriver driver;
	//String url="https://demo.actitime.com/login.do";
	//String username="admin",password="manager";

	@DataProvider(name="selenium")
	public Object[][] myprovider()throws Exception{
		return new Object[][]
				{
			{"https://demo.actitime.com/login.do","admin","manager","swapn","swapdes"},
			{"https://demo.actitime.com/login.do","admin","manager","padma","padmdes"},
			{"https://demo.actitime.com/login.do","admin","manager","priya","priydes"}

				};
	}



	@Test(dataProvider="selenium")
	public void meterizatn(String url,String username,String password,String cusname,String description) throws Exception {
		Provider p1=new Provider();
		p1.openBrowser();
		p1.openActitime(url);
		p1.login(username,password);
		p1.createCustomer(cusname,description);
		p1.logout();

	}  
	public void createCustomer(String cusname,String description) throws Exception {
		findElement(By.id("container_tasks")).click();
		findElement(By.xpath("//div[text()='Add New']")).click();
		findElement(By.xpath("//div[text()='+ New Customer']")).click();
		findElement(By.xpath("(//input[@placeholder='Enter Customer Name'])[2]")).sendKeys(cusname);
		findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys(description);
		findElement(By.xpath("//div[text()='Create Customer']")).click();
		Thread.sleep(2000);
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
