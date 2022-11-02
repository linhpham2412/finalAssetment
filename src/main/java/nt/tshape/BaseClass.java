package nt.tshape;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
    public WebDriver driver;

    @Parameters({"browser"})
    @BeforeClass
    public void loadWebDriver(@Optional("chrome") String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\linhpham\\Documents\\Tshape_Training\\Webdriver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized"); // open Browser in maximized mode
            options.addArguments("disable-infobars"); // disabling infobars
            options.addArguments("--disable-extensions"); // disabling extensions
            options.addArguments("--disable-gpu"); // applicable to windows os only
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.addArguments("--no-sandbox"); // Bypass OS security model
            driver = new ChromeDriver(options);
        }
        if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\linhpham\\Documents\\Tshape_Training\\Webdriver\\geckodriver.exe");
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        }
        driver
                .manage()
                .window()
                .maximize();
    }
}
