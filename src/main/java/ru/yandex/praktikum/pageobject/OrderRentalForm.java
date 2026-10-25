package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderRentalForm {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public OrderRentalForm(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private final By BringSamocatRental = By.cssSelector("input[placeholder='* Когда привезти самокат']"); // нашли локатор поля "Когда привезти самокат"
    private final By CalendarButtonRental = By.xpath("//div[contains(@aria-label, 'Choose')]") ;// нашли локатор кнопки даты
    private final By RentalPeriodRental = By.cssSelector("[class*='Dropdown-placeholder']");// нашли локатор поля "Срок аренды"
    private final By DaysRental = By.xpath("//*[contains(text(), 'сутки')]");// нашли локатор элемента "Суткм"
    private final By ChooseColorRental = By.id("black");// нашли локатор чекбокса
    private final By CommentRental = By.cssSelector("input[placeholder='Комментарий для курьера']"); // нашли локатор поля "Комментарий для курьера"
    private final By OrderButtonRental = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM"); // нашли локатор кнопки Заказать


    public void clickBringSamocatRental(){
        driver.findElement(BringSamocatRental).click();
    }
    public void clickCalendarButtonRental(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(CalendarButtonRental));
        element.click();
    }
    public void clickRentalPeriodRental(){
        driver.findElement(RentalPeriodRental).click();
    }
    public void clickDaysRental(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(DaysRental));
        element.click();
    }
    public void clickChooseColorRental(){
        driver.findElement(ChooseColorRental).click();
    }
    public void sendCommentRental(){
        driver.findElement(CommentRental).sendKeys("Позвонить за час");
    }

    public void clickOrderButtonRental() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(OrderButtonRental));
        button.click();
    }

}

