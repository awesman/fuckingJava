package steam;

public class CatalogPage extends AbstractPage {

    private static final String DISCOUNT_LOCATOR = "//div[@id='tab_select_Discounts']";

    public CatalogPage() {
        super(DISCOUNT_LOCATOR);
    }

}
