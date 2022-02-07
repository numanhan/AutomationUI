package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {
    private static final By TITLE = By.cssSelector("[title ='Otrium | The Online Fashion Outlet | Get Exclusive Access']");
    private static final By LOGIN_BUTTON = By.xpath("//a/span[contains(text(), 'Log in')]");
    private static final By LOGIN_TITLE =By.cssSelector("h2[data-testid]>span");

    /**
    * Home Page Test Methods with Selenium: We are controlling the user successfully came cross
     * the login page. At least we need to see user can open the login page after see the website running
     * **/

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getTitleOfHomePage(){
        String homePageTitle = getTitle(TITLE);
        return homePageTitle;
    }

    public void clickLoginButton(){
        clickWithJs(LOGIN_BUTTON);
    }
    public String getTextofLogin(){
        String title = getText(LOGIN_TITLE);
        return title;
    }


}
