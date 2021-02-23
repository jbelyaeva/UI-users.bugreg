package core;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import app.ApiHelper;
import io.qameta.allure.Step;

public class AssertionsApi {

  ApiHelper apiHelper = new ApiHelper();

  public Boolean isUserLocatedInDb(String email) {
    return apiHelper.searchUser(email).getFoundCount() == 1;
  }

  @Step("Проверка, что юзер есть в бд")
  public void findUserByEmail(String email) {
    assertThat(isUserLocatedInDb(email), is(true));
  }

  @Step("Проверка, что юзера нет в бд")
  public void notFindUserByEmail(String email) {
    assertThat(isUserLocatedInDb(email), is(false));
  }
}
