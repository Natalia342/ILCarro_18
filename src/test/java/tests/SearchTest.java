package tests;

import models.Search;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{
@Test
public void searchCar(){
//    app.getSearch().searchCity();
    Search search = Search.builder()//stroim po pravilam lombok
            .city("Tel Aviv Israel")
            .dates(" ")
            .build();
    app.getSearch().fillForm(search);
    app.getSearch().submitForm();
   
}
}
