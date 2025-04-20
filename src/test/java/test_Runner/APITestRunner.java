package test_Runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions
        (features ="classpath:WebTest.feature",
        glue =  {"step_Definition"},
                plugin = { "pretty", "json:target/cucumber-reports/testone.json",
                        "junit:target/cucumber-reports/testone.xml",
                        "html:target/cucumber-reports"},
        monochrome = true)
public class APITestRunner
{
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );

    }
}
