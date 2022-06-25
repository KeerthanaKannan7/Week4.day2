package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		////launching URL
		driver.get("http://www.leafground.com/pages/drag.html");
		
		//Maximising the window
		driver.manage().window().maximize();
		
		//identifying element which going to drag
		WebElement source = driver.findElement(By.xpath("//div[@id = 'draggable']"));
		
		//identifying element which going to drop
		WebElement target = driver.findElement(By.xpath("//div[@id = 'mydiv']"));
		
		//Action class to perform the drag and drop
		Actions builder = new Actions(driver);
		
		//Dragging and dropping the identified elements
		builder.dragAndDrop(source, target).perform();

	}

}
