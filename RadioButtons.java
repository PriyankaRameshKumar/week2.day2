package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/radio.html");
		driver.findElement(By.id("yes")).click();

		
		List <WebElement> checkbox = driver.findElements(By.xpath("//input[@name='news']"));
		System.out.println(checkbox.size());
		
		for(int i=0 ; i<checkbox.size() ; i++)
		{
		    WebElement checkboxoption = checkbox.get(i);
		    String chkboxText = driver.findElement(By.xpath("//input[@name='news']/parent::div")).getAttribute("linkText");
		   // String attribute = checkboxoption.getAttribute("innerHTML");
		    System.out.println(chkboxText);
			//WebElement checkboxEle = driver.findElement(By.xpath("//input[@name='news']"));
			
		}
		
		
	}

}
