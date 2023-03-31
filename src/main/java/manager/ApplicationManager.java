package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
 //   WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser user;
    HelperSearch search;


    public void init(){

    //    wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
        wd.register(new MyListener());//получил доступ к полям MyListener

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
