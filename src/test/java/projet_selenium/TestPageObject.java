package projet_selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;


public class TestPageObject {
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
		
		 
		
		wait = new WebDriverWait(driver, 15);
		driver.get("https://petstore.octoperf.com/");
		
		// instanciation de la pageIndex
		PageIndex page_index = PageFactory.initElements(driver,PageIndex.class);
		
		Logger.info("******Etap 1 - Affichage de la Page Index******");
		
		// appel de la méthode "clickEnterButto" --> instanciation de la PageAccueil
		PageAccueil page_accueil = page_index.clickEnterButton(driver);
		wait.until(ExpectedConditions.visibilityOf(page_accueil.mainMenu));
		
		Logger.info("******Etap 2 - Affichage de la Page Accueil******");
		
		// appel de la méthode "clickSingInButton" --> instanciation de la PageLogin
		PageLogin page_login = page_accueil.clickOnSignIn(driver);
		wait.until(ExpectedConditions.visibilityOf(page_login.username_field));
		
		Logger.info("******Etap 3 - Affichage de la Page Login******");
	
		// appel de la méthode "logIn"
		page_login.logIn(driver,"j2ee", "j2ee");
		
		wait.until(ExpectedConditions.visibilityOf(page_accueil.mainMenu));
		Logger.info("******Etap 4 - Affichage de la Page Accueil******");
		
		// appel de la méthode "chooseFishInMenu" --> instanciation de la PageFish
		PageTypeProduit page_type_produit = page_accueil.chooseFishInMenu(driver);
		
		Logger.info("******Etap 5 - Affichage de la Page Fish******");
		wait.until(ExpectedConditions.visibilityOf(page_type_produit.titreFish));
		//assertEquals("Fish", driver.findElement(By.xpath("//div[@id='Catalog']/h2[.='Fish']")).getText());
		
		// appel de la méthode "clickTypeFish" --> instanciation de la PageAngelFish
		PageProduit page_produit = page_type_produit.clickTypeFish(driver);
		
		Logger.info("******Etap 6 - Affichage de la Page AngelFish******");
		wait.until(ExpectedConditions.visibilityOf(page_produit.titreAngelFish));
		//assertEquals("Angelfish", driver.findElement(By.xpath("//div[@id='Catalog']/h2[.='Angelfish']")).getText());
		
		// appel de la méthode "clickAddToCart" --> instanciation de la PagePanier
		PagePanier page_panier = page_produit.clickAddToCart(driver);
		
		Logger.info("******Etap 7 - Affichage de la Page Panier******");
		assertEquals("Shopping Cart",
				driver.findElement(By.xpath("//div[@id='Cart']/h2[.='Shopping Cart']")).getText());
		
		// appel de la méthode "changeNumArticle"
		page_panier.changeNumArticle(driver, "2");
		
		assertEquals("2", driver.findElement(By.xpath("//input[@size='3']")).getAttribute("value"));
		
		// appel de la méthode "confirmChangeNumber"
		page_panier.confirmChangeNumber();
		
		// appel de la méthode "verifPrice"
		assertTrue(page_panier.verifPrice());
		
		page_accueil = page_panier.returnToMainMenu(driver);
		
		Logger.info("******Etap 8 - Affichage de la Page Accueil******");
		
		assertTrue((page_accueil.signOut).isDisplayed());
		
		Logger.info("Sign Out is displayed - " + (page_accueil.signOut).isDisplayed());
		
		assertTrue(page_accueil.welcome.isDisplayed());
		
		Logger.info("Text affiché sur la page d'accuei - " + (page_accueil.welcome).getText());
		
		MyAccount page_my_account = page_accueil.openMyAccount(driver);
		
		wait.until(ExpectedConditions.visibilityOf(page_my_account.titreUserInfo));
		
		Logger.info("Text affiché sur la page My Account - " + page_my_account.titreUserInfo.getText());
		
		page_my_account.chooseJapanese();
		
		Logger.info("Language affichée : " + page_my_account.choixLang.getAttribute("value"));
		
		
		page_my_account.chooseReptiles();
		
		Logger.info("Animal affiché : " + page_my_account.choixAnimal.getAttribute("value"));
		
		assertTrue(page_my_account.verifSelect());
		
		/*if(!page_my_account.enableMyList.isSelected())
			page_my_account.enableMyList.click();
		
		if(!page_my_account.enableMyBanner.isSelected())
			page_my_account.enableMyBanner.click();*/
		
		Logger.info("The checkbox My List selection state is - " + page_my_account.enableMyList.isSelected());
		assertTrue(page_my_account.enableMyList.isSelected());
		Logger.info("The checkbox My Banner selection state is - " + page_my_account.enableMyBanner.isSelected());
		assertTrue(page_my_account.enableMyBanner.isSelected());
		
		page_my_account.deselectCheckbox();
		
		Logger.info("The checkbox My List selection state is - " + page_my_account.enableMyList.isSelected());
		
		assertFalse(page_my_account.enableMyList.isSelected());
		
		page_my_account.returnToMainMenuLogo(driver);
		
		ResultatRecherche resultat_recherche = page_accueil.findDog(driver);
		
		resultat_recherche.countNumberRows();
		resultat_recherche.countNumberColumns();
		
		resultat_recherche.findCellINeed(2, 2);
		
		resultat_recherche.clickElem();
	}
	
}
