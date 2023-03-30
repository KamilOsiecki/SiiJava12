package tests;

import configuration.AppProperties;
import configuration.BrowserEnvironment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {

    protected static WebDriver driver;
    private static Logger logger = LoggerFactory.getLogger("BaseTest.class");
    private static BrowserEnvironment browserEnvironment;
    private static AppProperties appProperties;

    @BeforeAll
    static void setup() {
        appProperties = AppProperties.getInstance();
        browserEnvironment = new BrowserEnvironment();
    }

    @BeforeEach
    void setupDriver() {
        driver = browserEnvironment.getDriver();
        driver.get(System.getProperty("app_url"));
        logger.debug("WebDriver initialized properly");
    }

    @AfterEach
    void tearDown() {
        try {
            driver.quit();
            logger.info("WebDriver closed successfully");
        } catch (Exception e) {
            logger.error("WebDriver was not closed.");
        }
    }
}