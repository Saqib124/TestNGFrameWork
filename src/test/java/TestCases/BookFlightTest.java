package TestCases;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static Common.Constants.*;

public class BookFlightTest extends BaseTest {

    @DataProvider(name = "flightDetails")
    public static Object[][] fltDetails() {
        return new Object[][]{{"KHI", "DXB", "+2"}, {"MAA", "DXB", "+4"}};
    }

    @Test(dataProvider = "flightDetails")
    void searchOneWayFlight(String from, String to, String tripDate) {
        bookFlightSteps.openFlightSearch();
        bookFlightSteps.selectTripType(ONE_WAY);
        bookFlightSteps.selectTripRoute(from, to);
        bookFlightSteps.selectTripDate(tripDate);
        bookFlightSteps.searchForFlight();
        bookFlightSteps.validateSecurityCheck();
    }

    @Test(groups = { "multi-city" })
    void searchRoundTripFlight() {
        bookFlightSteps.openFlightSearch();
        bookFlightSteps.selectTripType(RETURN);
        bookFlightSteps.selectTripRoute("MAA", "DXB");
        bookFlightSteps.selectTripDate("+2"); //Date after number of days
        bookFlightSteps.selectTripReturnDate("+4"); //Date after number of days
        bookFlightSteps.searchForFlight();
        bookFlightSteps.validateSecurityCheck();
    }

    @Test(groups = { "multi-city" })
    void searchMultiSectorFlight() {
        bookFlightSteps.openFlightSearch();
        bookFlightSteps.selectTripType(MULTI_CITY);
        bookFlightSteps.selectMultiSectorFlight("KHI-DXB|LHE-AUH|ISB-BKK");
        bookFlightSteps.selectMultiSectorFlightDate("+2|+6|+8"); //Date after number of days
        bookFlightSteps.searchForFlight();
        bookFlightSteps.validateSecurityCheck();
    }

}
