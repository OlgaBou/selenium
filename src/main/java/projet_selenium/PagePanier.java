package projet_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PagePanier extends BandeauMenu {



	public PagePanier(WebDriver driver) {

		super();
	}
	
	@FindBy(xpath = "//input[@size='3']")
	public WebElement numberArticle;
	
	@FindBy(xpath = "//input[@name='updateCartQuantities']")
	public WebElement updateCart;
	
	@FindBy(xpath = "//tr[2]/td[contains(.,'$')][1]")
	public WebElement priceOneArticleChamp;
	
	@FindBy(xpath = "//tr[2]/td[contains(.,'$')][2]")
	public WebElement priceTotalChamp;
	
	@FindBy(xpath = "//div[@id='BackLink']/a")
	public WebElement linkBackToMainMenu;
	
	
	public void changeNumArticle(WebDriver driver, String number) {
		numberArticle.clear();
		numberArticle.sendKeys("2");	
	}

	public void confirmChangeNumber() {
		updateCart.click();
		
	}

	public boolean verifPrice() {
		String prixUnitaire = priceOneArticleChamp.getText();
		String prixTotal = priceTotalChamp.getText();
		prixUnitaire = prixUnitaire.replace("$", "");
		prixTotal = prixTotal.replace("$", "");
		float prixUnitaire2 = Float.parseFloat(prixUnitaire);
		float prixTotal2 = Float.parseFloat(prixTotal);
		return (prixTotal2 == prixUnitaire2*2);
	
	}
	

	public PageAccueil returnToMainMenu(WebDriver driver) {
		
		linkBackToMainMenu.click();
		return PageFactory.initElements(driver, PageAccueil.class);
	}
}
