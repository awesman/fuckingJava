package steam;

public class DownloadPage extends AbstractPage {

    private static final String INSTALL_LOCATOR = "//div[@id='about_greeting_ctn']//span[contains(text(),'%s')]";

    public DownloadPage(String installLabel) {
        super(INSTALL_LOCATOR, installLabel);
    }

}