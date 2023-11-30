package page;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class PreviewForm extends Form {
    List<WebElement> frameList = AqualityServices.getBrowser().getDriver().findElements(By.xpath("//iframe[contains(@class, 'iframe-preview')]"));
    private ILink unsubscribeLink = getElementFactory().getLink(By.xpath("//a[contains(@href, 'unsubscribe')]"), "Unsubscribe link");

    public PreviewForm() {
        super(By.partialLinkText("Close"), "Preview form");
    }

    public void clickOnUnsubscribeLink() {
        AqualityServices.getBrowser().getDriver().switchTo().frame(frameList.get(frameList.size() - 1));
        AqualityServices.getBrowser().goTo(unsubscribeLink.getHref());
        AqualityServices.getBrowser().getDriver().switchTo().parentFrame();
    }
}