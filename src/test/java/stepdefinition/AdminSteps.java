package stepdefinition;

import org.openqa.selenium.WebDriver;

//import genericLibraries.ExcelUtility;
import genericLibraries.IConstantPath;
import genericLibraries.JavaUtility;
import genericLibraries.PropertiesUtility;
import genericLibraries.WebDriverUtility;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminSteps {
	//private ExcelUtility excel;
	private PropertiesUtility property;
	private WebDriverUtility webUtil;
	JavaUtility jutil;
	WebDriver driver;
	
	@Before
	public void configuration_set_up() {
		property = new PropertiesUtility();
		jutil = new JavaUtility();
		webUtil = new WebDriverUtility();
	
		property.propertiesInitialization(IConstantPath.PROPERTIES_PATH);
		
		driver = webUtil.launchBrowser(property.readFromProperties("browser"));
		webUtil.maximizeBrowser();
		webUtil.waitTillElementFound(Long.parseLong(property.readFromProperties("timeouts")));
	}
	
	@Given("User navigates to skillrary")
	public void user_navigates_to_skillrary() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User enters admin credentials")
	public void user_enters_admin_credentials() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User enters admin home page")
	public void user_enters_admin_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("User clicks on Course list under courses")
	public void user_clicks_on_course_list_under_courses() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User clicks on New and enters course details")
	public void user_clicks_on_new_and_enters_course_details() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("saves it")
	public void saves_it() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Course should be created")
	public void course_should_be_created() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("it should be added to course list")
	public void it_should_be_added_to_course_list() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User deletes the new course")
	public void user_deletes_the_new_course() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Delete success message is displayed and user logs out")
	public void delete_success_message_is_displayed_and_user_logs_out() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("User clicks on Category list under courses")
	public void user_clicks_on_category_list_under_courses() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User clicks on New and enters category details")
	public void user_clicks_on_new_and_enters_category_details() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Category should be created")
	public void category_should_be_created() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("it should be added to category list")
	public void it_should_be_added_to_category_list() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User deletes the new category")
	public void user_deletes_the_new_category() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("User clicks on Users")
	public void user_clicks_on_users() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User clicks on New and enters new user details")
	public void user_clicks_on_new_and_enters_new_user_details() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("New User should be created")
	public void new_user_should_be_created() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("it should be added to Users list")
	public void it_should_be_added_to_users_list() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User deletes the new user")
	public void user_deletes_the_new_user() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
