package guru.springframework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
//need to go to GreetingServiceConfig and use @EnableConfigurationProperties
@ConstructorBinding
@ConfigurationProperties("guru")
public class ConstrictorConfig {

    private final String userName;
    private final String password;
    private final String jdbcUrl;

    public ConstrictorConfig(String userName, String password, String jdbcUrl) {
        this.userName = userName;
        this.password = password;
        this.jdbcUrl = jdbcUrl;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }
}
