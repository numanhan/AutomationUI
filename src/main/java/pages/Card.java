package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Card extends BasePage {

   public static final By CARD_BUTTON = By.cssSelector("a[data-testid='main-header-cart-a']");
   public static final By CARD_PAGE_TITLE = By.xpath("//div/div/div/div/div/h1/span");
   public static final By CARD_PROD_TITLE = By.cssSelector("a[data-testid='cart-item-product-name-a']>div");
   public static final By CHECKOUT_BUTTON = By.cssSelector("button[data-testid='cart-continue-to-checkout-top-button']");
   public static final By CHECKOUT_TITLE = By.cssSelector("h1[class='page-title']>span");
   public static final By PAY_BUTTON = By.cssSelector("button[class='checkout-btn-cnt-new active continue-checkout']");


    /**
     * Base Page Class contains all Selenium methods that we need to use in test scenarios
     * I created this class one time and we will never need create test methods in other pages.
     * Just create one time and use in everywhere. It saves us code repeat and memory
     *
     * @param driver
     **/
    public Card(WebDriver driver) {
        super(driver);
    }

    public void clickCard(){
    clickWithJs(CARD_BUTTON);
    }

    public String getCardPageTitle(){
        String cardTitle = getText(CARD_PAGE_TITLE);
        return cardTitle;
    }

    public String cardProductTitle(){
        String prodTitle = getText(CARD_PROD_TITLE);
        return prodTitle;
    }

    public void clickCheckout(){
        clickWithJs(CHECKOUT_BUTTON);
    }

    public String checkoutTitle(){
        String checkTitle = getText(CHECKOUT_TITLE);
        return checkTitle;
    }

    public void payment(){
        clickWithJs(PAY_BUTTON);
    }
}
