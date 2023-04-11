package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {

@DataProvider
    public Iterator<Object[]> loginModelDto(){
    List<Object[]> list = new ArrayList<>();//sozdali kollekziy
    list.add(new Object[]{
       new User().withEmail("natanaym@mail.ru").withPassword("6392574Nn$")});
    list.add(new Object[]{
            new User().withEmail("natanaym@mail.ru").withPassword("6392574Nn$")});
    list.add(new Object[]{
            new User().withEmail("natanaym@mail.ru").withPassword("6392574Nn$")});

    return list.iterator();
  }
    @DataProvider//po files.csv
    public Iterator<Object[]> registrationCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();//sozdali kollekziy

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));

        String line = reader.readLine();

        while (line!=null){
        String[] split = line.split(",");
        list.add(new Object[]{new User().withName(split[0]).withLastName(split[1])
                .withEmail(split[2]).withPassword(split[3])});
        line = reader.readLine();

        }

        return list.iterator();
    }
}
