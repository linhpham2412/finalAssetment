package nt.tshape.PageModal;

import nt.tshape.Constant;
import nt.tshape.Customer_Information;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AutomationPracticeIndexPage {
    private final WebDriverWait wait;
    //locator
    private final String headerMenuLinkXPathLocatorByName = "//a[normalize-space(text()) = '%s']";
    private final String buttonXPathLocatorByName = "//span[normalize-space() = '%s']//parent::button";
    private final String dobDropDownFieldLocatorByXPathIdName = "//div[@id='%s']";
    private final String personalInfoCheckBoxLocatorByText = "//label[normalize-space()='%s']//preceding-sibling::div";
    private final By emailCreateTextBox = By.id("email_create");
    private final String titleCheckBoxLocatorById = "//input[@id='%s']";
    private final String personalInfoTextFieldLocatorByName = "//label[normalize-space(text())='%s']//parent::div//child::input";
    private final String yourAddressTextFieldLocatorByName = "//label[normalize-space(text())='%s']//parent::p//child::input";
    private final String additionalInformationTextareaXPathLocator = "//textarea[@id='other']";
    private final Customer_Information customerInformation;
    public WebDriver driver;

    //constructor
    public AutomationPracticeIndexPage(WebDriver driver, WebDriverWait wait, Customer_Information customerInformation) {
        this.driver = driver;
        this.wait = wait;
        this.customerInformation = customerInformation;
    }

    public AutomationPracticeIndexPage goToPageByURL(String locationURL) {
        driver.get(locationURL);
        return this;
    }

    public AutomationPracticeIndexPage clickLinkButtonByName(String linkName) {
        WebElement linkToBeClick = driver.findElement(By.xpath(String.format(headerMenuLinkXPathLocatorByName, linkName)));
        wait.until(ExpectedConditions.elementToBeClickable(linkToBeClick));
        linkToBeClick.click();
        return this;
    }

    public AutomationPracticeIndexPage clickButtonByName(String buttonName) {
        WebElement buttonToBeClick = driver.findElement(By.xpath(String.format(buttonXPathLocatorByName, buttonName)));
        wait.until(ExpectedConditions.elementToBeClickable(buttonToBeClick));
        buttonToBeClick.click();
        return this;
    }

    public AutomationPracticeIndexPage inputToEmailAddressWithEmail(String emailAddress) {
        driver.findElement(emailCreateTextBox).sendKeys(emailAddress);
        customerInformation.saveDataByFieldName("Email", emailAddress);
        return this;
    }

    public AutomationPracticeIndexPage selectDropDownFieldByIdWithValue(String fieldId, String fieldValue) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(dobDropDownFieldLocatorByXPathIdName, fieldId))));
        Select dropDownField = new Select(driver.findElement(By.xpath(String.format(dobDropDownFieldLocatorByXPathIdName, fieldId) + "//select")));
        dropDownField.selectByValue(fieldValue);
        customerInformation.saveDataByFieldName(fieldId, fieldValue);
        if (fieldId.equals(Constant.ADDRESS_STATE_ID)) {
            List<WebElement> options = dropDownField.getOptions();
            options.forEach(option -> customerInformation.setListOfState(option.getAttribute("value"), option.getText()));
        } else if (fieldId.equals(Constant.ADDRESS_COUNTRY_ID)) {
            List<WebElement> options = dropDownField.getOptions();
            options.forEach(option -> customerInformation.setListOfCountry(option.getAttribute("value"), option.getText()));
        }
        return this;
    }


    public AutomationPracticeIndexPage selectPersonalTitleAs(Boolean isMrTitle) {
        String titleId = (isMrTitle) ? Constant.TITLE_MR_FIELD_ID : Constant.TITLE_MRS_FIELD_ID;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(titleCheckBoxLocatorById, titleId))));
        WebElement titleCheckBox = driver.findElement(By.xpath(String.format(titleCheckBoxLocatorById, titleId)));
        titleCheckBox.click();
        customerInformation.saveCustomerTitleByBoolean(isMrTitle);
        return this;
    }

    public AutomationPracticeIndexPage inputPersonalInformationFieldNameWithValue(String fieldName, String fieldValue) {
        driver.findElement(By.xpath(String.format(personalInfoTextFieldLocatorByName, fieldName)))
                .sendKeys(fieldValue);
        customerInformation.saveDataByFieldName(fieldName, fieldValue);
        return this;
    }

    public AutomationPracticeIndexPage checkOnPersonalInfoCheckBoxByText(String fieldText, Boolean isCheck) {
        if (isCheck) driver.findElement(By.xpath(String.format(personalInfoCheckBoxLocatorByText, fieldText)))
                .click();
        customerInformation.saveCheckBoxDataByFieldNameWithBooleanValue(fieldText, isCheck);
        return this;
    }

    public AutomationPracticeIndexPage inputYourAddressTextFieldNameWithValue(String fieldName, String fieldValue) {
        WebElement textField = driver.findElement(By.xpath(String.format(yourAddressTextFieldLocatorByName, fieldName)));
        textField.clear();
        textField.sendKeys(fieldValue);
        customerInformation.saveDataByFieldName(fieldName, fieldValue);
        return this;
    }

    public AutomationPracticeIndexPage inputAdditionalTextareaWithText(String fieldText) {
        driver.findElement(By.xpath(additionalInformationTextareaXPathLocator))
                .sendKeys(fieldText);
        customerInformation.saveAdditionalInformationTextAreaByValue(fieldText);
        return this;
    }
}
