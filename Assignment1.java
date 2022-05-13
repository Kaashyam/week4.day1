package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {
	public static void main(String[] args) throws InterruptedException {

		// Launch the URL https://www.chittorgarh.com/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Click on Stock Market
		driver.findElement(By.id("navbtn_stockmarket")).click();

		// Click on NSE bulk Deals
		driver.findElement(By .xpath("//*[@id=\"nav_stockmarket\"]/div/div/div[2]/a[2]")).click();

		// Get all the Security names
		System.out.println(driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/table/thead/tr/th[3]/a")).getText());
		List<WebElement> table = driver.findElements(By.xpath("//table[contains(@class, 'table-bordered table')]//td[3]"));
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < table.size(); i++) {
			list.add(table.get(i).getText());
			System.out.println(table.get(i).getText());
		}

		// Ensure whether there are duplicate security names
		Set<String> set = new HashSet<String>();
		for(int i = 0; i < list.size(); i++) {
			if(list.size() == set.size()) {
				System.out.println("The table does not have duplicate values");
			}
			else {
				System.out.println("The table has duplicate values");
				break;
			}
		}

		Thread.sleep(3000);
		driver.close();
	}
}
