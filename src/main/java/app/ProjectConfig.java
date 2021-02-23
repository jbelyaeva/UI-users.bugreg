package app;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:local.properties"})
public interface ProjectConfig extends Config {
   @Key("web.baseUrl")
   String baseUrl();

   @Key("urlSearchUserApi")
   String urlSearchUserApi();

   @Key("urlDoRegisterApi")
   String urlDoRegisterApi();

}
