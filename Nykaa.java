package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		// Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");

		driver.manage().window().maximize();

		// Mouse hover on Brands and Search L'Oreal Paris
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brands).perform();
		driver.findElement(By.xpath("//input[@id = 'brandSearchBox']")).sendKeys("L'Oreal Paris");

		// Click L'Oreal Paris
		driver.findElement(By.xpath("//div[@class = 'css-ov2o3v']/a")).click();

		// Check the title contains L'Oreal Paris
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		if (title.contains("L'Oreal Paris")) {
			System.out.println("Verifying title: Title contains L'Oreal Paris");
		} else {
			System.out.println("Verifying title: Title does not contains L'Oreal Paris");
		}

		// Click sort By and select customer top rated
		driver.findElement(By.xpath("//span[@class = 'sort-name']")).click();
		driver.findElement(By.xpath("//span[text() = 'customer top rated']")).click();

		// Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[text() = 'Category']")).click();
		driver.findElement(By.xpath("//span[text() = 'Hair']")).click();
		driver.findElement(By.xpath("//span[text() = 'Hair Care']")).click();
		driver.findElement(By.xpath("//span[text() = 'Shampoo']")).click();

		// Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text() = 'Concern']")).click();
		driver.findElement(By.xpath("//span[text() = 'Color Protection']")).click();

		// check whether the Filter is applied with Shampoo
		String filterValue = driver.findElement(By.xpath("//span[text() = 'Shampoo']")).getText();
		if (filterValue.contains("Shampoo")) {
			System.out.println("Verifying filter: Filter contains Shampoo");
		} else {
			System.out.println("Verifying filter: Filter does not contains Shampoo");
		}

		// Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[contains (text(), 'Colour Protect Shampoo')]")).click();

		// GO to the new window and select size as 175ml
		Set<String> windowInSet = driver.getWindowHandles();
		List<String> windowInList = new ArrayList<String>(windowInSet);
		driver.switchTo().window(windowInList.get(1));

		WebElement size = driver.findElement(By.xpath("//select[@title = 'SIZE']"));
		Select option = new Select(size);
		option.selectByValue("1");

		// Print the MRP of the product
		String findElement = driver.findElement(By.xpath("//span [@class = 'css-1jczs19']")).getText();
		System.out.println("MRP: " + findElement);

		// Click on ADD to BAG
		driver.findElement(By.xpath("//span[text() = 'Add to Bag']")).click();

		// Go to Shopping Bag
		driver.findElement(By.xpath("//div[@class='css-0 e1ewpqpu1']/button")).click();

		// Print the Grand Total amount
		String grandTotal = driver.findElement(By.className("first-col")).getText();
		System.out.println(grandTotal);

		// Click Proceed
		driver.findElement(By.xpath("//span[contains (text(), 'Proceed')]")).click();

		// Click on Continue as Guest
		driver.findElement(By.xpath("//button[@class = 'btn full big']")).click();

		// Check if this grand total is the same in step 14
		String grandTotal1 = driver.findElement(By.xpath("(//div[@class = 'value'])[2]")).getText();
		System.out.println(grandTotal1);

		if (grandTotal == grandTotal1) {
			System.out.println("Verification of Grand Total: Both are equal");
		} else {
			System.out.println("Verification of Grand Total: Both are not equal");
		}

		// Close all windows
		driver.quit();
	}

}
