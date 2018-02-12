package cars.forms;

import framework.BaseForm;
import framework.elements.Label;
import org.openqa.selenium.By;

public class CarsBaseForm extends BaseForm {

    private String locatorForMainLogo = "logo";

    public void navigateMainPage() {
        waitForJavaScriptToLoad();
        Label labelMainLogo = new Label(By.className(locatorForMainLogo));
        labelMainLogo.clickAndWait();
    }
}
