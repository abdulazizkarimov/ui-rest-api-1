package page;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class UnsubscribePage extends Form {
    private ITextBox emailTextBox = getElementFactory().getTextBox(By.id("email"), "Email text box");
    private IButton submitBtn = getElementFactory().getButton(By.xpath("//button[contains(@class, 'btn-primary')]"), "Submit btn");
    private ILabel messageLabel = getElementFactory().getLabel(By.xpath("//p[contains(@class, 'text-danger')]"), "Message label");

    public UnsubscribePage() {
        super(By.xpath("//img[contains(@class, 'unsubscribe-logo')]"), "Unsubscribe page");
    }

    public void enterEmail(String s) {
        emailTextBox.clearAndType(s);
    }

    public void clickOnSubmitBtn() {
        submitBtn.click();
    }

    public String getMessage() {
        return messageLabel.getText();
    }
}