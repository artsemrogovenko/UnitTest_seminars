package seminars.five;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1. Открывает главную страницу Google.
 * 2. Вводит "Selenium" в поисковую строку и нажимает кнопку "Поиск в Google".
 * 3. В результатах поиска ищет ссылку на официальный сайт Selenium
 * (https://www.selenium.dev) и проверяет, что ссылка действительно присутствует среди
 * результатов поиска.
 */
public class SeleniumTest {
    @Test
    void selenium() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.google.ru/");
        WebElement webElement = webDriver.findElement(By.name("q"));
        webElement.sendKeys("Selenium");
        webElement.submit();

        webElement = webDriver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/span/a/div/div/div/cite"));

        assertEquals("https://www.selenium.dev", webElement.getText());
        webDriver.quit();
    }

    /**
     * Нужно написать сквозной тест с использованием Selenium, который авторизует пользователя на
     * сайте https://www.saucedemo.com/.
     * Данные для входа - логин: "standard_user", пароль: "secret_sauce".
     * Проверить, что авторизация прошла успешно и отображаются товары.
     * Вам необходимо использовать WebDriver для открытия страницы и методы sendKeys() для ввода
     * данных в поля формы, и submit() для отправки формы. После этого, проверьте, что на странице
     * отображаются продукты (productsLabel.getText() = "Products").
     */

    @Test
    void testAuthorization() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.saucedemo.com/");

        WebElement webElement = webDriver.findElement(By.name("user-name"));
        webElement.sendKeys("standard_user");
        webElement = webDriver.findElement(By.id("password"));
        webElement.sendKeys("secret_sauce");
        webElement = webDriver.findElement(By.name("login-button"));
        webElement.click();
        webElement = webDriver.findElement(By.className("title"));

        assertEquals("Products", webElement.getText());
        webDriver.quit();
    }


    @Test
    void seleniumSaucedemo() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.saucedemo.com/");
        WebElement login;
        WebElement password;
        WebElement button;

        WebElement result;

        String pass = new String("secret_sauce");
        List<WebElement> loginsElement = webDriver.findElements(By.id("login_credentials"));

        List<String> logins = new ArrayList<>(Arrays.asList(
                loginsElement.stream()
                        .map(WebElement::getText)
                        .map(String::trim)
                        .collect(Collectors.joining("\\n"))
                        .split("\\n")
        ));
        logins.remove(0);


        for (String s : logins) {
            login = webDriver.findElement(By.id("user-name"));
            password = webDriver.findElement(By.id("password"));
            button = webDriver.findElement(By.id("login-button"));
            System.out.printf("login '%s' | pass '%s'\n", s, pass);
            login.sendKeys(s);
            password.sendKeys(pass);
            Thread.sleep(2000);
            button.click();
            try {
                result = webDriver.findElement(By.className("title"));

                assertEquals("Products", result.getText());
            } catch (org.openqa.selenium.NoSuchElementException e) {

            }
            Thread.sleep(2000);
            webDriver.get("https://www.saucedemo.com/");
        }

        webDriver.quit();
    }


}

