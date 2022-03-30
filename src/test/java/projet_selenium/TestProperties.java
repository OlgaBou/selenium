package projet_selenium;

import java.io.FileInputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

public class TestProperties {
	static org.slf4j.Logger Logger= LoggerFactory.getLogger(TestPageObject.class);

	WebDriver driver;
	WebDriverWait wait;

	@Before

	public void setup() {
		/*
		 * String browser = System.getProperty("Navigateur"); // String browser = ""; if
		 * (browser.equalsIgnoreCase("firefox")) {
		 * System.setProperty("webdriver.gecko.driver",
		 * "src/main/resources/driver/geckodriver.exe"); driver = new FirefoxDriver(); }
		 * 
		 * else if (browser.equalsIgnoreCase("chrome")) {
		 * System.setProperty("webdriver.chrome.driver",
		 * "src/main/resources/driver/chromedriver.exe"); driver = new ChromeDriver(); }
		 * 
		 * else if(browser.equalsIgnoreCase("edge")){
		 * System.setProperty("webdriver.edge.driver",
		 * "src/main/resources/driver/msedgedriver.exe"); driver = new EdgeDriver();
		 * 
		 * } else { System.setProperty("webdriver.chrome.driver",
		 * "src/main/resources/driver/chromedriver.exe"); driver = new ChromeDriver(); }
		 */

		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@After

	public void teardown() {
		driver.quit();
	}

	@Test
	
	public void testPageObj() throws Exception {
		
		Properties propertyJDD = new Properties();
	    propertyJDD.load(new FileInputStream("C:\\Users\\formation\\eclipse-workspace\\projet_selenium\\src\\main\\resources\\jdd\\jdd.properties"));

	    driver.get(propertyJDD.getProperty("link"));
	    WebElement recherche = driver.findElement(By.xpath("//input[@type='"+ propertyJDD.getProperty("type") +"']"));
	        recherche.sendKeys(propertyJDD.getProperty("words"));
	        recherche.submit();
	}
	}