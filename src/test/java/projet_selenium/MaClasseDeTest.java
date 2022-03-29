package projet_selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class MaClasseDeTest {

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

	public void run() throws InterruptedException {

		wait = new WebDriverWait(driver, 15); // Explicit wait
		/*
		 * driver.get("https://latavernedutesteur.fr/");
		 * 
		 * String title = driver.getTitle();
		 * 
		 * assertEquals("La taverne du testeur", title);
		 */

		driver.get("https://petstore.octoperf.com/");

		assertEquals("JPetStore Demo", driver.getTitle());

		driver.findElement(By.xpath("//a[@href='actions/Catalog.action']")).click();

		if (driver.findElement(By.xpath("//div[@id='MenuContent']/a[contains(@href, 'signonForm')]")).isDisplayed()) {

			driver.findElement(By.xpath("//div[@id='MenuContent']/a[contains(@href, 'signonForm')]")).click();
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("j2ee");
			driver.findElement(By.xpath("//input[@name='password']")).clear();
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("j2ee");
			driver.findElement(By.xpath("//input[@name='signon']")).click();

		}

		driver.findElement(By.xpath("//div[@id='SidebarContent']/a[contains(@href, 'categoryId=FISH')]")).click();

		assertEquals("Fish", driver.findElement(By.xpath("//div[@id='Catalog']/h2[.='Fish']")).getText());

		/*
		 * String[] expected = {"Angelfish", "Tiger Shark", "Koi", "Goldfish"};
		 * List<WebElement> allOptions = driver.findElements(By.xpath("//td[2]"));
		 * 
		 * // make sure you found the right number of elements if (expected.length !=
		 * allOptions.size()) {
		 * System.out.println("fail, wrong number of elements found"); } // make sure
		 * that the value of every <option> element equals the expected value for (int i
		 * = 0; i < expected.length; i++) { String optionValue =
		 * allOptions.get(i).getAttribute("value"); if (optionValue.equals(expected[i]))
		 * { System.out.println("passed on: " + optionValue); } else {
		 * System.out.println("failed on: " + optionValue); } }
		 */

		driver.findElement(By.xpath("//a[@href=\"/actions/Catalog.action?viewProduct=&productId=FI-SW-01\"]")).click();
		assertEquals("Angelfish", driver.findElement(By.xpath("//div[@id=\"Catalog\"]/h2[.=\"Angelfish\"]")).getText());

		driver.findElement(By.xpath("//a[@href='/actions/Cart.action?addItemToCart=&workingItemId=EST-1']")).click();

		assertEquals("Shopping Cart",
				driver.findElement(By.xpath("//div[@id='Cart']/h2[.='Shopping Cart']")).getText());

		driver.findElement(By.xpath("//input[@size='3']")).clear();
		driver.findElement(By.xpath("//input[@size='3']")).sendKeys("2");

		assertEquals("2", driver.findElement(By.xpath("//input[@size='3']")).getAttribute("value"));

		driver.findElement(By.xpath("//input[@name='updateCartQuantities']")).click();

		assertEquals("$33.00", driver.findElement(By.xpath("//tr[2]/td[contains(.,'$')][2]")).getText());
	}

	@Test

	public void runWait() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit wait
		
		wait = new WebDriverWait(driver, 15); // Explicit wait

		driver.get("https://katalon-demo-cura.herokuapp.com/");
		
		driver.findElement(By.xpath("//h1[contains(.,'Healthcare Service')]")).isDisplayed();

		WebElement buttonAppointment = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Make Appointment')]"))); // Explicit wait

		buttonAppointment.click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)) //Fluent wait
				.pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);

		WebElement sendName = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//input[@name='username']"));

			}
		});

		sendName.sendKeys("John Doe");

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ThisIsNotAPassword");

		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		boolean verifTitre = driver.findElement(By.xpath("//h2[contains(.,'Make Appointment')]")).isDisplayed();

		assertTrue(verifTitre);
	}

}
