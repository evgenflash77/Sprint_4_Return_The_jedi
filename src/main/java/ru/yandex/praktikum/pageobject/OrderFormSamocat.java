package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderFormSamocat {
    private final WebDriver driver;
    private final WebDriverWait wait;
    public OrderFormSamocat(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(30));
    }

    private final By NameOrder = By.cssSelector("input[placeholder='* Имя']");// нашли локатор поля Имя
    private final By SurnameOrder = By.cssSelector("input[placeholder='* Фамилия']"); // нашли локатор поля Фамилч
    private final By AdressOrder = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");// нашли локатор поля Адресс
    private final By MetroOrder = By.cssSelector("input[placeholder='* Станция метро']");// нашли локатор поля Метро
    private final By MetroListOrder = By.className("select-search__select");// нашли локатор выпадающего списка
    private final By PhoneOrder = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");// нашли локатор поля Телефон
    private final By NextButtonOrder = By.xpath("//button[contains(text(), 'Далее')]");// нашли локатор кнопки Далее

    public void fillNameOrder(String name) {
        WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(NameOrder));
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void fillSurnameOrder(String surname) {
        driver.findElement(SurnameOrder).sendKeys(surname);
    }

    public void fillAdressOrder(String adress) {
        driver.findElement(AdressOrder).sendKeys(adress);
    }

    public void fillMetroOrder(String metro) {
        driver.findElement(MetroOrder).sendKeys(metro);
    }
    public void clickMetroListOrder(){
        WebElement listContainer = wait.until(ExpectedConditions.elementToBeClickable(MetroListOrder));
        listContainer.click();
    }

    public void fillPhoneOrder(String phone){
        driver.findElement(PhoneOrder).sendKeys(phone);
    }

    public void clickNextButtonOrder(){
        driver.findElement(NextButtonOrder).click();
    }
}
