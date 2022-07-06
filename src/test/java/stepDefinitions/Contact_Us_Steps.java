package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
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
  public void tearDown(){
    driver.quit();
  }

  public String generateRandomNumber(int length) {
    return RandomStringUtils.randomNumeric(length);
  }



  @Given("I access the webdriver university contact us page")
  public void i_access_the_webdriver_university_contact_us_page() {
    driver.get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
  }

  @When("I enter unique first name")
  public void i_enter_unique_first_name() {
    driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='first_name']")).sendKeys("Jon");
  }

  @And("I enter a unique last name")
  public void i_enter_a_unique_last_name() {
    driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='last_name']")).sendKeys("Blogs");
  }

  @And("I enter a unique email address")
  public void i_enter_a_unique_email_address() {

    driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='email']")).sendKeys( "AutoEmail" + generateRandomNumber(5) + "@mail.com");
  }

  @And("I enter a unique comment")
  public void i_enter_a_unique_comment() {
    driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='email']")).sendKeys("Hey");
  }

  @When("I enter a specific first name {Word}")
  public void i_enter_a_specific_first_name(String firstName) {
    driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='first_name']")).sendKeys(firstName);

  }
  @When("I enter a specific last name {Word}")
  public void i_enter_a_specific_last_name(String lastName) {
    driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='last_name']")).sendKeys(lastName);

  }

  @When("I enter a specific email address {Word}")
  public void i_enter_a_specific_email_address(String email) {
    driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='email']")).sendKeys(email);

  }

  @When("I enter a specific comment {string}")
  public void i_enter_a_specific_comment(String comment) {
    driver.findElement(By.xpath("//form[@id='contact_form']/textarea[@name='message'] ")).sendKeys(comment);

  }
  @And("I click on the submit button")
  public void i_click_on_the_submit_button() {
    driver.findElement(By.xpath("//div[@id='form_buttons']/input[@value='SUBMIT']")).click();
  }

  @Then("I should be presented with a successful contact us message")
  public void i_should_be_presented_with_a_successful_contact_us_message() {
    WebElement contactUs_Message = driver.findElement(By.xpath("//div[@id='contact_reply']/h1[.='Thank You for your Message!']"));
    Assert.assertEquals(contactUs_Message.getText(), "Thank You for your Message!");
  }


}