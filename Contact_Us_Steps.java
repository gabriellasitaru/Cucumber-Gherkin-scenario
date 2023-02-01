package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Contact_Us_Steps {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();


    }

    @After
    public void tearDown() {
        driver.quit();

    }


    @Given("I access the university contact us page")
    public void i_access_the_university_contact_us_page()  {
        driver.get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");


    }
    @When("I enter a first name")
    public void i_enter_a_first_name() throws InterruptedException {
        driver.findElement(By.cssSelector("form#contact_form > input[name='first_name']")).sendKeys("Jane");
        Thread.sleep(3000);
    }
    @And("I enter a last name")
    public void i_enter_a_last_name() throws InterruptedException {
        driver.findElement(By.cssSelector("form#contact_form > input[name='last_name']")).sendKeys("Doe");
        Thread.sleep(3000);

    }
    @And("I enter an email address")
    public void i_enter_an_email_address() {
       driver.findElement(By.cssSelector("form#contact_form > input[name='email']")).sendKeys("janedoe@test.com");
    }
    @And("I enter a comment")
    public void i_enter_a_comment() throws InterruptedException {
        driver.findElement(By.cssSelector("textarea")).sendKeys("Hello!");
        Thread.sleep(3000);

    }
    @And("I click on the submit button")
    public void i_click_on_the_submit_button() throws InterruptedException {
        driver.findElement(By.cssSelector("[type='submit']")).click();
        Thread.sleep(3000);

    }
    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        ////div[@id='contact_reply']/h1[.='Thank You for your Message!']

        WebElement contactUs_Submission_Message = driver.findElement(By.xpath("//div[@id='contact_reply']/h1[.='Thank You for your Message!']"));
        Assert.assertEquals(contactUs_Submission_Message.getText(), "Thank You for your Message!");

    }

}
