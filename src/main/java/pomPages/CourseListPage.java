package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseListPage {

	@FindBy(xpath = "//h1[normalize-space(text())='Course List']")
	private WebElement pageHeader;

	@FindBy(xpath = "//a[text()=' New']")
	private WebElement newButton;

	@FindBy(xpath = "//table/tbody/tr[last()]/td[1]")
	private WebElement courseName;

	@FindBy(xpath = "//ul[@class='pagination']/li[last()-1]/a")
	private WebElement lastCourseListPageLink;

	@FindBy(xpath = "//table/tbody/tr[last()]/descendant::button[text()=' Delete']")
	private WebElement deleteButton;

	@FindBy(name = "delete")
	private WebElement dialogDeleteButton;
	
	public CourseListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public void clickNewButton() {
		newButton.click();
	}
	
	public void clickUsersListLastPageLink() {
		lastCourseListPageLink.click();
	}
	
	public String getUserName() {
		return courseName.getText();
	}
	
	public void clickDeleteButton() {
		deleteButton.click();
	}
	
	public void clickDialogDeleteButton() {
		dialogDeleteButton.click();
	}
}
