package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {

	@FindBy(xpath = "//h1[normalize-space(text())='Category']")
	private WebElement pageHeader;
	
	@FindBy(xpath = "//a[text()=' New']")
	private WebElement newButton;
	
	@FindBy(xpath = "//ul[@class='pagination']/li[last()-1]/a")
	private WebElement lastCategoryListPageLink;
	
	@FindBy(xpath = "//table/tbody/tr[last()]/td[1]")
	private WebElement categoryName;
	
	@FindBy(xpath = "//table/tbody/tr[last()]/descendant::button[text()=' Delete']")
	private WebElement deleteButton;

	@FindBy(name = "delete")
	private WebElement dialogDeleteButton;
	
	public CategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public void clickNewButton() {
		newButton.click();
	}
	
	public void clickUsersListLastPageLink() {
		lastCategoryListPageLink.click();
	}
	
	public String getUserName() {
		return categoryName.getText();
	}
	
	public void clickDeleteButton() {
		deleteButton.click();
	}
	
	public void clickDialogDeleteButton() {
		dialogDeleteButton.click();
	}

}
