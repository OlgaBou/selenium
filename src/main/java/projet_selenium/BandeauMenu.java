package projet_selenium;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BandeauMenu {

	public WebDriver driver;

	@FindBy(xpath = "//input[@type='text']")
	public WebElement search_field;

	@FindBy(xpath = "//div[@id='MenuContent']/a[contains(@href, 'signonForm')]")
	public WebElement signIn;
	
	@FindBy(xpath = "//img[@src='../images/logo-topbar.gif']")
	public WebElement logo;
	

	public PageLogin clickOnSignIn(WebDriver driver) {
		signIn.click();
		return PageFactory.initElements(driver, PageLogin.class);
	}

	public ResultatRecherche findDog(WebDriver driver) {
		//search_field.sendKeys("dog").submit();
		//search_field.submit();
		search_field.sendKeys("dog", Keys.ENTER);
		return PageFactory.initElements(driver, ResultatRecherche.class);
	}
	

	public PageAccueil returnToMainMenuLogo(WebDriver driver) {
		
		logo.click();
		return PageFactory.initElements(driver, PageAccueil.class);
	}
}
