package jotformeu;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    public ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void firstTest() throws InterruptedException {
        driver.navigate().to("https://form.jotformeu.com/92362697115361");
        TimeUnit.SECONDS.sleep(3);

        inputName();
        inputBirhtDate();
        inputInstrument();
        inputDays();
        inputDateAndTime();
        inputComments();

        WebElement press = driver.findElementById("input_2");
        press.click();
        TimeUnit.SECONDS.sleep(1);

        Assert.assertTrue(driver.findElementByClassName("thankyou").isDisplayed());
    }

    @Test
    public void secondTest() throws InterruptedException {
        driver.navigate().to("https://form.jotformeu.com/92362697115361");
        TimeUnit.SECONDS.sleep(3);

        inputName();
        inputBirhtDate();
        inputDays();
        inputDateAndTime();
        inputComments();

        WebElement press = driver.findElementById("input_2");
        press.click();
        TimeUnit.SECONDS.sleep(1);

        Assert.assertTrue(driver.findElementByClassName("form-error-message").isDisplayed());
    }

    private void inputName () {
        WebElement firstName = driver.findElementById("first_3");
        firstName.sendKeys("Kate");

        WebElement lastName = driver.findElementById("last_3");
        lastName.sendKeys("St");
    }

    private void inputBirhtDate(){
        WebElement birthDateMonth = driver.findElementById("input_4_month");
        new Select(birthDateMonth).selectByValue("January");

        WebElement birthDateDay = driver.findElementById("input_4_day");
        new Select(birthDateDay).selectByValue("1");

        WebElement birthDateYear = driver.findElementById("input_4_year");
        new Select(birthDateYear).selectByValue("2019");
    }

    private void inputInstrument(){
        WebElement instrument = driver.findElementById("input_5");
        new Select(instrument).selectByValue("Violin");
    }

    private void inputDays(){
        driver.findElementById("label_input_6_0").click();
    }

    private void inputDateAndTime(){
        WebElement startDateMonth = driver.findElementById("month_7");
        startDateMonth.clear();
        startDateMonth.sendKeys("10");

        WebElement startDateDay = driver.findElementById("day_7");
        startDateDay.clear();
        startDateDay.sendKeys("25");

        WebElement startDateYear = driver.findElementById("year_7");
        startDateYear.clear();
        startDateYear.sendKeys("2017");

        WebElement startDateHour = driver.findElementById("hour_7");
        new Select(startDateHour).selectByValue("8");

        WebElement startDateMinutes = driver.findElementById("min_7");
        new Select(startDateMinutes).selectByValue("40");

        WebElement startDateAMPM = driver.findElementById("ampm_7");
        new Select(startDateAMPM).selectByValue("AM");
    }

    private void inputComments() {
        WebElement comments = driver.findElementById("input_8");
        comments.sendKeys("Comments");
    }

    @After
    public void Close() throws InterruptedException {
        driver.quit();
    }

}
