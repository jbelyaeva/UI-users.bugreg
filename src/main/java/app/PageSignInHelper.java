package app;

import data.model.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageSignInHelper extends HelperBase {

  public PageSignInHelper(WebDriver wd) {
    super(wd);
  }

  private final By btnRegistration = By.name("act_register_now");
  private final By inputName = By.name("name");
  private final By inputLogin = By.name("login");
  private final By inputEmail = By.name("email");
  private final By inputPassword = By.xpath(
      "//form[contains(@action,'register')]//input[@name='password']");
  private final By inputAuthPassword = By.xpath(
      "//form[contains(@action,'login')]//input[@name='password']");
  private final By btnSignIn = By.xpath("//input[@value='Авторизоваться']");

  public By getBtnRegistration() {
    return btnRegistration;
  }

  @Step("Заполняем поля для регистрации нового юзера")
  public void fillNewUser(User user, String pref) {
    type(inputName, user.getName() + pref);
    if (!user.getEmail().equals(" ")) {
      type(inputEmail, newEmail(user, pref));
    }
    type(inputPassword, user.getPassword());
  }

  public String newEmail(User user, String pref) {
    if (!user.getEmail().equals(" ")) {
      String[] userSplit = user.getEmail().split("@");
      return userSplit[0] + pref + "@" + userSplit[1];
    } else {
      return "000@00.00";
    }
  }

  @Step("Нажимаем кнопку Зарегистрироваться")
  public void btnRegistration() {
    click(btnRegistration);
  }

  @Step("Заполняем форму на авторизацию")
  public void fillAuthUser(User user) {
    type(inputLogin, user.getEmail());
    type(inputAuthPassword, user.getPassword());
  }

  @Step("Нажимаем кнопку Авторизоваться")
  public void btnSignIn() {
    click(btnSignIn);
  }
}
