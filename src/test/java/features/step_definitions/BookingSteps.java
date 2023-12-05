package features.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.HomePage;

public class BookingSteps extends BasePage {

    //public static WebDriver driver;
    HomePage homePage = new HomePage();
    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        //driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.navigateToHomePage();

    }

    @When("I browse through the page")
    public void i_browse_through_the_page() {
        homePage.goToRoomsCategory();
    }
    @Then("I have the option to book a room")
    public void i_have_the_option_to_book_a_room() {
       homePage.assertBookButtonDisplayed();
    }
    
    @When("User click book this room")
    public void user_click_book_this_room() {
    	homePage.bookthisRoom();
    }

    @When("^User enter the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enter_the_and(String FName, String LName, String email, String phoneNum) {
        // Write code here that turns the phrase above into concrete actions
       homePage.userenterBookingDetils(FName,LName,email,phoneNum);
    }

    @When("User select the booking date two nights")
    public void user_select_the_booking_date_nights() {
        // Write code here that turns the phrase above into concrete actions
       
      //  homePage.bookingDate(bookingCalender);
        homePage.bookingDate();
    }

    @When("user click on book")
    public void user_click_on_book() {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickonBooking();
    }

    @Then("verify booking detils")
    public void verify_booking_detils() {
        // Write code here that turns the phrase above into concrete actions
       homePage.verifyBookingDetils();
    }
}
