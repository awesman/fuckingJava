package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;

public class Block {

    private static final String NAME_LOCATOR = ".//div[@class='tab_item_name']";
    private static final String DISCOUNT_LOCATOR = ".//div[@class='discount_pct']";
    private static final String PRICE_LOCATOR = ".//div[@class='discount_final_price']";
    private static final String DISCOUNT_ROWS_LOCATOR = "//div[@id='DiscountsRows']/a";

    private WebElement element;
    private String gameName;
    private int discountValue;
    private double price;

    private Block(WebElement element) {
        this.element = element;
        gameName = element.findElement(By.xpath(NAME_LOCATOR)).getText();
        String sale = element.findElement(By.xpath(DISCOUNT_LOCATOR)).getText();
        discountValue = parseSalle(sale);
        price = parsePrice(element.findElement(By.xpath(PRICE_LOCATOR)).getText());
    }

    private int parseSalle(String sale) {
        return Integer.parseInt(sale.substring(1, sale.length() - 1));
    }

    private double parsePrice(String sale) {
        return Double.parseDouble(sale.substring(1, sale.length()));
    }

    public static List<Block> chooseDiscount(WebDriver driver) throws InterruptedException {
        Thread.sleep(4000);
        List<WebElement> elements = driver.findElements(By.xpath(DISCOUNT_ROWS_LOCATOR));
        List<Block> blocks = elements.stream().map(Block::new).collect(Collectors.toList());

        blocks.sort((o1, o2) -> {
            if (o1.getDiscountValue() == o2.getDiscountValue()) {
                return 0;
            } else if (o1.getDiscountValue() > o2.getDiscountValue()) {
                return 1;
            } else {
                return -1;
            }
        });
        return blocks;
    }

    public static Block getMaxDiscount(List<Block> blocks) {
        return blocks.get(9);
    }

    public WebElement getElement() {
        return element;
    }

    public int getDiscountValue() {
        return discountValue;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Block{" +
                "gameName='" + gameName + '\'' +
                ", discountValue=" + discountValue +
                ", price=" + price +
                '}';
    }
}
