package page;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class EmailForm extends Form {
    public EmailForm() {
        super(By.xpath("//div[contains(@class, 'container') and contains(@class, 'justify-between')]"), "Email form");
    }
}