package config;

import enums.Cities;
import enums.Countries;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("classpath:config.properties")
public interface IConfigServer extends Config {

    @Key("urlOTUS")
    String urlOTUS();

    @Key("login")
    String login();

    @Key("pwd")
    String pwd();

    @Key("country")
    Countries country();

    @Key("city")
    Cities city();

}
