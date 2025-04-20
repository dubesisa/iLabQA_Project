package step_Definition;

import tests.Web_Test;
import cucumber.api.DataTable;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.cucumber.CucumberWithSerenity;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features ="classpath:WebTest.feature")
public class WebStep {

    @Steps
    private
    Web_Test userTest;
    @Given("^Navigate to - (.*)$")
    public void navigate_to_website(String url) {
        userTest.navigate_to_website(url);
    }

    @Then("^Validate that you are on the User List Table$")
    public void validate_user_list_table() {
        userTest.validate_user_list_table();
    }

    @Then("^Click Add user$")
    public void click_Add_user() {

        userTest.click_Add_user();
    }

    @Then("^Add users with the following details:$")
    public void add_users_details() {

        userTest.add_users_details();
    }

    @Then("^Ensure that User Name is unique on each run$")
    public void verify_username_unique(DataTable dataTable ) {


        userTest.verify_unique_username( dataTable);
    }

    @Then("^Ensure that your users are added to the list$")
    public void added_user_list() {
        userTest.user_added_to_list();
    }


}
