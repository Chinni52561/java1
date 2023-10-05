package first;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class USD {
	    private WebDriver driver;

	    @BeforeTest
	    public void setUp() {
	        // Set the path to the ChromeDriver executable
	    	 WebDriverManager.chromedriver().setup();
		     driver = new ChromeDriver();
	    }

	    @Test
	    public void performGoogleSearch() {
	        // Step 2: Navigate to www.google.com
	        driver.get("https://www.google.com");

	        // Step 3: Enter text - USD to INR exchange rate
	        WebElement searchBox = driver.findElement(By.name("q"));
	        searchBox.sendKeys("USD to INR exchange rate");

	        // Step 4: Click on the search button
	        searchBox.submit();

	      
	     // Step 5: Find and print the exchange rate value
	        WebElement exchangeRateElement = driver.findElement(By.xpath("//div[@Class='dDoNo ikb4Bb gsrt']"));
	        String exchangeRate = exchangeRateElement.getText();
	        System.out.println("Exchange Rate: " + exchangeRate);

	        // Assertion: Check if the exchange rate is more than $80
	        /*Assert.assertTrue(exchangeRate > 80, "Exchange rate is not more than $80");

	        System.out.println("Exchange Rate: " + exchangeRate); */
	    }

	    @AfterTest
	    public void tearDown() {
	        // Step 6: Close the browser
	        driver.quit();
	    }
	}

