package step_Definition;

import tests.API_Test;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features ="classpath:APITest.feature")
public class APIStep {

    @Steps
    API_Test userTest;
    @Given("^site -  (.*)")
    public void site_dog_api(String url) {
         userTest.dog_api(url);
    }


    @Then("^Perform an API request to produce a list of all dog breeds$")
    public void list_of_all_dog_breeds() {
        userTest.dog_breeds_list();

    }

    @Then("^Using code verify retriever breed is within the list$")
    public void retriever_breed_in_the_list() {
        userTest.retrieve_breed_in_list();

    }

    @Then("^Perform an API request to produce a list of sub-breeds for retriever$")
    public void list_of_sub_breeds_for_retriever() {
        userTest.list_of_sub_breeds_for_retriever();

    }

    @Then("^Perform an API request to produce a random image  link for the subbreed golden$")
    public void random_image_for_the_subbreed_golden() {
        userTest.random_image_for_subbreed_golden();

    }




}
