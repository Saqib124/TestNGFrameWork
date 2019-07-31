package PageFactor.Steps;
import org.openqa.selenium.WebDriver;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BookFlightSteps extends BaseSteps {

    public BookFlightSteps(WebDriver driver){
        super(driver);
    }

    public void openFlightSearch(){
        driver.get("https://www.booking.com/");
        bookFlightPage.tabOnFlightTap();
    }

    public void selectTripType(String type){
        bookFlightPage.selectTripType(type);
    }

    public void selectTripRoute(String from, String to){
        bookFlightPage.setDepartureAirPort(from);
        bookFlightPage.setArrivalAirPort(to);
    }

    public void searchForFlight(){
        bookFlightPage.clickSearchBtn();
    }

    public void selectTripDate(String tripAfterDates){
        String strDate = getDateAfterNoOfDays(tripAfterDates);
        bookFlightPage.tabOnCalendarIcon();
        bookFlightPage.selectDate(strDate);
    }

    public void selectTripReturnDate(String tripAfterDates){
        String returnDate = getDateAfterNoOfDays(tripAfterDates);
        bookFlightPage.tabOnCalendarIconForReturnDate();
        bookFlightPage.selectDate(returnDate);
    }

    private String getDateAfterNoOfDays(String tripAfterDates){
        int noDays = Integer.parseInt(tripAfterDates);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, noDays);
        return new SimpleDateFormat("MMMM d").format(calendar.getTime());
    }

    public void validateSecurityCheck() {
        assertThat (bookFlightPage.getSecurityCheckText(), is("Security Check:"));
    }

    public void selectMultiSectorFlight(String route) {
        String[] sectors = route.split("\\|");
        int index = 0;
        for(String sector : sectors){
            String[] airportCode = sector.split("-");
            bookFlightPage.setMultiSectorDepartureAirPort(airportCode[0],index);
            bookFlightPage.setMultiSectorArrivalAirPort(airportCode[1],index);
            index++;
        }

    }

    public void selectMultiSectorFlightDate(String multiDate) {
        String[] days = multiDate.split("\\|");
        int index = 0;
        for(String day : days){
            String tripDate = getDateAfterNoOfDays(day);
            bookFlightPage.setMultiSectorDate(index);
            bookFlightPage.selectDate(tripDate);
            index++;
        }
    }
}
