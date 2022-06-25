package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable1 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/table.html ");
		
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Get the count of number of columns
		int column = driver.findElements(By.xpath("(//table//tr[2]/td)")).size();
		System.out.println("Number of columns: " + column);
		
		//Get the count of number of rows
		int row = driver.findElements(By.xpath("//table//tr")).size();
		System.out.println("Number of rows: " + row);
		
		//Get the progress value of 'Learn to interact with Elements'
		String value = driver.findElement(By.xpath("(//tbody//tr/td)[5]")).getText();
		System.out.println("Learn to interact with Elements: "+ value);
		
		//Check the vital task for the least completed progress.
		driver.findElement(By.xpath("(//tbody//tr/td)[15]")).click();
	}

}
