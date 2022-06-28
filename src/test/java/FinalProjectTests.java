import Models.Book;
import Models.BookList;
import Models.User;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.xalan.xsltc.compiler.util.VoidType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class FinalProjectTests {

    private SelenideElement item2;

    public WebDriver openBrowser() {
        //open chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    @Test
    public String one() {

        //Add user  https://bookstore.toolsqa.com/Account/v1/User
        String expectedURL = "https://bookstore.toolsqa.com/Account/v1/User";
        User usr = new User();
        usr.username = "Nika";
        usr.password = "NikaTsulu123!";
        Map<String, String> user = new HashMap<String, String>();
        user.put("userName", usr.username);
        user.put("password", usr.password);
        if (usr.books == null) {
            return "NULL";
        }



            //Go to https://demoqa.com/login
            WebDriver driver = openBrowser();
            String url = "https://demoqa.com/login";
            driver.get(url);
            //Login with added account

            WebElement userName = driver.findElement(By.id("Nika"));
            WebElement password = driver.findElement(By.id("NikaTsulu123!"));
            WebElement loginBtn = driver.findElement(By.id("login"));
            userName.sendKeys(createdUser.username);
            password.sendKeys(usr.password);
            System.out.println(loginBtn.getText());
            loginBtn.click();
            driver.close();


            //Go to https://demoqa.com/profile
            //Check that user name is displayed correctly'
            url = "https://demoqa.com/profile";
            driver.get(url);
            driver.findElement(By.id("userName")).sendKeys("Nika");
            driver.findElement(By.id("password")).sendKeys("NikaTsulu123!");
            driver.findElement(By.id("login")).click();

            String expectedURL = "https://www.demoqa.com/login";
            String actualURL = driver.getCurrentUrl();

            if (actualURL.equalsIgnoreCase(expectedURL))
                System.out.println("Test passed !!!!");
            else
                System.out.println("Test failed");
            //Click to 'Go to Book Store'
            driver.get("https://www.demoqa.com/login");
            driver.findElement(By.id("BookStore")).click();
            //Add 'You Don't Know JS' Book
            WebElement searchBox = driver.findElement(By.id("searchBox"));
            searchBox.sendKeys("You Don't Know JS");
            driver.close();
            //Go Back to Profile
            driver.quit();
            driver.findElement(By.id("Login")).click();


        }




