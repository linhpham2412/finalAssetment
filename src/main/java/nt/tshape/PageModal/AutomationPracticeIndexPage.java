package nt.tshape.PageModal;

import nt.tshape.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPracticeIndexPage {
    public WebDriver driver;
    private final WebDriverWait wait;

    private final String titleMRFieldId = "id_gender1";
    private final String titleMRsFieldId = "id_gender2";

    //constructor
    public AutomationPracticeIndexPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //locator
    private final String linkXPathByName = "//a[contains(@class,'login') and normalize-space(text()) = '%s']";
    private final By createNewAccountButton = By.id("SubmitCreate");
    private final By emailCreateTextBox = By.id("email_create");
    private final String titleCheckBoxLocatorById = "//input[@id='%s']";
    private final String personalInfoTextFieldLocatorByName = "//label[normalize-space(text())='%s']//parent::div//child::input";
    private final String yourAddressTextFieldLocatorByName = "//label[normalize-space(text())='%s']//parent::p//child::input";
    private final String dobDropDownFieldByXPath = "//div[@id='%s']";

    public AutomationPracticeIndexPage goToPageByURL(String locationURL) {
        driver.get(locationURL);
        return this;
    }

    public AutomationPracticeIndexPage clickLinkButtonByName(String linkName) {
        WebElement linkToBeClick = driver.findElement(By.xpath(String.format(linkXPathByName, linkName)));
        wait.until(ExpectedConditions.elementToBeClickable(linkToBeClick));
        linkToBeClick.click();
        return this;
    }

    public AutomationPracticeIndexPage clickCreateAnAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(createNewAccountButton)));
        driver.findElement(createNewAccountButton).click();
        return this;
    }

    public AutomationPracticeIndexPage inputToEmailAddressWithEmail(String emailAddress) {
        driver.findElement(emailCreateTextBox).sendKeys(emailAddress);
        return this;
    }

    public AutomationPracticeIndexPage selectDOBFieldIDWithValue(String dobFieldId, String fieldValue) {
        Select dobDropDownField = new Select(driver.findElement(By.xpath(String.format(dobDropDownFieldByXPath, dobFieldId)+"//select")));
        dobDropDownField.selectByValue(fieldValue);
        return this;
    }

    public AutomationPracticeIndexPage selectPersonalTitleAs(String titleValue){
        String titleId = (titleValue.equals("1")) ? titleMRFieldId : titleMRsFieldId;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(titleCheckBoxLocatorById,titleId))));
        WebElement titleCheckBox = driver.findElement(By.xpath(String.format(titleCheckBoxLocatorById,titleId)));
        titleCheckBox.click();
        return this;
    }

    public AutomationPracticeIndexPage inputPersonalInformationFieldNameWithValue(String fieldName, String fieldValue){
        WebElement personalInfoField = driver.findElement(By.xpath(String.format(personalInfoTextFieldLocatorByName,fieldName)));
        personalInfoField.sendKeys(fieldValue);
        return this;
    }
}
