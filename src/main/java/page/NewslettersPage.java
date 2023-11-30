package page;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import util.RandomUtil;
import java.util.List;

public class NewslettersPage extends Form {
    private int choice;
    private List<ILabel> subPlans = getElementFactory().findElements(By.xpath("//label[contains(@class, 'block') and contains(@class, 'w-full') and contains(@class, 'btn-tertiary') and contains(@class, 'unchecked-label')]"), ElementType.LABEL);
    private List<ILink> previewList = getElementFactory().findElements(By.xpath("//a[contains(@class, 'text-primary') and contains(@class, 'inline-block')]"), ElementType.LINK);

    public NewslettersPage() {
        super(By.xpath("//a[contains(@class, 'o-site-header__logo')]"), "Newsletters page");
    }

    public void chooseRandSubPlan() {
        choice = RandomUtil.getInt(subPlans.size());
        subPlans.get(choice).click();
    }

    public void openPreview() {
        previewList.get(choice).click();
    }
}