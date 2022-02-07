package stepDefinations;

import base.BaseTest;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import pages.LoginPage;

public class LoginPageStepDef extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);
    private String loginPageText ="Welcome back, choose your preferred way to continue.";
    private String warningText ="Password change required.";

    @Step("Check The Login Page Opened Successfully")
    public void checkLoginPage(){
        Assert.assertEquals("Login page couldn't open",loginPageText,loginPage.getTextOfLoginPage());
        System.out.println("***Login Page Opened Successfully And Header Is :" +loginPage.getTextOfLoginPage());
    }

    // Failed Scenarios Steps Are Beginning
    @Step("User Tries To Login With Incorrect Mail And Incorrect Pw")
    public void fillMailAndPw(){
        loginPage.fillMailAndPwArea();

    }

    @Step("User Tries To Login With Correct Mail but Incorrect Password")
    public void loginWithCorrectMailIncorrectPw(){
        loginPage.fillCorrectMailButWrongPw();
        Assert.assertEquals("Password change required.",warningText, loginPage.getErrorMsgPw());
    }
    //Failed Scenarios Steps Finished Here

    @Step("User Tries To Login With Correct Credentials")
    public void successfullyLogin(){
        loginPage.successfullLogin();
    }
}
