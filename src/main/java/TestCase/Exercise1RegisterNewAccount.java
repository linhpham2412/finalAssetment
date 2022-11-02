package TestCase;

import nt.tshape.BaseClass;
import nt.tshape.Constant;
import nt.tshape.PageModal.AutomationPracticeIndexPage;
import org.testng.annotations.Test;
import static nt.tshape.Utils.generateTestEmail;

public class Exercise1RegisterNewAccount extends BaseClass {
    @Test
    public void registerNewAccount() {
        AutomationPracticeIndexPage automationPracticeIndexPage = new AutomationPracticeIndexPage(driver, wait);
        automationPracticeIndexPage
                .goToPageByURL("http://automationpractice.com/index.php")
                .clickLinkButtonByName("Sign in")
                .inputToEmailAddressWithEmail(generateTestEmail())
                .clickCreateAnAccountButton()
                .selectDOBFieldIDWithValue(Constant.DOB_DAY_ID,"11");
    }
}
