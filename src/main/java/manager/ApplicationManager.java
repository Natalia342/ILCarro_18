package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    String browser;
    Properties properties;
    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    //   WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser user;
    HelperSearch search;



    public void init() throws IOException {

        properties.load(new FileReader(new File("src/test/resources/config.properties")));

    //    wd = new ChromeDriver();
        if(browser.equals(BrowserType.CHROME)){
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Testing on Chrome Driver");
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Testing on Firefox Driver");
        }else if(browser.equals(BrowserType.IE)){
            wd = new EventFiringWebDriver(new InternetExplorerDriver());
            logger.info("Testing on InternetExplorer Driver");
        }

        wd.register(new MyListener());//получил доступ к полям MyListener

        user = new HelperUser(wd);
        search = new HelperSearch(wd);

        //wd.navigate().to("https://ilcarro.web.app/search");
        wd.navigate().to(properties.getProperty("web.baseURL"));

        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }
    public  String getEmail(){
        return properties.getProperty("web.email");
    }
    public  String getPassword(){
        return properties.getProperty("web.password");
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
