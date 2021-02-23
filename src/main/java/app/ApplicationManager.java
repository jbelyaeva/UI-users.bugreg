package app;

import core.Assertions;
import core.AssertionsApi;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

public class ApplicationManager {

  public WebDriver wd;
  private final String browser;
  private Assertions assertions;
  private AssertionsApi assertionsApi;
  private PageSignInHelper pageSignIn;
  private ApiHelper apiHelper;
  private PageStartHelper pageStart;
  public static ProjectConfig config;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() throws IOException {
    config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
    if (browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.GOOGLECHROME)) {
      wd = new ChromeDriver();
    }
    wd.get(config.baseUrl());
    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    wd.manage().window().maximize();
    assertions = new Assertions(wd);
    apiHelper = new ApiHelper();
    assertionsApi = new AssertionsApi();
    pageStart = new PageStartHelper(wd);
    pageSignIn = new PageSignInHelper(wd);
  }

  public void stop() {
    wd.quit();
  }

  public Assertions check() {
    return assertions;
  }

  public AssertionsApi checkDb() {
    return assertionsApi;
  }

  public PageSignInHelper pageSignIn() {
    return pageSignIn;
  }

  public PageStartHelper pageStart() {
    return pageStart;
  }

  public ApiHelper api() {
    return apiHelper;
  }

  public byte[] takeScreenshot() {
    return ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
  }
}
