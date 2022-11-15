package practicising;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Provider2 {



	WebDriver driver;
	//String url="https://demo.actitime.com/login.do";
	//String username="admin",password="manager";
	
	@DataProvider(name="selenium")
	public Object[][] myprovider()throws Exception{
		return new Object[][]
		{
			{"https://demo.actitime.com/login.do","admin","manager","swapn"},
			{"https://demo.actitime.com/login.do","admin","manager","padma"},
			{"https://demo.actitime.com/login.do","admin","manager","priya"}
			
		};
	}
	
	@DataProvider(name="selenium1")
	public Object[][] mydata()throws Exception{
		Object data[][]=new Object[3][5] ;
			data[0][0]="https://demo.actitime.com/login.do";
		    data[0][1]="admin";
		    data[0][2]="manager";
		    data[0][3]="hema";
		    data[0][4]="nnmxs";
		    
		    data[1][0]="https://demo.actitime.com/login.do";
		    data[1][1]="admin";
		    data[1][2]="manager";
		    data[1][3]="mukku";
		    data[1][4]="hejjma";
		    
		    data[2][0]="https://demo.actitime.com/login.do";
		    data[2][1]="admin";
		    data[2][2]="manager";
		    data[2][3]="rushi";
		    data[2][4]="lklkl";
		    return data;
		
	}
	

	
	
  @Test(dataProvider="selenium1")
  public void meterizatn(String url,String username,String password,String cusname,String descrp) throws Exception {
	  Provider2 p1=new Provider2();
	  p1.openBrowser();
	  p1.openActitime(url);
	  p1.login(username,password);
	  p1.createCustomer(cusname,descrp);
	  p1.logout();
	  
  }  
	  public void createCustomer(String cusname,String descrp) throws Exception {
	findElement(By.id("container_tasks")).click();
	findElement(By.xpath("//div[text()='Add New']")).click();
	findElement(By.xpath("//div[text()='+ New Customer']")).click();
	findElement(By.xpath("(//input[@placeholder='Enter Customer Name'])[2]")).sendKeys(cusname);
	findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys(descrp);
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
