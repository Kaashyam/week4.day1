package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4LeafGroundTables {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Get the count of number of columns
		WebElement findElement = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/table/tbody/tr[2]"));
		List<WebElement> cols = findElement.findElements(By.tagName("td"));
		System.out.println("Number of columns in the table is "+cols.size());

		// Get the count of number of rows
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/table/tbody/tr"));
		System.out.println("Number of rows in the table is "+rows.size());

		// Get the progress value of 'Learn to interact with Elements'
		WebElement progress = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/table/tbody/tr[4]"));
		List<WebElement> progress1 = progress.findElements(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/table/tbody/tr[4]/td[2]"));
		System.out.println("Progress value of 'Learn to interact with Elements': "+progress1.get(0).getText());

		// Check the vital task for the least completed progress
		WebElement check = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/table/tbody/tr[6]"));
		WebElement check1 = check.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/table/tbody/tr[6]/td[3]"));
		((WebElement) check1).click();
		Thread.sleep(1000);
		driver.close();

	}
}
