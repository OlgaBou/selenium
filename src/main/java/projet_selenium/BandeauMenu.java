package projet_selenium;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BandeauMenu {
	
	@FindBy(xpath = "//input[@name='search']")
	public WebElement search_field;
	
	public ResultatRecherche findDog(WebDriver driver) {
		
		//search_field.sendKeys("dog", Keys.ENTER);
		search_field.sendKeys("dog");
		search_field.submit();
		return PageFactory.initElements(driver, ResultatRecherche.class);
	}
	

}
