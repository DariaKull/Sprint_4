package ru.praktikum_services.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class OrderForm {
    private static WebDriver webDriver;
    public OrderForm(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public OrderForm() {

    }

    //поле "Имя"
    private By FirstNameField = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Имя']");
    //поле "Фамилия"
    private By SecondNameField = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Фамилия']");
    //поле "Адресс"
    private By AddressField = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Адрес: куда привезти заказ']");
    //выпадающий список "Станция метро"
    private By MetroStationList = By.xpath(".//div[@class='select-search__value']/input[@placeholder='* Станция метро']");
    private By MetroStationField = By.xpath(".//div[@class='select-search__select']");

    //поле "Телефон"
    private By PhoneField = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Телефон: на него позвонит курьер']");

    //кнопка "Далее"
    private By NextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");

    //поле "Комментарий курьера"
    private By CommentField = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='Комментарий для курьера']");
    //"Календарь"
    private By Calendar = By.xpath(".//div[@class='react-datepicker__input-container']/input[@placeholder='* Когда привезти самокат']");

    //Срок аренды
    private By Caledar = By.xpath(".//div[@class='react-datepicker__input-container']/input[@placeholder='* Когда привезти самокат']");

    private By OutOfFieldArea = By.xpath(".//div[@class='Order_Content__bmtHS']");

    //кнопка "Заказать"
    private By RentPeriod = By.xpath(".//div[@class='Dropdown-placeholder']");
    private By ChooseRentPeriod = By.xpath("//div[@class='Dropdown-menu']/div[@role='option'][2]");
    private By Color = By.xpath("//div[@class='Order_Checkboxes__3lWSI']//input[@id='black']");
    private By OrderButtonOnForm = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // кнопка подтверждения оформления "Да"
    private By ConfirmOrder = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    private static By Notification = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");

    //Метод ввода данных
    private String firstName;
    private String secondName;
    private String address;
    private String phone;
    private String station;
    private String date;
    private String comment;

    public void addOrderData(String firstName, String secondName, String address, String phone, String station, String date, String comment){
        webDriver.findElement(FirstNameField).sendKeys(firstName);
        webDriver.findElement(SecondNameField).sendKeys(secondName);
        webDriver.findElement(AddressField).sendKeys(address);
        webDriver.findElement(PhoneField).sendKeys(phone);
        webDriver.findElement(MetroStationList).click();
        webDriver.findElement(MetroStationList).sendKeys(station);
        webDriver.findElement(MetroStationField).click();
        webDriver.findElement(NextButton).click();
        webDriver.findElement(CommentField).sendKeys(comment);
        webDriver.findElement(Calendar).click();
        webDriver.findElement(Calendar).sendKeys(date);
        webDriver.findElement(OutOfFieldArea).click();
        webDriver.findElement(RentPeriod).click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(ChooseRentPeriod).click();
        webDriver.findElement(Color).click();
        webDriver.findElement(OrderButtonOnForm).click();
        webDriver.findElement(ConfirmOrder).click();
    }

    public static String getNotification() {
        WebElement element = webDriver.findElement(Notification);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        webDriver.findElement(Notification).click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String answerOfOrder = webDriver.findElement(Notification).getText();
        return answerOfOrder;
    }
}
