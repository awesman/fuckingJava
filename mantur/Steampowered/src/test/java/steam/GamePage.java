package steam;

import framework.element.PageField;

public class GamePage extends AbstractPage {

    private static final String DISCOUNT_LOCATOR = "//div[@id='game_area_purchase']//div[@class='discount_pct']";
    private static final String PRICE_LOCATOR = "//div[@id='game_area_purchase']//div[@class='discount_final_price']";
    private static final String NAVIGATE_BTN_LOCATOR = "//div[@id='global_action_menu']//a[contains(text(),'%s')]";

    private PageField discountField;
    private PageField priceField;

    public GamePage(String navigateLabel) {
        super(NAVIGATE_BTN_LOCATOR, navigateLabel);
        this.discountField = new PageField(DISCOUNT_LOCATOR);
        this.priceField = new PageField(PRICE_LOCATOR);
    }

    public PageField getDiscountField() {
        return discountField;
    }

    public PageField getPriceField() {
        return priceField;
    }
}