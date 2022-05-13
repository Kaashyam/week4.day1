package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {
	public static void main(String[] args) throws InterruptedException {

		// Launch the URL https://html.com/tags/table/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Print the respective values
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"post-315\"]/div/div[2]/table/tbody"));
		for (int i = 0; i < rows.size(); i++) {
			System.out.println(rows.get(i).getText());
		}

		Thread.sleep(3000);
		driver.close();
	}

}
