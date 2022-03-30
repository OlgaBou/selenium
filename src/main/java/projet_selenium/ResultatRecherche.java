package projet_selenium;

import java.util.List;

import javax.swing.text.TableView.TableCell;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultatRecherche extends BandeauMenu {
	
	
	public ResultatRecherche(WebDriver driver) {

		super();
	}
	

	@FindBy(xpath = "//div[@id='Catalog']/table")
	public WebElement resultat;
	
	@FindBy(xpath = "//div[@id='Catalog']/table/tbody/tr[2]/td")
	public List<WebElement> rows;
	
	@FindBy(xpath = "//div[@id='Catalog']/table/tbody/tr[1]/th")
	public List<WebElement> columns;
	
	@FindBy(xpath = "//a[@href='/actions/Catalog.action?viewProduct=&productId=K9-BD-01']")
	public WebElement productId;
	
	
	public void countNumberRows() {
		List<WebElement> rowsNumber = rows;
		int rowCount = rowsNumber.size();
		System.out.println("No of rows in this table : " + rowCount);
	}
	
	
	public void countNumberColumns() {
		List<WebElement> columnsNumber = columns;
		int columnCount = columnsNumber.size();
		System.out.println("No of columns in this table : " + columnCount);
	}

	public WebElement findCellINeed(int row, int col) {
		
		WebElement cellIWant = driver.findElement(By.xpath("/table/tbody/tr["+row+"]/td["+col+"]"+"/b/a"));
		
		return cellIWant;
		
	}


	public void clickElem() {
		// TODO Auto-generated method stub
		WebElement cellule = findCellINeed(2, 2);
		cellule.getText();
		cellule.click();

	}

		

	}	
	/*//WebElement cellIneed = driver.findElement(By.xpath(("//table/tbody/tr[2]/td[2]")+"/b/a"));
		//cellIneed.click();
	
		*/

