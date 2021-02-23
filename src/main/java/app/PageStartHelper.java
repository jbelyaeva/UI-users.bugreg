package app;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageStartHelper extends HelperBase {

  private final By btnSignIn = By.xpath("//a[contains(@href,'login')]");
  private final By user = By.xpath("//li[@id='fat-menu']//a");
  private final By btnTasks = By.xpath("//div[@id='main-menu']//a[contains(@href,'tasks')]");
  private final By btnExit = By.xpath("//a[contains(@href,'logout')]");

  public PageStartHelper(WebDriver wd) {
    super(wd);
  }

  public By getUser() {
    return user;
  }

  public By getBtnTasks() {
    return btnTasks;
  }

  @Step("Нажимаем на кнопку Войти")
  public void btnSignIn() {
    click(btnSignIn);
  }

  @Step("Разлогируемся")
  public void logout() {
    click(user);
    click(btnExit);
  }
}
