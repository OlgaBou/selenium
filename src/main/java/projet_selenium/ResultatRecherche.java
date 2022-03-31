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
		super(driver);
	}


	@FindBy(xpath = "//div[@id='Catalog']/table")
	public WebElement resultat;

	@FindBy(xpath = "//div[@id='Catalog']/table/tbody/tr[2]/td")
	public List<WebElement> rows;

	@FindBy(xpath = "//div[@id='Catalog']/table/tbody/tr[1]/th")
	public List<WebElement> columns;

	@FindBy(xpath = "//a[@href='/actions/Catalog.action?viewProduct=&productId=K9-BD-01']")
	public WebElement productId;
	
	
	WebElement cellIWant;

	/*public void countNumberRows() {
		List<WebElement> rowsNumber = rows;
		int rowCount = rowsNumber.size();
		System.out.println("No of rows in this table : " + rowCount);
	}


	public void countNumberColumns() {
		List<WebElement> columnsNumber = columns;
		int columnCount = columnsNumber.size();
		System.out.println("No of columns in this table : " + columnCount);
	}*/

	public int retournerNumeroDeLigne(String s){
		int ligneCourante = 1;
		List<WebElement> l_lignes = driver.findElements(By.xpath("//table/tbody/tr"));
		for(WebElement ligne : l_lignes){
			List<WebElement> l_cell = ligne.findElements(By.xpath("td"));
			for(WebElement cell:l_cell){
				if(cell.getText().equals(s)){

					return ligneCourante;

				}
			}
			System.out.println(ligneCourante);
			ligneCourante++;

		}
		return -1;


	}


	public WebElement findCellINeed(int col, String s) {
		System.out.println("inside findCellINeed : " + s);
		int numRow = retournerNumeroDeLigne(s);
		WebElement cellIWant = driver.findElement(By.xpath("//table/tbody/tr["+numRow+"]/td["+col+"]"+"/b/a"));//table/tbody/tr[2]/td[2]/b/a
		//WebElement cellIWant = this.driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/b/a"));
		System.out.println("cellIWant : " + cellIWant);
		//cellIWant.click();
		return cellIWant;

	}


	public PageProduit clickElem(int col, String s) {
		// TODO Auto-generated method stub
		WebElement cellule = findCellINeed(col, s);
		cellule.click();
		return PageFactory.initElements(driver, PageProduit.class);
}

	
	/*public boolean verifPage(WebElement x) {
		boolean verif;
		if (x.isDisplayed()) {
			verif = true;
		} else {
			verif = false;
		}
		return verif;
	}*/
}


/*//WebElement cellIneed = driver.findElement(By.xpath(("//table/tbody/tr[2]/td[2]")+"/b/a"));
		//cellIneed.click();

 */

