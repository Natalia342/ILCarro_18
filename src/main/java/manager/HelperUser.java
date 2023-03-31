package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void openLoginForm() {
        //     wd.findElement(By.xpath("//a[@href='/login']")).click();
        click(By.xpath("//a[.=' Log in ']"));
    }
    public void openRegistrationForm() {
        //     wd.findElement(By.xpath("//a[@href='/login']")).click();
        click(By.xpath("//a[.=' Sign up ']"));
    }
    public void fillLoginForm(String email,String password){
        type(By.cssSelector("#email"),email);
        type(By.cssSelector("#password"),password);
    }
    public void fillLoginForm(User data){
        type(By.cssSelector("#email"),data.getEmail());
     //   type(By.cssSelector("#ema"),data.getEmail());
        type(By.cssSelector("#password"), data.getPassword());
    }
    public void fillRegistrationForm(String name, String lastName,String email,String password){
        type(By.cssSelector("#name"),name);
        type(By.cssSelector("#lastName"),lastName);
        type(By.cssSelector("#email"),email);
        type(By.cssSelector("#password"),password);
    }
    public void fillRegistrationForm(User user){
        type(By.cssSelector("#name"), user.getName());
        type(By.cssSelector("#lastName"), user.getLastName());
        type(By.cssSelector("#email"), user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }
 //   public void submitRegistration(){
 //       click(By.xpath("//button[2]"));
 //   }

        //     click(By.linkText("Y’alla!"));
    //    click(By.xpath("//button[.=\"Y’alla!\"]"));

  //  public boolean messageError()
  //  { return isElementPresent (By.xpath("//div[.=\"It'snot look like email\"]"));

  //  }
    public void clickCheckbox() {
        //variant 1
   // click(By.xpath("//label[@class='checkbox-label terms-label']"));
      //variant 2
    //    JavascriptExecutor script = (JavascriptExecutor) wd;
    //    script.executeScript("document.querySelector('#terms-of-use').click();");
        //variant 3
        Rectangle rect = wd.findElement(By.xpath("//*[@class='checkbox-container']")).getRect();//metod polychaet koordinat
        int x = rect.getX()+ 5;// прочитай по х координаты нашего обьукта, сдвинся на 5 пикселей и положи его координаты
        int y = rect.getY()+5;
        Actions actions = new Actions(wd);
        actions.moveByOffset(x,y).click().perform();
    }

//
    public boolean isLoggedSuccessful() {
        WebDriverWait wait = new WebDriverWait(wd,10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h2[.='Logged in success']"))));
        return wd.findElement(By.xpath("//h2[.='Logged in success']")).getText().contains("success");
    }
    public boolean isRegistrationSuccessful() {
        WebDriverWait wait = new WebDriverWait(wd,10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h2[.='You are logged in success']"))));
        return wd.findElement(By.xpath("//h2[.='You are logged in success']")).getText().contains("success");
    }
    public void clickOkButton(){
        if (isElementPresent(By.xpath("//button[.='Ok']"))){
            click(By.xpath("//button[.='Ok']"));
        }
    }
    public boolean isLoggedFailed() {
        WebDriverWait wait = new WebDriverWait(wd,10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//div[.=\"It'snot look like email\"]"))));
        return wd.findElement(By.xpath("//div[.=\"It'snot look like email\"]")).getText().contains("like email");

    }
    public boolean isRegistrationFailedEmail() {
        WebDriverWait wait = new WebDriverWait(wd,10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//div[.='Wrong email format']"))));
        return wd.findElement(By.xpath("//div[.='Wrong email format']")).getText().contains("email format");

    }

    public boolean isRegistrationFailedPassword() {
        WebDriverWait wait = new WebDriverWait(wd,10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//div[.='Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]']"))));
        return wd.findElement(By.xpath("//div[.='Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]']")).getText().contains("number and one special symbol");
    }
}
