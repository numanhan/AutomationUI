package pages;

import base.BasePage;
import base.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final By MAIL_AREA = By.cssSelector("input[data-testid='input']");
    private static final By PW_AREA = By.cssSelector("linput[data-testid='login-form-password-input']");
    private static final By LOGIN_BUTTON = By.cssSelector("button[data-testid='login-form-login-button']");
    private static final By LOGIN_PAGE_TEXT = By.cssSelector("div[data-testid='login-page-welcome-message'] span");
    private static final By INCORRECT_PASSWORD = By.cssSelector("div[data-testid='login-form-error-message'] span");

    private String incorrectMail ="testuser@gmail.com";
    private String incorrectPassword ="aabbcc12klmn??";

    public static final String correctMail="numanhanduran@outlook.com";
    private String correctPassword="68626numanhan";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getTextOfLoginPage() {
        String textOfLoginPage = getText(LOGIN_PAGE_TEXT);
        return textOfLoginPage;
    }

    public void fillMailAndPwArea() {
        sendKeys(MAIL_AREA, incorrectMail);
        sendKeys(PW_AREA, incorrectPassword);
        clickWithJs(LOGIN_BUTTON);
        Log4j.info("User credentials are not correct");
    }

    public void fillCorrectMailButWrongPw(){
        sendKeys(MAIL_AREA,correctMail);
        sendKeys(PW_AREA,incorrectPassword);
        clickWithJs(LOGIN_BUTTON);
        Log4j.info("User typed incorrect password");
    }

    public String getErrorMsgPw(){
        String textOfWarning = getText(INCORRECT_PASSWORD);
        return textOfWarning;

    }

    public void successfullLogin(){
        sendKeys(MAIL_AREA,correctMail);
        sendKeys(PW_AREA,correctPassword);
        clickWithJs(LOGIN_BUTTON);
        Log4j.info("User succesfully logged in.. Homepage is loading");
    }
}
