package framework.element;

public class Button extends BaseElement {

    public Button(String locator) {
        super(locator);
    }

    public void clickBtn() {
        element.click();
    }

}