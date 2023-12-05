package pages;

import static utils.CommonUtils.scrollToElement;
import static utils.DriversUtils.driver;
import static utils.DriversUtils.getDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	// all the elements are located 
    @FindBy(tagName = "h2")
    private WebElement roomCategoryIdentifier;

    @FindBy(xpath = "//button[contains(@class,'openBooking')]")
    private WebElement bookButton;
    
    @FindBy(xpath = "//input[contains(@name,'firstname')]")
    private WebElement FirstNameTextbox;
    
    @FindBy(xpath = "//input[contains(@name,'lastname')]")
    private WebElement LastNameTextbox;
    
    @FindBy(xpath = "//input[contains(@name,'email')]")
    private WebElement EmailTextbox;
    
    @FindBy(xpath = "//input[contains(@name,'phone')]")
    private WebElement PhoneNumberTextbox;
    
    
    @FindBy(xpath = "//button[contains(text(),'Book')]")
    private WebElement bookBtn;
    
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelBtn;
    
    @FindBy(xpath = "//span[contains(@class,'rbc-btn-group')]/button[contains(text(),'Today')]")
    private WebElement TodayCanlenderBtn;
    
    @FindBy(xpath = "//span[contains(@class,'rbc-btn-group')]/button[contains(text(),'Next')]")
    private WebElement NextMonthCalenderBtn ;
    
    
    @FindBy(xpath =  "//div[contains(@class,'rbc-month-view')]")
    private WebElement calenderView ;
    
    
    @FindBy(xpath = "//span[contains(@class,'rbc-btn-group')]/button[1]")
    private WebElement todaysDate;
    
    
    @FindBy(xpath = "//div[contains(@class,'col-sm-6 text-center')]/h3")
    private WebElement SucessMsg;
    
    
    
    @FindBy(xpath = "//div[contains(@class,'col-sm-6 text-center')]/p[1]")
    private WebElement SucessMsg2;
    
    
    @FindBy(xpath = "//div[contains(@class,'col-sm-6 text-center')]//p[2]")
    private WebElement acctualDate;
    
    
    public HomePage() //constructor 
    {
        PageFactory.initElements(getDriver(), this);
    }
   

    public void goToRoomsCategory() 
    {
        try {
            scrollToElement(roomCategoryIdentifier);
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.out.println("Error in the rooms category method");
        }
    }

    public void assertBookButtonDisplayed(){
        Assert.assertEquals(true, bookButton.isDisplayed());
    }

    public void navigateToHomePage() {
        getDriver().get("https://automationintesting.online/#/");
    }

	public void bookthisRoom() {
		// TODO Auto-generated method stub
		try {
			bookButton.click();
			System.out.println("User click on book this room button");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void userenterBookingDetils(String fName, String lName, String email, String phoneNum) {
		// TODO Auto-generated method stub
		try {
			FirstNameTextbox.sendKeys(fName);
			System.out.println("User enter First Name");
			
			LastNameTextbox.sendKeys(lName);
			System.out.println("User enter Last Name");
			
			EmailTextbox.sendKeys(email);
			System.out.println("User enter Email Name");
			
			PhoneNumberTextbox.sendKeys(phoneNum);
			System.out.println("User enter PhoneName");
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
public static WebElement nextDayElement;
public static WebElement dayAfterNextElement;



	public void bookingDate() {
		// TODO Auto-generated method stub
		try {
			LocalDate currentDate = LocalDate.now();// Obtains the current date from the system clock in the default time zone 
			
            LocalDate nextDay = currentDate.plusDays(20);// Returns a copy of this localdate with the specified number of days added
            LocalDate dayAfterNext = currentDate.plusDays(22);

            // Format the dates to match the button text format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
            String currentDateText = currentDate.format(formatter);
            String nextDayText = nextDay.format(formatter);
            String dayAfterNextText = dayAfterNext.format(formatter);
           

            // Find elements for current date and next two dates
            WebElement currentDateElement = driver.findElement(By.xpath("//button[text()='" + currentDateText + "']"));
             nextDayElement = driver.findElement(By.xpath("//button[text()='" + nextDayText + "']"));
             dayAfterNextElement = driver.findElement(By.xpath("//button[text()='" + dayAfterNextText + "']"));
           

            
            // Use Actions class to perform click-and-hold, move, and release action
            Actions actions = new Actions(driver);
            actions.clickAndHold(currentDateElement)
                   .moveToElement(nextDayElement)
                   .moveToElement(dayAfterNextElement)
                   .release()
                   .build()
                   .perform();

            System.out.println(nextDayElement.getText());
            System.out.println(dayAfterNextElement.getText());
           
//			Calendar calender=Calendar.getInstance();
//			calender.add(Calendar.DATE, 2);
//			//java.util.Date targateDate=calender.getTime();
//			
//			SimpleDateFormat dataFormat=new SimpleDateFormat("d");
//			String day =dataFormat.format(targateDate);
//			System.out.println("Formated date" + day);
			
			//idetified next two day
//			TodayCanlenderBtn.click();
//			Thread.sleep(500);
			//NextMonthCalenderBtn.click();
//			todaysDate.click();
//			List<WebElement> nextTwoDays =calenderView.findElements(By.xpath("//button[@class='rbc-button-link' and not (contains(@class,'rbc-off-range'))]"));
//			//Actions actions=new Actions(driver);
//			nextTwoDays.get(0).click();
//			nextTwoDays.get(1).click();
			
			
			
			//actions.clickAndHold(todaysDate).perform();
			
			
//			int xOffset=nextTwoDays.get(0).getLocation().getX() -todaysDate.getLocation().getX();
//			int yOffset=nextTwoDays.get(0).getLocation().getY() -todaysDate.getLocation().getY();
//			
//			
//			actions.moveByOffset(xOffset, yOffset).perform();
//			
//			xOffset=nextTwoDays.get(1).getLocation().getX()- todaysDate.getLocation().getX();
//			yOffset=nextTwoDays.get(1).getLocation().getY()- todaysDate.getLocation().getX();
//			
//			actions.moveByOffset(xOffset, yOffset).perform();
			
//			for(int i=0;i<2;i++) {
//				actions.moveToElement(nextTwoDays.get(i)).perform();
//				Thread.sleep(500);
//			}
//			actions.release().perform();
//			
//			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}


	public void clickonBooking() {
		// TODO Auto-generated method stub
		try {
			bookBtn.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	public void verifyBookingDetils() {
		// TODO Auto-generated method stub
		try {
			String actualMessage=SucessMsg.getText();
			String actualMessage2=SucessMsg2.getText();
			String expectedMessage="Booking Successful!";
			String expectedMessage2="Congratulations! Your booking has been confirmed for:";
			
			if(actualMessage.equals(expectedMessage)) {
				System.out.println("Actual message match");
			}
			if(actualMessage2.equals(expectedMessage2)) {
				System.out.println("expectedMessage2 message match");
			}
			
		
			driver.quit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

