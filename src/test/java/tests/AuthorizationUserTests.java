package tests;

import data.model.User;
import io.qameta.allure.Description;
import java.util.concurrent.ThreadLocalRandom;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tastbase.TestBase;

public class AuthorizationUserTests extends TestBase {

  private User user;

  @BeforeMethod
  private void insurePrecondition() {
    String pref = String.valueOf(ThreadLocalRandom.current().nextInt(1, 1000));

    user = new User()
        .withName("jul" + pref)
        .withEmail("jul" + pref + "@mail.ru")
        .withPassword("12345");

    if (!app.checkDb().isUserLocatedInDb(user.getEmail())) {
      app.api().registerUser(user);
    }
  }

  @Description(value = "Тест на регистрацию нового пользователя")
  @Test
  public void testAuthorizationUser() {
    app.pageStart().btnSignIn();
    app.pageSignIn().fillAuthUser(user);
    app.pageSignIn().btnSignIn();
    app.check().textElement(app.pageStart().getUser(), user.getName().toLowerCase());
    app.pageStart().logout();
  }
}
