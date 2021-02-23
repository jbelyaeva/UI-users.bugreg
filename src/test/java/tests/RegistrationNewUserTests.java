package tests;

import data.ProviderData;
import data.model.User;
import io.qameta.allure.Description;
import java.util.concurrent.ThreadLocalRandom;
import org.testng.annotations.Test;
import tastbase.TestBase;

public class RegistrationNewUserTests extends TestBase {

  @Description(value = "Тест на регистрацию нового пользователя")
  @Test(dataProvider = "validUserDataJson", dataProviderClass = ProviderData.class)
  public void testRegistrationNewUser(User user) {
    String pref = String.valueOf(ThreadLocalRandom.current().nextInt(1, 1000));

    app.pageStart().btnSignIn();
    app.pageSignIn().fillNewUser(user, pref);
    app.pageSignIn().btnRegistration();
    app.check().textElement(app.pageStart().getUser(), user.getName().toLowerCase() + pref);
    app.checkDb().findUserByEmail(app.pageSignIn().newEmail(user, pref));
    app.pageStart().logout();
  }

  @Description(value = "Тест на проверку заполнения обязательных полей при создании нового пользователя")
  @Test(dataProvider = "noValidUserDataJson", dataProviderClass = ProviderData.class)
  public void testRegistrationBadNewUser(User user) {
    String pref = "";
    app.pageStart().btnSignIn();
    app.pageSignIn().fillNewUser(user, pref);
    app.pageSignIn().btnRegistration();
    app.check().findElement(app.pageSignIn().getBtnRegistration());
    app.pageStart().btnSignIn();
    app.checkDb().notFindUserByEmail(app.pageSignIn().newEmail(user, pref));
  }
}
