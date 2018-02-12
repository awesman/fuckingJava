package steam;

import framework.element.Button;

public abstract class AbstractPage {

    private Button btn;

    public AbstractPage(String locator) {
        this.btn = new Button(locator);
    }

    public AbstractPage(String locator, String label) {
        this.btn = new Button(String.format(locator, label));
    }

    public Button getBtn() {
        return btn;
    }

    public void clickBtn() {
        getBtn().getElement().click();
    }
}
