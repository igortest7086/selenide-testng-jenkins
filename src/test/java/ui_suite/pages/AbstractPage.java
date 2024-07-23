package ui_suite.pages;

public abstract class AbstractPage {
    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 10;
}
