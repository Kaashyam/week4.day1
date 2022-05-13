package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnTables {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MDU", Keys.TAB, Keys.TAB);
		driver.findElement(By.id("txtStationTo")).sendKeys("TPJ", Keys.TAB);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		WebElement header = driver.findElement(By.xpath("//table[@class='DataTable DataTableHeader TrainList TrainListHeader']"));
		System.out.println(header.findElement(By.xpath("//*[@id=\"divTrainsListHeader\"]/table/tbody/tr/td[2]/a")).getText());
		WebElement elementTable = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));
		List<WebElement> rows = elementTable.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
		for (int i = 1; i < rows.size(); i++) { 
		List<WebElement> cols = rows.get(i).findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr//td[2]"));
		System.out.println(cols.get(i).getText()); 
		}
	}
}
