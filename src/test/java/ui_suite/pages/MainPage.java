package ui_suite.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import ui_suite.enums.HeaderMenuType;
import ui_suite.enums.SignInUpType;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;


public class MainPage extends AbstractPage{

    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://github.com/";
    protected static String SIGN_IN_OR_UP_BUTTON_TEMPLATE = "//div[contains(@class, 'HeaderMenu')]//a[contains(text(),'%s')]";
    protected static String HEADER_MENU_TEMPLATE = "//li[contains(@class, 'HeaderMenu-item')]/*[contains(text(),'%s')]";
    protected final By SIGN_IN_BUTTON = By.xpath("//div[contains(@class, 'HeaderMenu')]//a[contains(text(),'Sign in')]");
    protected final By SIGN_UP_BUTTON = By.xpath("//div[contains(@class, 'HeaderMenu')]//a[contains(text(),'Sign up')]");

    protected final By SIGN_UP_FOR_GITHUB_FIELD = By.xpath("//p[contains(text(),'The world’s leading')]/following-sibling::div//dd/input");
    protected final By SIGN_UP_FOR_GITHUB_BUTTON = By.xpath(("//p[contains(text(), 'The world’s leading')]/following-sibling::div//button"));
    protected final By START_FREE_ENTERPRISE_TRIAL_BUTTON = By.xpath(("//p[contains(text(),'The world’s leading')]/following-sibling::div/a"));

    protected final By USER_LOGGED_AVATAR = By.xpath("//*[@class='avatar circle']");
    protected final By LOGGED_USER_NAME = By.xpath("//img[@data-component='Avatar']/following-sibling::div/div/div");

    @Override
    @Step("Open Main page")
    public MainPage openPage()
    {
        Selenide.open(BASE_URL);
        logger.info("Main page opened");
        return this;
    }

    @Step("Click LogIn button")
    public MainPage clickLogInButton() {
        $x(String.format(SIGN_IN_OR_UP_BUTTON_TEMPLATE, SignInUpType.SIGN_IN)).shouldBe(enabled, ofSeconds(10)).click();
        return this;
    }

    @Step("Check option ''{0}'' in Header menu is present")
    public MainPage checkOptionInHeaderMenuIsPresent(HeaderMenuType option) {
        $x(String.format(HEADER_MENU_TEMPLATE, option)).shouldBe(appear, ofSeconds(10));
        return this;
    }

    @Step("Hover on option ''{0}'' in Header menu")
    public MainPage hoverOnOptionInHeaderMenu(HeaderMenuType option) {
        $x(String.format(HEADER_MENU_TEMPLATE, option)).shouldBe(enabled, ofSeconds(10)).hover();
        return this;
    }

    @Step("Click on Pricing in Header menu")
    public MainPage clickOnPricingInHeaderMenu() {
        $x(String.format(HEADER_MENU_TEMPLATE, HeaderMenuType.PRICING)).shouldBe(enabled, ofSeconds(10)).click();
        return this;
    }

    public String getLoggedInUserName()
    {
        $(USER_LOGGED_AVATAR).shouldBe(enabled, ofSeconds(10)).click();
        return $(LOGGED_USER_NAME).shouldBe(enabled, ofSeconds(10)).getText();

//        WebElement linkLoggedInUser = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
//                .until(ExpectedConditions.presenceOfElementLocated(linkLoggedInUserLocator));
//        return linkLoggedInUser.getAttribute("content");
    }

    public boolean isOpened() {
        return  $(USER_LOGGED_AVATAR).isDisplayed();
    }

}
