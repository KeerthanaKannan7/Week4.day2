package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizeable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		//launching URL
		driver.get("https://jqueryui.com/resizable");
		
		//Maximising the window
		driver.manage().window().maximize();
		
		//Implicit wait time 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Switching to respective window
		driver.switchTo().frame(0);
		
		//identifying the drag point using xpath
		WebElement ele = driver.findElement(By.xpath("//div[@id = 'resizable']/div[3]"));
		
		//Action class to perform the drag and drop
		Actions builder = new Actions (driver);
		
		//performing drag and drop
		builder.dragAndDropBy(ele, 100, 100).perform();
	}

}
