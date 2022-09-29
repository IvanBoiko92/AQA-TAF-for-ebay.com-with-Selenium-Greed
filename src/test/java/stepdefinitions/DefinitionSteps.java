package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import manager.PageFactoryManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.*;
import runner.RunnerTest;
import java.time.Duration;


import java.time.Duration;

public class DefinitionSteps extends RunnerTest {
    public WebDriver driver = this.browserDriver;
    PageFactoryManager pageFactoryManager;
    BasePage basePage;
    Waiter waiter;
    Cart cart;
    ProductPage productPage;
    Header header;
    Footer footer;

    @Before
    public void testsSetup(){
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        basePage = pageFactoryManager.getBasePage();
        basePage.openPage(url);
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        WebElement searchField = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        waiter = pageFactoryManager.getWaiter();
        waiter.waitVisibilityOfElement(3000, searchField);
    }

    @And("User makes search by keyword {string}")
    public void userMakesSearchByKeywordKeyword(final String keyword) {
        basePage.searchKeyword(keyword);
    }

    @And("User clicks search button")
    public void userClickSearchButton() {
        basePage.pressSearch();

    }

    @And("User click on product {string}")
    public void userAddClickOnProduct(String name) throws InterruptedException {
        productPage=pageFactoryManager.getProductPage();
        productPage.clickOnProduct(name);

    }

    @And("User checks presence of product item in list")
    public void userChecksPresenceOfProductItemInList() {
        cart=pageFactoryManager.getCart();
        cart.hoverIntoCart();

    }

    @Then("User trying to buy a product")
    public void userTryingToBuyAProduct() {
        productPage=pageFactoryManager.getProductPage();
        productPage.ClickBuyItNow();
    }

    @When("Sign in")
    public void signIn() throws InterruptedException {
        header=pageFactoryManager.getHeader();
        header.SignIn();

    }

    @And("Log In with incorrect email or {string}")
        public void LogInWithIncorrectEmailOrLogin(String login) throws InterruptedException {
        header=pageFactoryManager.getHeader();
        header.logInWithIncorrectEmailOrLogin(login);
    }

    @When("User click on Company info")
    public void userClickOnCompanyInfo() throws InterruptedException {
            footer=pageFactoryManager.getFooter();
            footer.CompanyInfo();


        }

    @Then("Checking of correct page {string}")
    public void checkingOfCorrectPageUrl(String CorrectUrl) throws InterruptedException {
        footer=pageFactoryManager.getFooter();
        footer.CompanyInfo();
        WebElement OurCompany = driver.findElement(By.xpath("//a[@class=\"js-l1-link\"]"));
        Assert.assertTrue(OurCompany != null); }

    @And("User sees the security measure window")
    public void userSeesTheSecurityMeasureWindow() {
        header=pageFactoryManager.getHeader();
        WebElement captcha = driver.findElement(By.xpath("/html/body[@class='no-touch']/div[@id='wrapper']/form[@id='captcha_form']/div[@id='CentralArea']/div[@id='s0-70-captcha-ui']/iframe"));
        waiter = pageFactoryManager.getWaiter();
        waiter.waitVisibilityOfElement(5000, captcha);
        if (captcha!=null){
            System.out.println("Unfortunately, you have been identified as a robot.");
            System.out.println("Maybe too many attempts have been made.");
            System.out.println("Please verify yourself\n");
        }


    }

    @Then("Incorrect Email or Password")
    public void incorrectEmailOrPassword() {
        System.out.println("Incorrect Email or Login!");
        System.out.println("Or the number of retries has been exceeded. Try again in 1 hour.");
    }

    @When("User click on popular brands")
    public void userClickOnPopularBrands() {
        basePage = pageFactoryManager.getBasePage();
        basePage.PopularBrands();

    }

    @When("User click on Facebook link")
    public void userClickOnFacebookLink() {
        footer=pageFactoryManager.getFooter();
        footer.FacebookLink();
    }
}


