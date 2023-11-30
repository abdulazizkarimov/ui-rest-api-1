package base;

import aquality.selenium.browser.AqualityServices;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    @BeforeMethod
    protected void init() {
        AqualityServices.getBrowser().maximize();
    }

    @AfterMethod
    protected void destroy() {
        AqualityServices.getBrowser().quit();
    }
}