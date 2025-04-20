package Utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertNotNull;

public class GlobalFunction {

    WebDriver driver;


    public GlobalFunction(String url)
    {

        this.driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        assertNotNull(driver);
        //dedicated site
        driver.get(url);
        driver.manage().window().maximize();
    }


}
