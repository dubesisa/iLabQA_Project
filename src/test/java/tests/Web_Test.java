package tests;

import Utilities.User;
import cucumber.api.DataTable;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.*;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Web_Test {


    private WebDriver driver;
    private String FirstName = null;
    private List<String> dataList = new ArrayList<>();
    Map<String, String> userData = null;

    @Step


    public void navigate_to_website(String url) {


        //initialize driver
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        assertNotNull(driver);
        //dedicated site
        driver.get(url);
        driver.manage().window().maximize();


    }


    public void validate_user_list_table() {

        String columnName = driver.findElement(By.xpath("/html/body/table/thead/tr[3]/th[1]/span")).getText();
        System.out.println("Validate Page:" + columnName);

        assertEquals("First Name", columnName);
    }

    public void click_Add_user() {
    }

    public void add_users_details() {
    }

    public void verify_unique_username(DataTable dataTable) {
        //convert datatable to object list
        List<User> userData = dataTable.asList(User.class);

        for (User userInfo : userData) {
            //add new user btn
            driver.findElement(By.xpath("html/body/table/thead/tr[2]/td/button")
            ).click();


            driver.switchTo().activeElement();
            String modaltext = driver.findElement(By.xpath("//h3[contains(text(),'Add User')]")).getText();
            System.out.println("Page Modal text : " + modaltext);
            assertEquals("Add User", modaltext);

            //First name
            FirstName = userInfo.getFirstName();
            System.out.println("Name :" + FirstName);
            dataList.add(FirstName);

            WebElement elem = null;

            // First Name
            elem = driver.findElement(By.xpath("//input[@name='FirstName']"));
            elem.clear();
            elem.sendKeys(FirstName);

            //last Name
            elem = driver.findElement(By.xpath("//input[@name='LastName']"));
            elem.clear();
            elem.sendKeys(userInfo.getLastName());

            //username
            elem = driver.findElement(By.xpath("//input[@name='UserName']"));
            elem.clear();
            elem.sendKeys(userInfo.getUsername());

            //password
            elem = driver.findElement(By.xpath("//input[@name='Password']"));
            elem.clear();
            elem.sendKeys(userInfo.getPassword());

            //Customer
            if (userInfo.getCustomerType().equals("Company AAA")) {
                System.out.println("AAA :" + userInfo.getCustomerType());

                elem = driver.findElement(By.xpath("//label[contains(.,'\n" + "Company AAA')]"));
                elem.click();
            } else {
                System.out.println("BBB :" + userInfo.getCustomerType());

                elem = driver.findElement(By.xpath("//label[contains(.,'\n" + "Company BBB')]"));
                elem.click();
            }

            //role
            Select gender = new Select(driver.findElement(By.xpath("//select[@name='RoleId']")));
            gender.selectByVisibleText(userInfo.getRole());

            //E-mail
            elem = driver.findElement(By.xpath("//input[@name='Email']"));
            elem.clear();
            elem.sendKeys(userInfo.getEmail());
            //cellphone
            elem = driver.findElement(By.xpath("//input[@name='Mobilephone']"));
            elem.clear();
            elem.sendKeys(userInfo.getCell());

            //save btn
            elem = driver.findElement(By.xpath("//input[@name='Mobilephone']"));
            elem.click();

            driver.switchTo().defaultContent();


        }


    }

    public void user_added_to_list() {
        //verify the user entered are all in the  table
        System.out.println("Data Count :" + dataList.size());
        for (int i = 0; i < dataList.size(); i++) {
            System.out.println("iteration NO :" + i);
            String getName = driver.findElement(By.xpath("/html/body/table/tbody/tr[" + (i + 1) + "]/td[1]")).getText();
            System.out.println("Name Found  :" + getName);
            assertEquals(dataList.contains(getName), true);
        }

        driver.close();


    }
}
