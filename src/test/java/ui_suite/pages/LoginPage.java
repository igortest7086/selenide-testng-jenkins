package ui_suite.pages;

import com.codeborne.selenide.Selenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import ui_suite.models.User;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

public class LoginPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://github.com/login";

    private By INPUT_LOGIN = By.id("login_field");
    private By INPUT_PASSWORD = By.id("password");
    private By SUBMIT_BUTTON = By.xpath("//input[@value='Sign in']");

    @Override
    public LoginPage openPage()
    {
        Selenide.open(PAGE_URL);
        logger.info("Login page opened");
        return this;
    }

    public LoginPage login(User user)
    {
        $(INPUT_LOGIN).shouldBe(visible, ofSeconds(10)).sendKeys(user.getUsername());
        $(INPUT_PASSWORD).shouldBe(visible, ofSeconds(10)).sendKeys(user.getPassword());
        $(SUBMIT_BUTTON).shouldBe(clickable, ofSeconds(10)).click();
        logger.info("Login performed");
        return this;
    }

}
