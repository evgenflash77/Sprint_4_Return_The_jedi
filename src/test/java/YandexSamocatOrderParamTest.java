import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.praktikum.pageobject.*;


@RunWith(JUnitParamsRunner.class) //запустил класс с параметрами
public   class YandexSamocatOrderParamTest {
    @Rule // подключил DriverFactory
    public DriverFactory driverFactory = new DriverFactory();
    @Test

    @Parameters({
            "Сергей,Федоров,Окская 7А,Кузьминки,89256768798,true,top",
            "Дмитрий,Нагиев,Сретенка 32,Сухаревская,89994767689,true,bottom"})



    public void logintest(String name,String surname, String adress,String metro,String phone,boolean expectedResult,String buttonPosition) {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        OrderFormSamocat orderFormSamocat = new OrderFormSamocat(driver);
        OrderRentalForm orderRentalForm = new OrderRentalForm(driver);
        PlaceAnOrder placeAnOrder = new PlaceAnOrder(driver);
        OrderPlaced orderPlaced = new OrderPlaced(driver);
        mainPage.openSite(); //открыли сайт
        mainPage.acceptCookiesIfPresent();//приняли куки
        mainPage.clickOrderButtonTop(buttonPosition);//нажали кнопку заказать
        orderFormSamocat.fillNameOrder(name); // заполнили поле Имя
        orderFormSamocat.fillSurnameOrder(surname);//заполнили поле Фамилия
        orderFormSamocat.fillAdressOrder(adress);//заполнили поле Адресс
        orderFormSamocat.fillMetroOrder(metro);//заполнили поле Метро
        orderFormSamocat.clickMetroListOrder();// выбрали выбранную станцию в выпадающем списке
        orderFormSamocat.fillPhoneOrder(phone);// заполнили поле Телефон
        orderFormSamocat.clickNextButtonOrder();// кликнули по кнопке Далее
        orderRentalForm.clickBringSamocatRental();// кликнули по полю "Когда привезти самокат"
        orderRentalForm.clickCalendarButtonRental();// выбрали дату
        orderRentalForm.clickRentalPeriodRental();// кликнули по полю "Срок аренды"
        orderRentalForm.clickDaysRental(); // выбрали срок аренды
        orderRentalForm.clickChooseColorRental(); // выбрали цвет самоката
        orderRentalForm.sendCommentRental(); // оставили комментарий курьеру
        orderRentalForm.clickOrderButtonRental();// нажали кнопку заказать
        placeAnOrder.clickButtonYes();// кликаем по кнопке "Да"
        WebElement modalButton = orderPlaced.getModalButton(); // нашли кнопку модального окна
        Assert.assertTrue(modalButton.isDisplayed());

    }

}

