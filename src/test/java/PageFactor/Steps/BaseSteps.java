package PageFactor.Steps;

import PageFactor.Pages.BookFlightPage;
import org.openqa.selenium.WebDriver;

abstract class BaseSteps {
    WebDriver driver;
    BookFlightPage bookFlightPage;

    BaseSteps(WebDriver driver){
        this.driver = driver;
        bookFlightPage = new BookFlightPage(this.driver);
    }
}
