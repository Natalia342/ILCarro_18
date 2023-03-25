package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    HelperUser user;
    HelperSearch search;


    public void init(){
        wd = new ChromeDriver();
        user = new HelperUser(wd);
        search = new HelperSearch(wd);

        wd.navigate().to("https://ilcarro.web.app/search");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }
    public void stop(){
    //    wd.quit();
    }
    public HelperUser getUser(){
        return user;
    }
    public HelperSearch getSearch(){
        return search;
    }
}
