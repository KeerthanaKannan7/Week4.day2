package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/selectable.html");
		
		driver.manage().window().maximize();
		
		Actions builder = new Actions(driver);
		
		WebElement selectingItem1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		
		WebElement selectingItem3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		
		builder.clickAndHold(selectingItem1).moveToElement(selectingItem3).release().perform();
		
		WebElement selectingitem5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		
		WebElement selectingitem7 = driver.findElement(By.xpath("//li[text()='Item 7']"));
		
		builder.keyDown(Keys.CONTROL).click(selectingitem5).click(selectingitem7)
			.keyUp(Keys.CONTROL).perform();
	}

}
