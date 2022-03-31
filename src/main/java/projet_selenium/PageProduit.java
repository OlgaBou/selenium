package projet_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageProduit extends BandeauMenu {
	
	public PageProduit(WebDriver driver) {

		super(driver);
	}
	
	@FindBy(xpath = "//a[@href='/actions/Cart.action?addItemToCart=&workingItemId=EST-1']")
	public WebElement addToCart;
	
	@FindBy(xpath = "//div[@id='Catalog']/h2[.='Angelfish']")
	public WebElement titreAngelFish;
	
	@FindBy(xpath = "//div[@id='Catalog']/h2[.='Bulldog']")
	public WebElement titreBulldog;
	
	public PagePanier clickAddToCart(WebDriver driver) {
	
		addToCart.click();
		return PageFactory.initElements(driver, PagePanier.class);
	}

}
