import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;
import java.lang.Thread;

public class MyTest extends BaseTest {
    private ISettingsFile config = new JsonSettingsFile("config.json");
    private ISettingsFile test = new JsonSettingsFile("test.json");

    @Test
    public void myTestCase() {
        AqualityServices.getBrowser().goTo(config.getValue("/host_url").toString());
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().isDisplayed(), "Main page is not open");

        mainPage.acceptCookies();
        mainPage.clickOnNewslettersLink();
        NewslettersPage newslettersPage = new NewslettersPage();
        Assert.assertTrue(newslettersPage.state().isDisplayed(), "Newsletters page is not open");

        newslettersPage.chooseRandSubPlan();
        EmailForm emailForm = new EmailForm();
        Assert.assertTrue(emailForm.state().isDisplayed(), "Email form is open");

        AqualityServices.getBrowser().goTo(config.getValue("/host_url").toString());
        Assert.assertTrue(mainPage.state().isDisplayed(), "Main page is not open");

        mainPage.clickOnNewslettersLink();
        newslettersPage.openPreview(); sleep(10); /*** <-- REMOVE ***/
        PreviewForm previewForm = new PreviewForm();
        Assert.assertTrue(previewForm.state().isDisplayed(), "Preview form is not open");

        previewForm.clickOnUnsubscribeLink();
        UnsubscribePage unsubscribePage = new UnsubscribePage();
        Assert.assertTrue(unsubscribePage.state().isDisplayed(), "Unsubscribe page is not open");

        unsubscribePage.enterEmail(test.getValue("/email").toString());
        unsubscribePage.clickOnSubmitBtn();
        Assert.assertEquals(unsubscribePage.getMessage(), test.getValue("/message").toString(), "Incorrect message");

        Assert.assertTrue(MyCheck.noMessage(), "There is a message from euronews@gmail.com");
    }

    private void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}