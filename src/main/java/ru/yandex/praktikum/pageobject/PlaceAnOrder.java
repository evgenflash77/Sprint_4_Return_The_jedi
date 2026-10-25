package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaceAnOrder {
    private final WebDriverWait wait;
    public PlaceAnOrder(WebDriver driver){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    private final By ButtonYes = By.xpath("//button[contains(text(), 'Да')]");// нашли локатор кнопки "Да"

    public void clickButtonYes(){
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(ButtonYes));
        button.click();

    }
}

