package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Priyanka");
		driver.findElement(By.id("lastNameField")).sendKeys("Ramesh Kumar");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Priyanka");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("RK");
		driver.findElement(By.name("departmentName")).sendKeys("Information Technology");
		driver.findElement(By.id("createContactForm_description")).sendKeys("This is the description text field");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("priyanka@gmail.com");
		
		WebElement createdd = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dd = new Select(createdd);
		dd.selectByValue("NY");
		driver.findElement(By.className("smallSubmit")).click();
		
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.xpath("//textarea[contains(@id,'importantNote')]")).sendKeys("This is note section");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);
	}

}
