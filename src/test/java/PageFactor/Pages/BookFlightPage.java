package PageFactor.Pages;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static Common.Constants.*;

public class BookFlightPage extends BasePage {

    private By lnkFlights = By.cssSelector("a[data-ga-track*=flights]");
    private By btnMultiSearch = By.cssSelector(".active button[id*=submit]");
    private By departureAirport = By.xpath("//div[@class='inputWrapper']//input[contains(@id,'origin')][1]");
    private By arrivalAirport = By.xpath("//div[@class='col-field col-airport col-destination switch']//input[contains(@id,'destination')][1]");
    private By btnCalendar = By.xpath("//div[contains(@class,'single-date-picker')]//div[contains(@class,'keel-grid dateRangeGrid')]//div[contains(@id,'start')]");
    private By btnReturnCalendar = By.xpath("//div[contains(@class,'single-date-picker')]//div[contains(@class,'keel-grid dateRangeGrid')]//div[contains(@id,'end')]");
    private By securityCheckText = By.xpath("//div[@id='helptext']//h2");

    public BookFlightPage(WebDriver driver) {
        super(driver);
    }

    public void tabOnFlightTap() {
        waitForPageLoaded();
        clickOn(lnkFlights);
    }

    public void setDepartureAirPort(String airPort) {
        selectTheAirport(airPort, departureAirport);
    }

    public void setArrivalAirPort(String airPort) {
        selectTheAirport(airPort, arrivalAirport);
    }

    public void setMultiSectorDepartureAirPort(String airPort, int index) {
        By xpath = By.xpath("//div[@class='multiCityLeg col']//input[contains(@id,'origin" + index + "')]");
        selectTheAirport(airPort, xpath);
    }

    public void setMultiSectorArrivalAirPort(String airPort, int index) {
        By xpath = By.xpath("//div[@class='col col-1-2-s col-field col-leg-destination']//input[contains(@id,'destination" + index + "')]");
        selectTheAirport(airPort, xpath);
    }

    private void selectTheAirport(String airPort, By xpath) {
        WebElement element = driver.findElement(xpath);
        element.clear();
        wait(500);
        element.click();
        for (char character : airPort.toCharArray()) {
            wait(500);
            typeInto(element,String.valueOf(character));
        }
        wait(500);
        selectFromDropDown(airPort);
    }

    private void selectFromDropDown(String airportCode) {
        By xpath = By.xpath("//li[contains(@id,'" + airportCode + "')]");
        clickOn(xpath);
    }

    public void selectTripType(String type) {
        waitForPageLoaded();
        String tripType = "";
        if (StringUtils.equals(ONE_WAY, type)) {
            tripType = "One-way";
        } else if (StringUtils.equals(RETURN, type)) {
            tripType = "Return";
        } else if (StringUtils.equals(MULTI_CITY, type)) {
            tripType = "Multi-city";
        }
        By xpath = By.xpath("//div[contains(@class,'displayCatBlock')]//label[contains(@title,'" + tripType + "')]");
        clickOn(xpath);
    }

    public void clickSearchBtn() {
        scrollIntoView(btnMultiSearch);
        wait(250);
        clickOn(btnMultiSearch);
        waitForPageLoaded();
    }

    public void tabOnCalendarIcon() {
        clickOn(btnCalendar);
    }

    public void selectDate(String date) {
        By dateBtn = By.xpath("//div[@aria-label='" + date + "']");
        clickOn(dateBtn);
    }

    public void tabOnCalendarIconForReturnDate() {
        clickOn(btnReturnCalendar);
    }

    public String getSecurityCheckText() {
        return getTextOf(securityCheckText);
    }

    public void setMultiSectorDate(int index) {
        By xpath = By.xpath("//div[@class='col col-1-2-s col-field col-leg-destination']//input[contains(@id,'destination" + index + "')]/parent::div/parent::div/following-sibling::div[contains(@class,'col-leg-depart-date')]//div[contains(@class,'singleDate')]");
        clickOn(xpath);
        wait(500);
    }
}
