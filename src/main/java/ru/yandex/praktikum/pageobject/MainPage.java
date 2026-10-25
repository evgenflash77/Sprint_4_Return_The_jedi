package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public MainPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }
    private static final String SITE_URL = "https://qa-scooter.praktikum-services.ru/";
    private final By Order_button_top = By.className("Button_Button__ra12g"); // нашли локатор верхней кнопки "Заказать""
    private final By Order_button_bottom = By.className("Button_Middle__1CSJM"); // нашли локатор нижней кнопки "Заказать"
    private final By CookieButton = By.id("rcc-confirm-button"); // нашли локатор кук
    private final By Panel_text = By.cssSelector("[data-accordion-component='AccordionItemPanel']");; //локатор текста ответа

    public void openSite() {
        driver.get(SITE_URL);// открыли сайт

    }

    public void ClickDrop_down_list(int index) {
        String fullId = "accordion__heading-" + index;
        WebElement element = driver.findElement(By.id(fullId));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        wait.until(ExpectedConditions.attributeToBe(element, "aria-expanded", "true"));
    }

    public void acceptCookiesIfPresent() {
        try {
            // Ждем кнопку куки максимум 5 секунд.
            // Если она есть — кликаем через JS (надежнее обычного клика).
            WebElement cookieBtn = wait.until(ExpectedConditions.elementToBeClickable(CookieButton));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cookieBtn);

        } catch (org.openqa.selenium.TimeoutException e) {
            // Если за 5 секунд кнопки не нашлось — значит, её не было.
            // Это НЕ ошибка, просто игнорируем и идем дальше.

        }
    }

    public void clickOrderButtonTop(String buttonPosition) {
        WebElement button;
        if ("top".equals(buttonPosition)) {
            button = wait.until(ExpectedConditions.elementToBeClickable(Order_button_top));
        } else {
            button = wait.until(ExpectedConditions.elementToBeClickable(Order_button_bottom));
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);


    }

    public String getAnswerText(int index) {

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Panel_text));
        java.util.List<WebElement> allPanels = driver.findElements(Panel_text);
        WebElement targetPanel = allPanels.get(index);
        wait.until(ExpectedConditions.visibilityOf(targetPanel));
        String text = targetPanel.getText();
        return text;


    }

}
