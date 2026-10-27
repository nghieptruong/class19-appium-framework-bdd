package hooks;

import drivers.DriverHelper;
import drivers.DriverManager;
import drivers.DriverManagerFactory;
import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ConfigManager;

public class Hooks {

    static Logger logger = LogManager.getLogger(Hooks.class);

    @BeforeAll
    public static void beforeAll() {
        logger.info("Before all executing...");
        ConfigManager.loadProperties();
    }

    @Before
    public void beforeScenario() {
        logger.info("Before scenario executing...");
        String platform = ConfigManager.getProperty("platform");
        DriverManager driverManager = DriverManagerFactory.getDriverManager(platform);
        driverManager.createDriver();
        DriverHelper.setDriver(driverManager.getDriver());
    }

    @BeforeStep
    public void beforeStep() {

    }

    @AfterStep
    public void afterStep() {
        // take screenshot
    }

    @After
    public void afterScenario() {
        logger.info("After scenario executing...");
    }

    @AfterAll
    public static void afterAll() {
        logger.info("After all executing...");
    }
}
