package PageFactor.Bindings;
import Common.DriverHandler;
import PageFactor.Steps.BookFlightSteps;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

abstract class BaseBinding {
    private DriverHandler driverHandler;
    BookFlightSteps bookFlightSteps;

    @Before
    public void initializeTest(){
        driverHandler = new DriverHandler();
        WebDriver driver = driverHandler.chromeDriver();
        bookFlightSteps = new BookFlightSteps(driver);
    }

    @After
    public void safeCloseTest(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("action for failed scenario ...");
        }
        driverHandler.tearDownDriver();
    }
}

