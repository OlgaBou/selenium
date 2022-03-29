package projet_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultatRecherche extends BandeauMenu {
	
	public ResultatRecherche(WebDriver driver) {

		super();
	}
	

	@FindBy(xpath = "//div[@id='Catalog']/table")
	public WebElement resultat;
	
	@FindBy(xpath = "//a[@href='/actions/Catalog.action?viewProduct=&productId=K9-BD-01']")
	public WebElement productId;
	
}
