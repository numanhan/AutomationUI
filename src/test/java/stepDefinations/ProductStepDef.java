package stepDefinations;

import base.BaseTest;
import base.Log4j;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import pages.Product;

public class ProductStepDef extends BaseTest {

    private String productTitle = "Adidas sportswear nini sum graphic bomber jacket multicolor";

    Product product;

    @Step("User Searches Product Which Name Is <key>")
    public void searchProduct(String key){
        product.sendKeyToSearchBox(key);
        Log4j.info("User searched the product");

    }

    @Step("User clicks first product on page")
    public void openProduct(){
        product.clickFirstProduct();
        Log4j.info("User successfully clicked first product");
    }

    @Step("User checks the title")
    public void checkProduct(){
        Assert.assertEquals("Product title didn't matched with expected product", productTitle, product.checkTitleOfProd());
        System.out.println("Product is expected product");
        System.out.println("----------------------");
        Log4j.info("User sees product title matched");
    }
    @Step("User clicks size list")
    public void listSize(){
        product.selectSizeList();
        Log4j.info("User clicked size list");
    }

    @Step("User selects S size")
    public void selectSize(){
        product.selectSize();
        Log4j.info("User selected size");
    }

    @Step("User adds product to card")
    public void addProdCard(){
        product.addToCard();
        Log4j.info("User added product to card");
    }

}
