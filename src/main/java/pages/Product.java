package pages;

import base.BasePage;
import base.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Product extends BasePage {
    /**
     * Base Page Class contains all Selenium methods that we need to use in test scenarios
     * I created this class one time and we will never need create test methods in other pages.
     * Just create one time and use in everywhere. It saves us code repeat and memory
     *
     * @param driver
     **/


    public static final By SEARCH_AREA = By.cssSelector("input[data-testid='search-input']");
    public static final By FIRST_PRODUCT = By.cssSelector("a[href*='/product/alisa-coat-jet-black-a996']");
    public static final By PRODUCT_TITLE = By.xpath("//div[@class='ProductView__productSidebar']/div[1]//div[@class='css-1y0qwvb']");

    private static final By SIZE_LIST =By.xpath("//div[text()='Choose size']");
    private static final By SIZE_OF_PRODUCT = By.xpath("//div[@data-testid='product-order-select-size']/div[2]/div/div");
    private static final By ADD_TO_CARD_BUTTON = By.cssSelector("button[data-testid='product-order-button']");


    public Product(WebDriver driver) {
        super(driver);
    }

    public void sendKeyToSearchBox(String key){
        sendKeyAndPressEnter(SEARCH_AREA,key, Keys.ENTER);
        Log4j.info("User typed product name and search");
    }

    public void clickFirstProduct(){
        clickWithJs(FIRST_PRODUCT);
        Log4j.info("User clicked first product on page");
    }

    public String checkTitleOfProd(){
        String productTitle = getText(PRODUCT_TITLE);
        return productTitle;
    }

    public void selectSizeList(){
        clickWithJs(SIZE_LIST);
    }
    public void selectSize(){
        clickWithJs(SIZE_OF_PRODUCT);
    }

    public void addToCard(){
        clickWithJs(ADD_TO_CARD_BUTTON);
    }




}
