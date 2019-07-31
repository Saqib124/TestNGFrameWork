package TestCases;

import Common.DriverHandler;
import PageFactor.Steps.BookFlightSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    private WebDriver driver = null;
    private DriverHandler driverHandler = null;

    BookFlightSteps bookFlightSteps;

    @BeforeClass (alwaysRun = true)
    public void initializeTest() {
        driverHandler = new DriverHandler();
        this.driver = driverHandler.chromeDriver();
        init();
    }

    @AfterClass (alwaysRun = true)
    public void testTearDown() {
        driverHandler.tearDownDriver();
    }

    private void init() {
        bookFlightSteps = new BookFlightSteps(this.driver);
    }

}
