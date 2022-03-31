package projet_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageTypeProduit extends BandeauMenu {
	
	public PageTypeProduit(WebDriver driver) {

		super(driver);
	}
	
	@FindBy(xpath = "//a[@href='/actions/Catalog.action?viewProduct=&productId=FI-SW-01']")
	public WebElement typeFish;
	
	@FindBy(xpath = "//div[@id='Catalog']/h2[.='Fish']")
	public WebElement titreFish;
	
	public PageProduit clickTypeFish(WebDriver driver) {
		typeFish.click();
		return PageFactory.initElements(driver, PageProduit.class);
	}
}
