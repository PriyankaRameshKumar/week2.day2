package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).clear();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		String lead1 = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).getText();
		System.out.println(lead1);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
		
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		Thread.sleep(1000);
		System.out.println(lead1);
		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//label[text()='Lead ID:']/parent::div//input")).sendKeys(lead1);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(1000);
		String text = driver.findElement(By.className("x-paging-info")).getText();
		System.out.println(text);
		
		if(text.contains("No records to display")) {
			System.out.println("The Lead is deleted successfully"); 
			} 
		else {
				System.out.println("The Lead is not deleted"); 
				}
		driver.close();
		 
		
		
	}

}
