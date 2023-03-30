package scootertests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.praktikum_services.qa_scooter.MainPage;
import ru.praktikum_services.qa_scooter.OrderForm;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class ScooterOrder {
    private final String firstName;
    private final String secondName;
    private final String address;
    private final String phone;
    private final String station;
    private final String date;

    private final String comment;

    public ScooterOrder(String firstName, String secondName, String address, String phone, String station, String date, String comment) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.phone = phone;
        this.station = station;
        this.date = date;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] orderData() {
        return new Object[][]{
                {"Мария", "Самсонова", "Мира 16", "+79273617509", "Лубянка", "25.05.2025", "Оплата картой"},
                {"Андрей", "Сидоренко", "г.Москва, ул. Толостого 14-98", "89992221456", "Царицыно", "16.11.2024", "Оплата будет наличными"},
                {"Анна", "Йосилевич", "Проспект Вернадского корпус.2 строение 15", "88412650379", "Китай-город", "08/06/2026", "Курьер, покатаешься вместе со мной?"}
        };
    }

    WebDriver driver;

    @Before
    public void setUp() {
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }

    @Test
    public void orderFlowByClickingTopOrderButton() {
        MainPage mainPage = new MainPage(driver);
        OrderForm orderForm = new OrderForm(driver);
        mainPage.clickCreateOrderButtonInHeader();
        orderForm.addOrderData(firstName, secondName, address, phone, station, date, comment);
        String actual = orderForm.getNotification();
        String expected = "Заказ оформлен";
        MatcherAssert.assertThat(actual, containsString(expected));
    }

    @Test
    public void orderFlowByClickingMiddleOrderButton() {
        MainPage mainPage = new MainPage(driver);
        OrderForm orderForm = new OrderForm(driver);
        mainPage.clickCreateOrderButtonOnPage();
        orderForm.addOrderData(firstName, secondName, address, phone, station, date, comment);
        String actual = orderForm.getNotification();
        String expected = "Заказ оформлен";
        MatcherAssert.assertThat(actual, containsString(expected));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
