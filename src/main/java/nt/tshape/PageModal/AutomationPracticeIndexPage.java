package nt.tshape.PageModal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPracticeIndexPage {
    public WebDriver driver;
    private final WebDriverWait wait;

    //constructor
    public AutomationPracticeIndexPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //locator
    private final String linkXPathByName = "//a[contains(@class,'login') and normalize-space(text()) = '%s']";
    private final By createNewAccountButton = By.id("SubmitCreate");
    private final By emailCreateTextBox = By.id("email_create");
    private final By titleMRCheckBox = By.id("id_gender1");
    private final By titleMRsCheckBox = By.id("id_gender2");
    private final String personalInfoTextFieldLocatorByName = "//label[contains (@for,'customer_firstname') and normalize-space(text())='%s']//parent::div//input";
    private final String yourAddressTextFieldLocatorByName = "//label[normalize-space(text())='%s']//parent::p//child::input";
    private final String dobDropDownFieldByXPath = "//select[@id='%s']";
    public AutomationPracticeIndexPage goToPageByURL(String locationURL){
        driver.get(locationURL);
        return this;
    }

    public AutomationPracticeIndexPage clickLinkButtonByName(String linkName){
        WebElement linkToBeClick = driver.findElement(By.xpath(String.format(linkXPathByName,linkName)));
        wait.until(ExpectedConditions.elementToBeClickable(linkToBeClick));
        linkToBeClick.click();
        return this;
    }

    public AutomationPracticeIndexPage clickCreateAnAccountButton(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(createNewAccountButton)));
        driver.findElement(createNewAccountButton).click();
        return this;
    }

    public AutomationPracticeIndexPage inputToEmailAddressWithEmail(String emailAddress){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailCreateTextBox));
        driver.findElement(emailCreateTextBox).sendKeys(emailAddress);
        return this;
    }

    public AutomationPracticeIndexPage selectDOBFieldIDWithValue(String dobFieldId, String fieldValue){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(dobDropDownFieldByXPath,dobFieldId))));
        WebElement dobField = driver.findElement(By.xpath(String.format(dobDropDownFieldByXPath,dobFieldId)));
        Select dobDropDownField = new Select(dobField);
        dobDropDownField.selectByVisibleText(fieldValue+"  ");
        return this;
    }
}
