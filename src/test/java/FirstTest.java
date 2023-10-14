import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;


public class FirstTest {

    WebDriver driver = null;
    Wait<WebDriver> wait = null;


    @Test
    public void testWiki(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));



        driver.navigate().to("https://www.wikipedia.org");

        WebElement searchInput = driver.findElement(By.id("searchInput"));
        WebElement searchbutton = driver.findElement(By.cssSelector("#search-form > fieldset > button > i"));

        searchInput.sendKeys("enrique");
        searchbutton.click();

        WebElement title = driver.findElement(By.cssSelector("#firstHeading > span"));

        Assert.assertEquals(title.getText(),"Enrique");


        List<WebElement> links = driver.findElements(By.cssSelector("a"));

        for (WebElement link : links) {
            System.out.println(link.getText());
        }
    }

    @Test
    public void eightComponents() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String title = driver.getTitle();
        Assert.assertEquals("Web form", title);

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        String value = message.getText();
        Assert.assertEquals("Received!", value);

        driver.quit();
    }

    @Test
    public void demoblazeSignUp() throws InterruptedException {
        /*
        Successful Sign Up

Navigating to About Us Section and playing the video there

Selecting and completing the buying process of any laptop on the website.

Make sure to group on the document the respective selectors according to the page or view they are located on.
The CSS must be as efficient and maintainable as possible.
         */
        WebDriver driver = new ChromeDriver();
        wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(2)).
                ignoring(NoSuchElementException.class);

        driver.get("https://demoblaze.com/");

        WebElement signUpButton = driver.findElement(By.cssSelector("#signin2"));
        signUpButton.click();

        WebElement userNameBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sign-username")));
        WebElement paswordBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sign-password")));

        userNameBox.sendKeys("EnriqueKu");
        paswordBox.sendKeys("12345");

        WebElement signUpRegister = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("button[onclick='register()'].btn.btn-primary")));

        signUpRegister.click();

        Thread.sleep(4000);
        driver.close();
    }

    @Test
    public void demoblazePlayVideo() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(2)).
                ignoring(NoSuchElementException.class);

        driver.get("https://demoblaze.com/");


        WebElement aboutUs = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("a.nav-link[data-target='#videoModal']")));

        aboutUs.click();

        WebElement playButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("button.vjs-big-play-button[title='Play Video']")));
        playButton.click();

        Thread.sleep(4000);

        driver.close();
    }

    @Test
    public void demoblazerBuyingLaptop() throws InterruptedException{
         driver = new ChromeDriver();
         wait = new FluentWait<>(driver).
                 withTimeout(Duration.ofSeconds(8))
                 .pollingEvery(Duration.ofSeconds(2))
                 .ignoring(NoSuchElementException.class);

         driver.get("https://demoblaze.com/");
         driver.manage().window().maximize();


         WebElement laptopsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                 By.cssSelector("#itemc[onclick=\"byCat('notebook')\"]")));
         laptopsButton.click();


         WebElement laptop = wait.until(ExpectedConditions.visibilityOfElementLocated(
                 By.linkText("MacBook Pro")));
         laptop.click();

         WebElement addCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                 By.cssSelector("a.btn.btn-success.btn-lg")));
         addCartButton.click();

         driver.navigate().refresh();

         WebElement cartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                 By.cssSelector("#cartur")));
         cartButton.click();

         WebElement placeOrderButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                 By.cssSelector("button.btn.btn-success")));
         placeOrderButton.click();

         WebElement nameBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                 By.cssSelector("#name")));
         WebElement countryBox = driver.findElement(By.cssSelector("#country"));
        WebElement cityBox = driver.findElement(By.cssSelector("#city"));
        WebElement creditCardBox = driver.findElement(By.cssSelector("#card"));
        WebElement monthBox = driver.findElement(By.cssSelector("#month"));
        WebElement yearBox = driver.findElement(By.cssSelector("#year"));
        WebElement purchaseButton = driver.findElement(By.cssSelector("button[onclick='purchaseOrder()']"));

        nameBox.sendKeys("Enrique");
        countryBox.sendKeys("Mex");
        cityBox.sendKeys("Merida");
        creditCardBox.sendKeys("1234567890");
        monthBox.sendKeys("11");
        yearBox.sendKeys("2023");
        purchaseButton.click();

        driver.quit();

    }


}
