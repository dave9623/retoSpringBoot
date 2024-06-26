package org.retosb.retoencorasb.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jwt", ignoreUnknownFields = false)
@Getter
@Setter
public class JwtProperties {

    private String secret;

    private int timeExpire;

    private String acceptExpire;
}
