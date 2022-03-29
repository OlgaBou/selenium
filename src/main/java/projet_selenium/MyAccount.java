package projet_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MyAccount extends BandeauMenu {

	
	public MyAccount(WebDriver driver) {

		super();
	}
	
	@FindBy(xpath = "//h3[contains(.,'User Information')]")
	public WebElement titreUserInfo;
	
	@FindBy(xpath = "//select[@name='account.languagePreference']")
	public WebElement choixLang;
	
	@FindBy(xpath = "//select[@name='account.favouriteCategoryId']")
	public WebElement choixAnimal;
	
	@FindBy(xpath = "//input[@name='account.listOption']")
	public WebElement enableMyList;
	
	@FindBy(xpath = "//input[@name='account.bannerOption']")
	public WebElement enableMyBanner;
	
	
	
	public void chooseJapanese() {
		Select language = new Select(choixLang);
		language.selectByVisibleText("japanese");
		
	}
	
	public void chooseReptiles() {
		Select animal = new Select(choixAnimal);
		animal.selectByValue("REPTILES");
		
	}
	
	public void deselectCheckbox() {
		if(enableMyList.isSelected())
			enableMyList.click();
	}
}
