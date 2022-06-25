package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/sortable.html");

		driver.manage().window().maximize();

		WebElement item6 = driver.findElement(By.xpath("//li[text() = 'Item 6']"));

		WebElement item2 = driver.findElement(By.xpath("//li[text() = 'Item 2']"));

		Actions builder = new Actions(driver);

		builder.clickAndHold().dragAndDrop(item6, item2).release().perform();

		driver.close();
	}

}
