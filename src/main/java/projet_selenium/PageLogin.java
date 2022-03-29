package projet_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin extends BandeauMenu {

	@FindBy(xpath = "//input[@name='username']")
	public WebElement username_field;
	@FindBy(xpath = "//input[@name='password']")
	public WebElement password_field;
	@FindBy(xpath = "//input[@name='signon']")
	public WebElement submit_button;

	public PageAccueil logIn(WebDriver driver, String username, String password) {
		username_field.clear();
		username_field.sendKeys("j2ee");
		password_field.clear();
		password_field.sendKeys("j2ee");
		submit_button.click();
		return PageFactory.initElements(driver, PageAccueil.class);

	}
}
