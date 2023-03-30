package ru.praktikum_services.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class MainPage {
    private static WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    private By OrderTopButton = By.className("Button_Button__ra12g");
    private By CookiesAccept = By.xpath(".//button[@class='App_CookieButton__3cvqF']");
    private By HowItWorksBlock = By.className("Home_RoadMap__2tal_");
    private By OrderButtonOnPage = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    private By FQA = By.xpath("//div[@class='accordion']");
    //аккаордеон "Сколько это стоит? И как оплатить?"
    private static By HowMuchAccordionQuestion = By.id("accordion__heading-0");
    private static By HowMuchAnswer = By.id("accordion__panel-0");

    //аккордеон "Хочу сразу несколько самокатов! Так можно?"
    private static By SeveralScootersAccordionQuestion = By.id("accordion__heading-1");
    private static By SeveralScootersAnswer = By.id("accordion__panel-1");

    //аккордеон "Как рассчитывается время аренды"
    private static By RentalTimeAccordionQuestion = By.id("accordion__heading-2");
    private static By RentalTimeAnswer = By.id("accordion__panel-2");

    //аккордеон "Можно ли заказать самокат прямо на сегодня?"
    private static By OrderTodayAccordionQuestion = By.id("accordion__heading-3");
    private static By OrderTodayAnswer = By.id("accordion__panel-3");

    //аккордеон "Можно ли продлить заказ или вернуть самокат раньше?"
    private static By ExtendOrReturnAccordionQuestion = By.id("accordion__heading-4");
    private static By ExtendOrReturnAnswer = By.id("accordion__panel-4");

    //аккордеон "Вы привозите зарядку вместе с самокатом?"
    private static By ScooterChargingAccordionQuestion = By.id("accordion__heading-5");
    private static By ScooterChargingAnswer = By.id("accordion__panel-5");

    //аккордеон "Можно ли отменить заказ?"
    private static By CancelOrderAccordionQuestion = By.id("accordion__heading-6");
    private static By CancelOrderAnswer = By.id("accordion__panel-6");

    //аккаордеон "Я живу за МКАДом, привезёте?"
    private static By OutOfMKADAccordionQuestion = By.id("accordion__heading-7");
    private static By OutOfMKADAccordionAnswer = By.id("accordion__panel-7");

    // Скролл к разделу "Вопросы о важном"
    public void scrollToImportantQuestionsBlock() {
        WebElement element = webDriver.findElement(FQA);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Нажать и узнать ответ
    public static String getAnswerHowMuch() {
        webDriver.findElement(HowMuchAccordionQuestion).click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String answer = webDriver.findElement(HowMuchAnswer).getText();
        return answer;
    }
    public static String getAnswerSeveralScooters() {
        webDriver.findElement(SeveralScootersAccordionQuestion).click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String answer1 = webDriver.findElement(SeveralScootersAnswer).getText();
        return answer1;
    }
    public static String getAnswerRentalTime() {
        webDriver.findElement(RentalTimeAccordionQuestion).click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String answer2 = webDriver.findElement(RentalTimeAnswer).getText();
        return answer2;
    }
    public static String getAnswerOrderToday() {
        webDriver.findElement(OrderTodayAccordionQuestion).click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String answer3 = webDriver.findElement(OrderTodayAnswer).getText();
        return answer3;
    }
    public static String getAnswerExtendOrReturn() {
        webDriver.findElement(ExtendOrReturnAccordionQuestion).click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String answer4 = webDriver.findElement(ExtendOrReturnAnswer).getText();
        return answer4;
    }
    public static String getAnswerScooterCharging() {
        webDriver.findElement(ScooterChargingAccordionQuestion).click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String answer5 = webDriver.findElement(ScooterChargingAnswer).getText();
        return answer5;
    }
    public static String getAnswerCancelOrder() {
        webDriver.findElement(CancelOrderAccordionQuestion).click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String answer6 = webDriver.findElement(CancelOrderAnswer).getText();
        return answer6;
    }
    public static String getAnswerOutOfMKAD() {
        WebElement element = webDriver.findElement(OutOfMKADAccordionQuestion);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        webDriver.findElement(OutOfMKADAccordionQuestion).click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String answer7 = webDriver.findElement(OutOfMKADAccordionAnswer).getText();
        return answer7;
    }

    //клик по кнопке "Заказ" вверху
    public void clickCreateOrderButtonInHeader() {
        webDriver.findElement(OrderTopButton).click();
    }

    //нажатие кнопки заказать в блоке "Как это работает" (скролл + нажатие)
    public void clickCreateOrderButtonOnPage() {
        webDriver.findElement(CookiesAccept).click();
        WebElement element = webDriver.findElement(HowItWorksBlock);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(OrderButtonOnPage).click();
    }
}