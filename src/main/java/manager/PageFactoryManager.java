package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {this.driver = driver;}

    public BasePage getBasePage() {return new BasePage(driver);}
    public Waiter getWaiter() {return new Waiter(driver);}
    public Cart getCart() {return new Cart(driver);}
    public ProductPage getProductPage() {return new ProductPage(driver);}
    public Header getHeader() {return new Header(driver);}
    public Footer getFooter() {return new Footer(driver);}


}
