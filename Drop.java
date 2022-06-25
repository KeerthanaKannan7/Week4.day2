package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drop {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/drop.html");
		
		driver.manage().window().maximize();
		
		WebElement source = driver.findElement(By.xpath("//div[@id = 'draggable']"));
		
		WebElement target = driver.findElement(By.xpath("//div[@id = 'droppable']"));
		
		Actions builder = new Actions(driver);
		
		builder.dragAndDrop(source, target).perform();
		
		String verification = driver.findElement(By.xpath("//div[@id = 'droppable']/p")).getText();
		System.out.println(verification);
		
	}

}
