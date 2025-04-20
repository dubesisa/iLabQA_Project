package test_Runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;

//Cucumber with serenity for reports
@RunWith(CucumberWithSerenity.class)
@CucumberOptions
        (features ="classpath:APITest.feature",
        glue =  {"step_Definition"},
                plugin = { "pretty", "json:target/cucumber-reports/testtwo.json",
                        "junit:target/cucumber-reports/testtwo.xml",
                        "html:target/cucumber-reports"},
        monochrome = true)
public class WebTestRunner
{
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );

    }
}
