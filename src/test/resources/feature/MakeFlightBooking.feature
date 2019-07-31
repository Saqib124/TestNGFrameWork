Feature: Book flight using Booking.com

  @flightSearch @oneWayFlight
  Scenario Outline: Make one way booking using Booking.com
    Given User launch the flight from Booking website
    And   Select the "<tripType>" trip type
    Then  Select "<departure>" as Depature and "<destination>" as Arrival airport
    And   Select "<tripDate>" as flight date
    And   User tab on search button
    And   User validate the security check page
    Examples:
    | tripType | departure | destination | tripDate  |
    | One-way  | KHI       | DXB         | +2        |
    | One-way  | MAA       | DXB         | +6        |


  @flightSearch @returnFlight
  Scenario Outline: Make round booking using Booking.com
    Given User launch the flight from Booking website
    And   Select the "<tripType>" trip type
    Then  Select "<departure>" as Depature and "<destination>" as Arrival airport
    And   Select "<tripDate>" as flight date
    And   Select "<tripReturnDate>" as return flight data
    And   User tab on search button
    And   User validate the security check page
    Examples:
      | tripType | departure | destination | tripDate  | tripReturnDate |
      | Return   | LHR       | DXB         | +2        | +4             |
      | Return   | DXB       | ISB         | +3        | +6             |


  @flightSearch @multiCityFlight
  Scenario: Make multi sector booking using Booking.com
    Given User launch the flight from Booking website
    And   Select the "Multi-city" trip type
    Then  Select the multi leg as "KHI-DXB|LHE-AUH|ISB-BKK"
    And   Select multi leg dates as "+2|+6|+8"
    And   User tab on search button
    And   User validate the security check page



