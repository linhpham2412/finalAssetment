package TestCase;

import nt.tshape.BaseClass;
import nt.tshape.Constant;
import nt.tshape.PageModal.AutomationPracticeIndexPage;
import org.testng.annotations.Test;
import static nt.tshape.Utils.*;

public class Exercise1RegisterNewAccount extends BaseClass {
    @Test
    public void registerNewAccount() {
        AutomationPracticeIndexPage automationPracticeIndexPage = new AutomationPracticeIndexPage(driver, wait);
        automationPracticeIndexPage
                .goToPageByURL("http://automationpractice.com/index.php")
                .clickLinkButtonByName("Sign in")
                .inputToEmailAddressWithEmail(generateTestEmail())
                .clickCreateAnAccountButton()
                .selectPersonalTitleAs(generateRandomNumberInRange(1,2))
                .inputPersonalInformationFieldNameWithValue("First name", generateRandomTestCharacters(5))
                .inputPersonalInformationFieldNameWithValue("Last name", generateRandomTestCharacters(7))
                .inputPersonalInformationFieldNameWithValue("Password", generateRandomTestCharacters(5))
                .selectDOBFieldIDWithValue(Constant.DOB_DAY_ID,generateRandomNumberInRange(1,31))
                .selectDOBFieldIDWithValue(Constant.DOB_MONTH_ID,generateRandomNumberInRange(1,12))
                .selectDOBFieldIDWithValue(Constant.DOB_YEAR_ID,generateRandomNumberInRange(1900,2022));
    }
}
