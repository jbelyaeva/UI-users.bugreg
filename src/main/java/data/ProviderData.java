package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.model.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.DataProvider;

public class ProviderData {

  @DataProvider(name = "validUserDataJson")
  public static Iterator<Object[]> validUserDataJson() throws IOException {
    try (BufferedReader reader =
        new BufferedReader(
            new FileReader(new File("src/test/resources/testdata/user_creation.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<User> users = gson.fromJson(json, new TypeToken<List<User>>() {
      }.getType());
      return users.stream()
          .map((user) -> new Object[]{user})
          .collect(Collectors.toList())
          .iterator();
    }
  }

  @DataProvider(name = "noValidUserDataJson")
  public static Iterator<Object[]> noValidUserDataJson() throws IOException {
    try (BufferedReader reader =
        new BufferedReader(
            new FileReader(new File("src/test/resources/testdata/user_bad_creation.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<User> users = gson.fromJson(json, new TypeToken<List<User>>() {
      }.getType());
      return users.stream()
          .map((user) -> new Object[]{user})
          .collect(Collectors.toList())
          .iterator();
    }
  }


}
