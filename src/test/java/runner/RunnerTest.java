package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

@CucumberOptions(
        features = "src/main/resources/alltests.feature",
        glue = {"stepdefinitions"}
)

public class RunnerTest extends AbstractTestNGCucumberTests {
    public static WebDriver browserDriver;

    @BeforeClass
    @Parameters("browser")
    public void setUp (@Optional("chrome") String browser)
    {
        if(browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            browserDriver = new ChromeDriver();
            browserDriver.manage().window().maximize();
        }

        else if(browser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            browserDriver = new FirefoxDriver();
            browserDriver.manage().window().maximize();
        }
    }

    @AfterClass
    public void browserClose(){
        browserDriver.quit();
    }

}
