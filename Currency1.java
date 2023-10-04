package first;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class Currency1{
		 private WebDriver driver;
	 @BeforeTest
		    public void setThePath()
		    {	
		     System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
	            // step 1:open the  browser
	        
	        ChromeDriver driver = new ChromeDriver();
		        
		    
	      //maximize the browser
			driver.manage().window().maximize();
			//add implicit wait

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		    }
		    
	 @Test
		     public void open() {
	        // Step 2: Navigate to www.google.com
	        driver.get("https://www.google.com");

	        // Step 3: Enter text - USD to INR exchange rate and click on search
	        WebElement searchBox = driver.findElement(By.name("q"));
	        searchBox.sendKeys("USD to INR exchange rate",Keys.ENTER);
	        //Assert statement
	        System.err.println(driver.getTitle());        
			String expectedTitle = "USD to INR exchange rate - Google Search";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle,expectedTitle);
			

	        // Step 4: Read the exchange rupee value and print it in the console
	        WebElement result = driver.findElement(By.xpath("//div[@Class='dDoNo ikb4Bb gsrt']"));
	        String exchangeRate = result.getText();
	        System.out.println("Exchange Rate: " + exchangeRate);
			 }
			 
	 @AfterTest
			    public void close_browser() {
			        // Step 6: Close the browser
			        driver.quit();
			    }
	    }
