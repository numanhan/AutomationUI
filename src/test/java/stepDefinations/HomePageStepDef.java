package stepDefinations;

import base.BaseTest;
import base.Log4j;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import pages.HomePage;
import sun.rmi.runtime.Log;


public class HomePageStepDef extends BaseTest {
    HomePage homePage;

    private String homePageTitle = "Otrium | The Online Fashion Outlet | Get Exclusive Access";
    private String loginTitle = "Log in";

    @Step("User Navigates To Otrium")
    public void navigateTo(){
        homePage = new HomePage(driver);
        Log4j.info("User navigated to Otrium Home Page");
    }


    @Step("Check The HomePage Opened Successfully")
    public void checkTheHomePageOpened(){
           Assert.assertEquals("Home Page Could Not Opened",homePageTitle,homePage.getTitleOfHomePage());
           System.out.println("***Home Page Opened Successfully and the Title is :"+homePage.getTitleOfHomePage());
           System.out.println("----------------------");
           Log4j.info("User successfully opened the main page");


    }

    @Step("User sees Login Button on the page")
    public void getLoginButton(){
        Assert.assertEquals("User can't see the login button", loginTitle, homePage.getTextofLogin());
        System.out.println("User can see Login button and the title is:"+homePage.getTextofLogin());
        System.out.println("------------------");
        Log4j.info("User able to see and click login button");
    }

    @Step("User Clicks On Login Button")
    public void clickOnLoginButton(){
        homePage.clickLoginButton();
        Log4j.info("User successfully clicked the Login button");
    }

}

