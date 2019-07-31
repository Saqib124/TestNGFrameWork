package PageFactor.Pages;
import Common.PageActions;
import org.openqa.selenium.WebDriver;

abstract class BasePage extends PageActions {

    BasePage(WebDriver driver){
        super(driver);
    }
}
