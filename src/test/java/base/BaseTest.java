package base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    private String browserName = "chrome";

    @BeforeScenario
    public void setUp() {

        if ("chrome".equalsIgnoreCase(browserName)) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-notifications");
            options.addArguments("disable-popup-blocking");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(options);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.navigate().to("https://www.otrium.com");


        } else if ("firefox".equalsIgnoreCase(browserName)) {
            FirefoxOptions options = new FirefoxOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            options.addArguments("--kiosk");
            options.addArguments("--disable-notifications");
            options.addArguments("--start-fullscreen");
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
            driver = new FirefoxDriver(options);
            driver.navigate().to("https://www.otrium.com");
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);


        }
    }


    @AfterScenario
    public void tearDown() {
        driver.quit();
    }
}


