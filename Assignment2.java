package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {
	public static void main(String[] args) throws InterruptedException {
		
		// Launch the URL https://html.com/tags/table/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// Get the count of number of rows
		List<WebElement> rows = driver.findElements(By.xpath("//table//tbody"));
		System.out.println("Number of rows in the table is "+rows.size());
		
		// Get the count of number of columns
		WebElement findElement = driver.findElement(By.xpath("(//table//tbody//tr)[1]"));
		List<WebElement> cols = findElement.findElements(By.tagName("td"));
		System.out.println("Number of columns in the table is "+cols.size());
		Thread.sleep(3000);
		driver.close();
	}
}