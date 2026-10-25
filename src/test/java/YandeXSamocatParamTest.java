import ru.yandex.praktikum.pageobject.DriverFactory;
import ru.yandex.praktikum.pageobject.MainPage;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(JUnitParamsRunner.class) //запустил класс с параметрами
public class YandeXSamocatParamTest {
    @Rule // подключил DriverFactory
    public DriverFactory driverFactory = new DriverFactory();
    private static final String[] EXPECTED_ANSWERS = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };


    @Test
    @Parameters({"0","1","2","3","4","5","6","7"}) // передал список значений  для переменной index
    public void shouldOpenContentForSelectedItem(int index){
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);// создали объект страницы MainPage
        mainPage.openSite();// открыли сайт
        mainPage.ClickDrop_down_list(index);//вызвали метод открывающий выпадающий список
        String actualText = mainPage.getAnswerText(index); // проверям текст открывающихся списков
        String expectedText = EXPECTED_ANSWERS[index];
        Assert.assertEquals(expectedText, actualText);




    }
}