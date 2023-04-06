package tests;

import manager.NGListener;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners(NGListener.class)
public class LoginTests extends TestBase {
    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }
    @Test
    public void loginPositiveTest() {
 //       String email = "natanaym@mail.ru";
 //       String password = "6392574Nn$";
        User data = new User().withEmail("natanaym@mail.ru").withPassword("6392574Nn$");
        app.getUser().openLoginForm();
 //       app.getUser().fillLoginForm("natanaym@mail.ru","6392574Nn$" );
        app.getUser().fillLoginForm(data);
        app.getUser().submitForm();
        Assert.assertTrue(app.getUser().isLoggedSuccessful());
    //   Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button[.='Ok']")));

    }

    @Test
    public void loginWrongEmail() {
        User data = new User()
                .withEmail("natanaymmail.ru")
                .withPassword("6392574Nn$");
    //    String email = "natanaymmail.ru";
    //    String password = "6392574Nn$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(data);
        app.getUser().submitForm();
      //  app.getUser().pause(5);
        Assert.assertTrue(app.getUser().isLoggedFailed());

    }

    @Test
    public void loginWrongPassword() {
        User data=new User()
                .withEmail("natanaym@mail.ru")
                .withPassword("6392574");
    //    String email = "natanaym@mail.ru";
    //    String password = "6392574";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(data);
        app.getUser().submitForm();
       // Assert.assertTrue(app.getUser().isLoggedSuccessful());
       Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button[.='Ok']")));
    }

    @AfterMethod
    public void postCondition() {
      app.getUser().clickOkButton();
    }
}