package tests;

import manager.NGListener;
import manager.ProviderData;
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
    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }
    @Test()
    public void loginPositiveTestConfig() {

        app.getUser().openLoginForm();
        //       app.getUser().fillLoginForm("natanaym@mail.ru","6392574Nn$" );
        app.getUser().fillLoginForm(app.getEmail(), app.getPassword());
        app.getUser().submitForm();
        Assert.assertTrue(app.getUser().isLoggedSuccessful());
        //   Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button[.='Ok']")));
    }
    @Test(dataProvider = "loginModelDto",dataProviderClass = ProviderData.class, invocationCount = 3, groups = {"smoke"})//Dto - data,transfer,object
    public void loginPositiveTest(User data) {
 //       String email = "natanaym@mail.ru";
 //       String password = "6392574Nn$";
 //       User data = new User().withEmail("natanaym@mail.ru").withPassword("6392574Nn$");
        app.getUser().openLoginForm();
 //       app.getUser().fillLoginForm("natanaym@mail.ru","6392574Nn$" );
        app.getUser().fillLoginForm(data);
        app.getUser().submitForm();
        Assert.assertTrue(app.getUser().isLoggedSuccessful());
    //   Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button[.='Ok']")));

    }

    @Test(groups = {"smoke", "regress"})
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

    @Test(groups = {"regress"})
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

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
      app.getUser().clickOkButton();
    }
}