package com.technokratos.config.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class DatabaseProperties {

    private final String url;
    private final String username;
    private final String password;
    private final String driverClassName;
    private final Integer poolSize;

    public DatabaseProperties(@Value("${db.url}") String url,
                              @Value("${db.hikari.max-pool-size}") Integer poolSize,
                              @Value("${db.username}") String username,
                              @Value("${db.password}") String password,
                              @Value("${db.driver.classname}") String driverClassName) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.driverClassName = driverClassName;
        this.poolSize = poolSize;
    }
}
