package manager;

import models.Search;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase {
    public HelperSearch(WebDriver wd) {
        super(wd);
    }
    //   public void searchCity(){click(By.cssSelector("#city"));

    //    }
    public void fillForm(Search search) {
        typeCity(search.getCity());
        type(By.cssSelector("#city"), search.getCity());
        type(By.cssSelector("#dates"), search.getDates());
        calendar();
    }

    private void typeCity(String city) {
        type(By.cssSelector("#city"), city);
        click(By.cssSelector(".pac-item"));
        //    click(By.xpath("//div[@class='pac-item']"));
        pause(500);
        //variant 2, padaet
     //   JavascriptExecutor script = (JavascriptExecutor) wd;
     //   script.executeScript("document.querySelector('.pac-item').click();");
    }


    private void calendar() {
        click(By.xpath("//td[.=' 29 ']"));
        click(By.xpath("//td[.=' 31 ']"));
    }


}
