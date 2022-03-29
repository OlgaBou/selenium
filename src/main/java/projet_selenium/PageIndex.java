package projet_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageIndex extends BandeauMenu {
	
	public PageIndex(WebDriver driver) {

		super();
	}

	@FindBy (xpath="//a[@href='actions/Catalog.action']")
	public WebElement enterStore;
	
	public PageAccueil clickEnterButton(WebDriver driver) {
		enterStore.click();
		return PageFactory.initElements(driver, PageAccueil.class);
		}

}
