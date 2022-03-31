package projet_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAccueil extends BandeauMenu {

	public PageAccueil(WebDriver driver) {

		super(driver);
	}
	
	@FindBy(xpath = "//div[@id='MenuContent']/a[contains(@href, 'signoff')]")
	public WebElement signOut;
	
	@FindBy(xpath = "//div[@id='WelcomeContent' and contains(., 'ABC')]")
	public WebElement welcome;

	@FindBy(xpath = "//map[@name='estoremap']/area[@alt='Fish']")
	public WebElement optionFish;
	
	@FindBy(xpath = "//div[@id='MainImageContent']")
	public WebElement mainMenu;
	
	@FindBy(xpath = "//a[@href=\"/actions/Account.action?editAccountForm=\"]")
	public WebElement linkMyAccount;
	
	/*public PageLogin clickSingInButton(WebDriver driver) {
		signIn.click();
		return PageFactory.initElements(driver, PageLogin.class);
	}*/

	public PageTypeProduit chooseFishInMenu(WebDriver driver) {
		optionFish.click();
		return PageFactory.initElements(driver, PageTypeProduit.class);
	}
	
	public MyAccount openMyAccount(WebDriver driver) {
		
		linkMyAccount.click();
		return PageFactory.initElements(driver, MyAccount.class);
	}
}
