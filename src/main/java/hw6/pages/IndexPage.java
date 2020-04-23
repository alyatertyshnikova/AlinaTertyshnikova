package hw6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class IndexPage extends AbstractPage {

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement usernameTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(className = "benefit-icon")
    private List<WebElement> images;

    @FindBy(className = "benefit")
    private List<WebElement> textUnderImages;

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public IndexPage login(String username, String password) {
        userIcon.click();
        usernameTextField.sendKeys(username);
        passwordTextField.sendKeys(password);
        loginButton.click();
        return this;
    }

    public List<String> getTextUnderImages() {
        return getListOfItemsText(textUnderImages);
    }

    public Boolean isAllImagesDisplayed() {
        return waitForAllElements(images).stream()
                .allMatch(WebElement::isDisplayed);
    }

    public Boolean isFrameDisplayed() {
        return waitForElement(frame).isDisplayed();
    }

    public IndexPage switchToFrame() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        return this;
    }

    public Boolean isFrameButtonDisplayed() {
        return waitForElementToBeClickable(frameButton).isDisplayed();
    }

    public IndexPage switchToDefaultFrame() {
        driver.switchTo().defaultContent();
        return this;
    }

}
