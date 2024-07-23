package ui_suite.tests;

import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import ui_suite.models.User;
import ui_suite.pages.LoginPage;
import ui_suite.pages.MainPage;
import ui_suite.services.UserCreator;

import static org.testng.Assert.*;

@Listeners(ScreenShooter.class)
public class UserAccessTests extends CommonConditions{

    @Test
    public void oneCanLoginGithubTest()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        mainPage.openPage()
                .clickLogInButton();
        loginPage.openPage()
                .login(testUser);
        assertEquals(mainPage.getLoggedInUserName(), testUser.getUsername());
    }

    @Test
    public void failedLoginGithubWithoutPasswordTest()
    {
        User testUser = UserCreator.withEmptyPassword();
        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        mainPage.openPage()
                .clickLogInButton();
        loginPage.openPage()
                .login(testUser);
        assertFalse(mainPage.isOpened());
    }
}
