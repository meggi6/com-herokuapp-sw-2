package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Create the package ‘testsuite’ and create the following class inside
 *  * the ‘testsuite’ package. 1. LoginTest
 *  * 3. Write down the following test into ‘LoginTest’ class
 *  * 1. userSholdLoginSuccessfullyWithValidCredentials * Enter “tomsmith” username
 *  * * Enter “SuperSecretPassword!” password * Click on ‘LOGIN’ button
 *  * * Verify the text “Secure Area”
 *  2. verifyTheUsernameErrorMessage
 *  * * Enter “tomsmith1” username * Enter “SuperSecretPassword!” password
 *  * * Click on ‘LOGIN’ button * Verify the error message “Your username is invalid!”
 *  * 3. verifyThePasswordErrorMessage * Enter “tomsmith” username
 *  * * Enter “SuperSecretPassword” password * Click on ‘LOGIN’ button
 *  * * Verify the error message “Your password is invalid!”
 */
public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    //Before annotation run in the beginning of all tests
    @Before
    //Browser set-up method
    public void setUp(){
        openBrowser(baseUrl);
    }

    //After annotation method run at the end of all tests
    @After
    //Browser closing method
    public void tearDown(){
        closeBrowser();
    }

    //Test annotation for executing the method
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        //Find username field element and enter username
        WebElement userNameFieldElement = driver.findElement(By.id("username"));
        userNameFieldElement.sendKeys("tomsmith");
        //Find password field element and enter password
        WebElement passwordFieldElement = driver.findElement(By.name("password"));
        passwordFieldElement.sendKeys("SuperSecretPassword!");
        //Find login button element and click on it
        WebElement loginButtonElement = driver.findElement(By.tagName("button"));
        loginButtonElement.click();
        //Expected text according to requirement
        String expectedSecureText = "Secure Area";
        //Find Secure Area text element and get it's text
        WebElement secureAreaTextElement = driver.findElement(By.xpath(" //h2[text() = ' Secure Area']"));
        String actualSecureText = secureAreaTextElement.getText();
        //Verify expected and actual text
        Assert.assertEquals("Text is not matching", expectedSecureText, actualSecureText);
    }

    //Test annotation for executing the method
    @Test
    public void verifyTheUsernameErrorMessage(){
        //Find username field element and enter invalid username
        WebElement userNameFieldElement = driver.findElement(By.id("username"));
        userNameFieldElement.sendKeys("tomsmith1");
        //Find password field element and enter password
        WebElement passwordFieldElement = driver.findElement(By.name("password"));
        passwordFieldElement.sendKeys("SuperSecretPassword!");
        //Find login button element and click on it
        WebElement loginButtonElement = driver.findElement(By.tagName("button"));
        loginButtonElement.click();
        //Expected Invalid username message according to requirement
        String expectedUserNameErrorMessageText = "Your username is invalid!";
        //Find Invalid username message text element and get it's text
        WebElement userNameErrorMessageTextElement = driver.findElement(By.className("flash"));
        String actualUserNameErrorMessageText = userNameErrorMessageTextElement.getText();
        //Verify expected and actual text
        Assert.assertEquals("Invalid username text is not matching", expectedUserNameErrorMessageText, actualUserNameErrorMessageText);
    }

    //Test annotation for executing the method
    @Test
    public void verifyThePasswordErrorMessage(){
        //Find username field element and enter username
        WebElement userNameFieldElement = driver.findElement(By.id("username"));
        userNameFieldElement.sendKeys("tomsmith");
        //Find password field element and enter invalid password
        WebElement passwordFieldElement = driver.findElement(By.name("password"));
        passwordFieldElement.sendKeys("SuperSecretPassword");
        //Find login button element and click on it
        WebElement loginButtonElement = driver.findElement(By.tagName("button"));
        loginButtonElement.click();
        //Expected invalid password message according to requirement
        String expectedInvalidPasswordMessageText = "Your password is invalid!";
        //Find Invalid password message text element and get it's text
        WebElement invalidPasswordErrorTextElement = driver.findElement(By.className("error"));
        String actualInvalidPasswordMessageText = invalidPasswordErrorTextElement.getText();
        //Verify expected and actual text
        Assert.assertEquals("Invalid password text is not matching", expectedInvalidPasswordMessageText, actualInvalidPasswordMessageText);
    }
}
