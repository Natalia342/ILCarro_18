package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void logout(){
        click(By.xpath("//a[.=' Logout ']"));
    }
    public boolean isLogged(){
        return isElementPresent(By.xpath("//a[.=' Logout ']"));
    }

    public void openLoginRegistration() {
        //     wd.findElement(By.xpath("//a[@href='/login']")).click();
        click(By.xpath("//a[.=' Log in ']"));
    }
    public void fillLoginForm(String email,String password){
        type(By.cssSelector("#email"),email);
        type(By.cssSelector("#password"),password);
    }
 //   public void submitRegistration(){
 //       click(By.xpath("//button[2]"));
 //   }
    public void submitLogin(){
   //     click(By.xpath("//button[contains(.,\"Y’alla!\")]"));
        click(By.cssSelector("button[type='submit']"));
   //     click(By.linkText("Y’alla!"));
    //    click(By.xpath("//button[.=\"Y’alla!\"]"));
    }
    public boolean messageError()
    { return isElementPresent (By.xpath("//div[.=\"It'snot look like email\"]"));

    }
}
