package PageFactor.Bindings;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BookFlight extends BaseBinding {

    public BookFlight(){ super(); }

    @And("^Select the \"([^\"]*)\" trip type$")
    public void selectTheTripType(String tripType)  {
        bookFlightSteps.selectTripType(tripType);
    }

    @Then("^Select \"([^\"]*)\" as Depature and \"([^\"]*)\" as Arrival airport$")
    public void selectAsDepatureAndAsArrivalAirport(String from, String to)  {
        bookFlightSteps.selectTripRoute(from,to);
    }

    @And("^Select \"([^\"]*)\" as flight date$")
    public void selectAsFlightDate(String tripDate)  {
       bookFlightSteps.selectTripDate(tripDate);
    }

    @And("^User tab on search button$")
    public void userTabOnSearchButton() {
        bookFlightSteps.searchForFlight();
    }

    @And("^User validate the security check page$")
    public void userValidateTheSecurityCheckPage() {
        bookFlightSteps.validateSecurityCheck();
    }

    @Given("^User launch the flight from Booking website$")
    public void userLaunchTheFlightFromBookingWebsite() {
        bookFlightSteps.openFlightSearch();
    }

    @And("^Select \"([^\"]*)\" as return flight data$")
    public void selectAsReturnFlightData(String returnDate) {
        bookFlightSteps.selectTripReturnDate(returnDate);
    }

    @Then("^Select the multi leg as \"([^\"]*)\"$")
    public void selectTheMultiLegAs(String legs) {
        bookFlightSteps.selectMultiSectorFlight(legs);
    }

    @And("^Select multi leg dates as \"([^\"]*)\"$")
    public void selectMultiLegDatesAs(String dates) {
        bookFlightSteps.selectMultiSectorFlightDate(dates);
    }
}
