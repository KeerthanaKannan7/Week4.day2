package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		// Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");

		driver.manage().window().maximize();

		// Go to Mens Fashion
		WebElement mensFashion = driver.findElement(By.xpath("//span[contains(text(), 'Men')]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(mensFashion).perform();

		// Go to Sports Shoes
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();

		// Get the count of the sports shoes
		String count = driver.findElement(By.xpath("//div[@class='child-cat-count ']")).getText();
		System.out.println("Count of the sports shoes:" + count);

		// Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

		Thread.sleep(3000);
		// Sort by Low to High
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		WebElement sort = driver.findElement(By.xpath("//li[@class = 'search-li']"));
		builder.moveToElement(sort).click().perform();

		Thread.sleep(3000);

		// Check if the items displayed are sorted correctly
		List<WebElement> listOfItems = driver.findElements(By.xpath("//span[@class = 'lfloat product-price']"));
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < listOfItems.size(); i++) {
			String text = listOfItems.get(i).getText();
			System.out.println("Sorted: " + text);
			newList.add(text);
		}

		Thread.sleep(3000);
		// Select the price range (900-1200)
		WebElement fromValue = driver.findElement(By.xpath("//input[@name = 'fromVal']"));
		fromValue.clear();
		fromValue.sendKeys("900");
		WebElement toValue = driver.findElement(By.xpath("//input[@name = 'toVal']"));
		toValue.clear();
		toValue.sendKeys("1200");
		

		Thread.sleep(3000);
		// Filter with color Navy
		driver.findElement(By.xpath("(//button[text() = 'View More '])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label [@for = 'Color_s-Navy']")).click();

		Thread.sleep(3000);
		//verify the all applied filters
		String color = driver.findElement(By.xpath("(//a[contains(text(),'Navy')])[2]")).getText();
		System.out.println("Color filter: "+ color);
		String sortBy = driver.findElement(By.xpath("//div[@class = 'sort-selected']")).getText();
		System.out.println("Sort By filter: " + sortBy);
		
		Thread.sleep(3000);
		//Mouse Hover on first resulting Training shoes
		WebElement firstResult = driver.findElement(By.xpath("(//img[@class ='product-image wooble'])[1]"));
		builder.moveToElement(firstResult).perform();
		
		//click QuickView button
		driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]")).click();
		
		Thread.sleep(3000);
		//Print the cost and the discount percentage
		String cost = driver.findElement(By.xpath("//span[@class = 'payBlkBig']")).getText();
		System.out.println("Cost of the Shoe: " + cost);
		String discount = driver.findElement(By.xpath("//span[@class = 'percent-desc ']")).getText();
		System.out.println("Discount of the shoe: " + discount);
		
		//Take the snapshot of the shoes
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		File saveScreenshot = new File ("Snapdeal.png");
		FileUtils.copyFile(screenshot, saveScreenshot);
		
		//Close the current window
		driver.close();
		
		//Close the main window
		driver.quit();
	}

}
