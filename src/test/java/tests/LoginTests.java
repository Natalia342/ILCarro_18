package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
 //   @BeforeMethod
//    public void preCondition(){
//        if(app.getUser().isLogged()){
//            app.getUser().logout();
//        }
//    }
    @Test
    public void loginPositiveTest() {
        String email = "natanaym@mail.ru";
        String password = "6392574Nn$";
        app.getUser().openLoginRegistration();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
       Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button[.='Ok']")));

    }

    @Test
    public void loginWrongEmail() {
        String email = "natanaymmail.ru";
        String password = "6392574Nn$";
        app.getUser().openLoginRegistration();
        app.getUser().fillLoginForm(email, password);
        app.getUser().messageError();
        Assert.assertTrue(app.getUser().messageError());

    }

    @Test
    public void loginWrongPassword() {
        String email = "natanaym@mail.ru";
        String password = "6392574";
        app.getUser().openLoginRegistration();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
        //   Assert.assertTrue();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button[.='Ok']")));
    }
    @AfterMethod
    public void tearDown() {
//        wd.quit();
    }
}