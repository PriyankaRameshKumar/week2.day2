package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/Link.html");
		driver.findElement(By.linkText("Go to Home Page")).click();
		
		Thread.sleep(2000);
		
		//To link page 
		driver.findElement(By.xpath("//h5[text()='HyperLink']/parent::a")).click();
		
		//get the link without clicking it
		String attribute = driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href");
		System.out.println(attribute);
		
		// to check if the link is broken
		String broken = driver.findElement(By.linkText("Verify am I broken?")).getAttribute("href");
		if(broken.contains("error"))
		{
			System.out.println(broken + " This link is broken");
		}
		else
		{
			System.out.println("This link is not broken");
		}
		
		//number of links in the page
		List<WebElement> links = driver.findElements(By.className("example"));
		System.out.println(links.size());
		

	}

}
