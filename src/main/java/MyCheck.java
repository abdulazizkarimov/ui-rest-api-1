import aquality.selenium.browser.AqualityServices;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MyCheck {
    public static boolean noMessage() {
        boolean result = false;

        Wait<WebDriver> wait = new WebDriverWait(
                AqualityServices.getBrowser().getDriver(), Duration.ofSeconds(30));
        MyCondition myCondition = new MyCondition();

        try {
            wait.until(d -> myCondition.isThereEuronewsMessage());
        } catch (TimeoutException e) {
            result = true;
        }
        return result;
    }
}
