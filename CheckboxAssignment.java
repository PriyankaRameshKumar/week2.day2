package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//confirm if the checkbox is selected
		driver.get("http://www.leafground.com/pages/checkbox.html");
		boolean confirm = driver.findElement(By.xpath("//label[contains(text(),'Confirm')]/following-sibling::input")).isSelected();
		System.out.println(confirm);
		
		//Deselect the selected checkbox
		List<WebElement> findElements = driver.findElements(By.xpath("//label[contains(text(),'DeSelect')]/following-sibling::input"));
		for(int i = 0 ; i<findElements.size() ; i++)
		{
			WebElement Deselect = findElements.get(i);
			if(Deselect.isSelected())
			{
				Deselect.click();
				System.out.println("The selected link is deselected");
			}
		}
		
		//select all the checkboxes
		List<WebElement> selectAll = driver.findElements(By.xpath("//label[contains(text(),'all')]/following-sibling::input"));
		for(int i=0 ; i<selectAll.size() ; i++)
		{
			WebElement AllOptions = selectAll.get(i);
			AllOptions.click();
		}

	}

}
