package stepDefinations;

import base.BaseTest;
import base.Log4j;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import pages.Card;

public class CardStepDef extends BaseTest {

    Card card;

    public String cardPageTitle = "Shopping cart";
    public String productDetail = "Adidas sportswear nini sum graphic bomber jacket multicolor";
    public String checkoutTitle = "CHECKOUT";

    @Step("User clicks card button")
    public void clickCardBtn(){
        card.clickCard();
        Log4j.info("User clicked card button");
    }

    @Step("User checks card page title")
    public void checkCardPageTitle(){
        Assert.assertEquals("Card page couldn't loaded",cardPageTitle, card.getCardPageTitle());
        System.out.println("Titles matched");
        System.out.println("-----------------");
        Log4j.info("User checkted card page title");
    }

    @Step("User checks product detail title")
    public void checkProdDetail(){
        Assert.assertEquals("This is not expected product",productDetail, card.cardProductTitle());
        System.out.println("This is expected product");
        System.out.println("---------------");
        Log4j.info("User checked product detail");
    }

    @Step("User clicks checkout button")
    public void checkoutProduct(){
        card.clickCheckout();
        Log4j.info("User clicked checkout");
    }

    @Step("User checks checkout title")
    public void checkCheckoutTitle(){
        Assert.assertEquals("Checkout page couldn't loaded",checkoutTitle, card.checkoutTitle());
        System.out.println("This is expected title");
        System.out.println("----------------");
        Log4j.info("User sees in the checkout page");
    }

    @Step("User clicks payment button")
    public void clickPayment(){
        card.payment();
        Log4j.info("User go further to payment methods");
    }
}
