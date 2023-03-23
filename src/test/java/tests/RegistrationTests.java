package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }
@Test
    public void registrationPositiveTest(){
    app.getUser().openRegistrationForm();
    int i = (int)(System.currentTimeMillis() / 1000) % 3600;
    User user = new User()
            .withName("Ma"+i+"Na")
            .withLastName("Shu"+i+"sha")
            .withEmail("nat"+i+"@mail.ru")
            .withPassword("63457"+i+"Ss$");
 //   String name = "Ma"+i+"Na";
 //   String lastName = "Shu"+i+"sha";
 //   String email = "nat"+i+"@mail.ru";
 //   String password = "63457"+i+"Ss$";

    app.getUser().fillRegistrationForm(user);
    app.getUser().clickCheckbox();
    app.getUser().submitForm();
    Assert.assertTrue(app.getUser().isRegistrationSuccessful());
}
@Test
    public void RegistrationWrongEmail(){
    app.getUser().openRegistrationForm();
    User user = new User()
            .withName("MamyNa")
            .withLastName("Shushanna")
            .withEmail("shushmail.ru")
            .withPassword("63457478Ss$");
 //   String name = "MamyNa";
 //   String lastName = "Shushanna";
 //   String email = "shushmail.ru";
 //   String password = "63457478Ss$";
    app.getUser().fillRegistrationForm(user);
    app.getUser().clickCheckbox();
    app.getUser().submitForm();//Bag, click on button Y'alla
    Assert.assertTrue(app.getUser().isRegistrationFailedEmail());
}
    @Test
    public void RegistrationWrongPassword(){
        app.getUser().openRegistrationForm();
        User user = new User()
                .withName("MamyNa")
                .withLastName("Shushanna")
                .withEmail("shush@mail.ru")
                .withPassword("63457478Ss");
   //     String name = "MamyNa";
   //     String lastName = "Shushanna";
   //     String email = "shush@mail.ru";
   //     String password = "63457478Ss";
        app.getUser().fillRegistrationForm(user);
        app.getUser().clickCheckbox();
        app.getUser().submitForm();//Bag, click on button Y'alla
        Assert.assertTrue(app.getUser().isRegistrationFailedPassword());
    }
    @AfterMethod
    public void postCondition() {
        app.getUser().clickOkButton();
    }
}
