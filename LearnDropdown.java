package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnDropdown {
	public static void main(String[] args) {

		// Driver Setup
		WebDriverManager.chromedriver().setup();

		// Open a Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("http://leaftaps.com/opentaps/control/main");

		// Maximize the window
		driver.manage().window().maximize();

		// Timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Find the Web element for Username(by id)
		WebElement findElement = driver.findElement(By.id("username"));

		// Enter value in the field username
		findElement.sendKeys("Demosalesmanager");

		// Enter the password and login
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa", Keys.ENTER);

		// Find Web element for Login(by class) and click the button
		// driver.findElement(By.className("decorativeSubmit")).click();

		// Find the Web element CRM/SFA(by linkText) and click on the same
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Find web element Leads and click on the same
		driver.findElement(By.linkText("Leads")).click();

		// Find the Web element Create Lead and click on the same
		driver.findElement(By.linkText("Create Lead")).click();

		// Select a value from Source drop-down using sendKeys
		driver.findElement(By.id("createLeadForm_dataSourceId")).sendKeys("Partner");

		// Select a value from Marketing Campaign drop down using Select Class
		// 1. Find the web element
		WebElement dropDown = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		// 2. Access the Select Class
		Select select = new Select(dropDown);
		// 3. Select the value from the drop down
		select.selectByValue("CATRQ_AUTOMOBILE");

		// Get all options from Industry drop down
		WebElement industry = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select select1 = new Select(industry);
		List<WebElement> options = select1.getOptions();
		for (WebElement eachOption : options) {
			// System.out.println(eachOption); // This will print the web element
			System.out.println(eachOption.getText()); // This will print the text of the web element

			// Select the last option from Ownership drop down
			WebElement ownership = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
			Select select2 = new Select(ownership);
			List<WebElement> options2 = select2.getOptions();
			select2.selectByIndex(options2.size() - 1);

		}

	}
}