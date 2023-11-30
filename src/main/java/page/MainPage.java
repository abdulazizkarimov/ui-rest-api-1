package page;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {
    private ILink newslettersLink = getElementFactory().getLink(By.xpath("//a[contains(@class, 'c-internal-links__text')]"), "Newsletters link");
    private IButton acceptCookiesBtn = getElementFactory().getButton(By.id("didomi-notice-agree-button"), "Accept cookies btn");

    public MainPage() {
        super(By.xpath("//a[contains(@class, 'o-site-header__logo')]"), "Main page");
    }

    public void clickOnNewslettersLink() {
        newslettersLink.click();
    }

    public void acceptCookies() {
        acceptCookiesBtn.click();
    }
}