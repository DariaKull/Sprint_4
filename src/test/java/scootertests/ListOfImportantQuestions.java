package scootertests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import ru.praktikum_services.qa_scooter.MainPage;
import java.util.concurrent.TimeUnit;


public class ListOfImportantQuestions {
    WebDriver driver;
    private void assertEquals(String s, String expected, String actual) {
    }

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
    public void compareAnswerHowMuch() {
        MainPage mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainPage.scrollToImportantQuestionsBlock();
        String actual = mainPage.getAnswerHowMuch();
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        Assert.assertEquals("Не верный текст ответа на вопрос", expected, actual);
    }
    @Test
    public void compareAnswerSeveralScooters() {
        MainPage mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainPage.scrollToImportantQuestionsBlock();
        String actual = mainPage.getAnswerSeveralScooters();
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        Assert.assertEquals("Не верный текст ответа на вопрос", expected, actual);
    }
    @Test
    public void compareAnswerRentalTime() {
        MainPage mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainPage.scrollToImportantQuestionsBlock();
        String actual = mainPage.getAnswerRentalTime();
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        Assert.assertEquals("Не верный текст ответа на вопрос", expected, actual);
    }
    @Test
    public void compareAnswerOrderToday() {
        MainPage mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainPage.scrollToImportantQuestionsBlock();
        String actual = mainPage.getAnswerOrderToday();
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        Assert.assertEquals("Не верный текст ответа на вопрос", expected, actual);
    }
    @Test
    public void compareAnswerExtendOrReturn() {
        MainPage mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainPage.scrollToImportantQuestionsBlock();
        String actual = mainPage.getAnswerExtendOrReturn();
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        Assert.assertEquals("Не верный текст ответа на вопрос", expected, actual);
    }
    @Test
    public void compareAnswerScooterCharging() {
        MainPage mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainPage.scrollToImportantQuestionsBlock();
        String actual = mainPage.getAnswerScooterCharging();
        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        Assert.assertEquals("Не верный текст ответа на вопрос", expected, actual);
    }
    @Test
    public void compareAnswerCancelOrder() {
        MainPage mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainPage.scrollToImportantQuestionsBlock();
        String actual = mainPage.getAnswerCancelOrder();
        String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        Assert.assertEquals("Не верный текст ответа на вопрос", expected, actual);
    }
    @Test
    public void compareAnswerOutOfMKAD() {
        MainPage mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainPage.scrollToImportantQuestionsBlock();
        String actual = mainPage.getAnswerOutOfMKAD();
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        Assert.assertEquals("Не верный текст ответа на вопрос", expected, actual);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}