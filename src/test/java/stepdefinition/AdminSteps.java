package stepdefinition;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

//import genericLibraries.ExcelUtility;
import genericLibraries.IConstantPath;
import genericLibraries.JavaUtility;
import genericLibraries.PropertiesUtility;
import genericLibraries.WebDriverUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomPages.AddNewCategoryPage;
import pomPages.AddNewCoursePage;
import pomPages.AddNewUserPage;
import pomPages.CategoryPage;
import pomPages.CourseListPage;
import pomPages.HomePage;
import pomPages.LoginPage;
import pomPages.UsersPage;
import pomPages.WelcomePage;

public class AdminSteps {
	//private ExcelUtility excel;
	private PropertiesUtility property;
	private WebDriverUtility webUtil;
	JavaUtility jutil;
	WebDriver driver;
	WelcomePage welcome;
	LoginPage login;
	HomePage home;
	UsersPage users;
	CourseListPage course;
	CategoryPage category;
	AddNewUserPage addUser;
	AddNewCategoryPage addCategory;
	AddNewCoursePage addCourse;
	String courseName;
	
	@Before(order = 1)
	public void configuration_set_up() {
		property = new PropertiesUtility();
		jutil = new JavaUtility();
		webUtil = new WebDriverUtility();
	
		property.propertiesInitialization(IConstantPath.PROPERTIES_PATH);
		
		driver = webUtil.launchBrowser(property.readFromProperties("browser"));
		webUtil.maximizeBrowser();
		webUtil.waitTillElementFound(Long.parseLong(property.readFromProperties("timeouts")));
	}
	
	@Before(order = 2)
	public void pom_configuration_setup() {
		welcome = new WelcomePage(driver);
		login = new LoginPage(driver);
		home = new HomePage(driver);
		users = new UsersPage(driver);
		course = new CourseListPage(driver);
		category = new CategoryPage(driver);
		addUser = new AddNewUserPage(driver);
		addCourse = new AddNewCoursePage(driver);
		addCategory = new AddNewCategoryPage(driver);
	}
	
	@Given("User navigates to skillrary")
	public void user_navigates_to_skillrary() {
	    webUtil.navigateToApp(property.readFromProperties("url"));
	    Assert.assertEquals(welcome.getPageHeader(), "SkillRary-ECommerce");
	}

	@When("User enters admin credentials")
	public void user_enters_admin_credentials() {
	    welcome.clickLoginButton();
	    Assert.assertEquals(login.getPageHeader(), "Login");
	    login.setUsernameTF(property.readFromProperties("username"));
	    login.setPasswordTF(property.readFromProperties("password"));
	    login.clickLoginButton();
	}

	@Then("User enters admin home page")
	public void user_enters_admin_home_page() {
		 Assert.assertEquals(home.getPageHeader(), "Home");
	}

	@Given("User clicks on Course list under courses")
	public void user_clicks_on_course_list_under_courses() {
	    home.clickCoursesLink();
	    home.clickCourseListLink();
	    Assert.assertTrue(course.getPageHeader().contains("Course List"));
	    
	}

	@When("User clicks on New and enters course details")
	public void user_clicks_on_new_and_enters_course_details(List<String> details) throws InterruptedException {
	    course.clickNewButton();
	    Thread.sleep(3000);
	    Assert.assertEquals(addCourse.getPageHeader(), "Add New Course");
	    courseName = details.get(0);
	    addCourse.setNameTF(details.get(0));
	    addCourse.selectCategory(webUtil, details.get(1));
	    addCourse.setPriceTF(details.get(2));
	    addCourse.setPhotoFilePath(details.get(3));
	    addCourse.setDescription(webUtil, details.get(4));
	}

	@When("saves it")
	public void saves_it() {
	    addCourse.clickSaveButton();
	}

	@Then("Course should be added to course list")
	public void it_should_be_added_to_course_list() {
	    course.clickUsersListLastPageLink();
	    Assert.assertEquals(course.getUserName(), courseName);
	}

	@When("User deletes the new course")
	public void user_deletes_the_new_course() {
	    course.clickDeleteButton();
	    course.clickDialogDeleteButton();
	}

	@Then("Delete success message is displayed and user logs out")
	public void delete_success_message_is_displayed_and_user_logs_out() {
	    home.signOutOfSkillrary();
	}

//	@Given("User clicks on Category list under courses")
//	public void user_clicks_on_category_list_under_courses() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User clicks on New and enters category details")
//	public void user_clicks_on_new_and_enters_category_details() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("Category should be created")
//	public void category_should_be_created() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("it should be added to category list")
//	public void it_should_be_added_to_category_list() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User deletes the new category")
//	public void user_deletes_the_new_category() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("User clicks on Users")
//	public void user_clicks_on_users() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User clicks on New and enters new user details")
//	public void user_clicks_on_new_and_enters_new_user_details() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("New User should be created")
//	public void new_user_should_be_created() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("it should be added to Users list")
//	public void it_should_be_added_to_users_list() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User deletes the new user")
//	public void user_deletes_the_new_user() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//	
	@After
	public void post_conditions() {
		webUtil.quitAllWindows();
	}

}
