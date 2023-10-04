package first;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
@Test
	
	public void TestGoogle() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("USD to INR exchange rate",Keys.ENTER);
		System.err.println(driver.getTitle());        
		String expectedTitle = "USD to INR exchange rate - Google Search";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
		Thread.sleep(5000);
		// Step 5: Find and print the exchange rate value
        WebElement exchangeRateElement = driver.findElement(By.xpath("//div[@Class='dDoNo ikb4Bb gsrt']"));
        String exchangeRate = exchangeRateElement.getText();
        System.out.println("Exchange Rate: " + exchangeRate);

		driver.quit();
	}
}
