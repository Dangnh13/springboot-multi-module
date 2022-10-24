package jp.co.htkk.api.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "aws")
@Data
public class AwsConfigurationProperties {

    private Credentials credentials;
    
    private String bucketName;

    private Smtp smtp;

    @Data
    public static class Credentials {
        private String accessKeyId;
        private String secretAccessKey;
    }

    @Data
    public static class Smtp {
        private String username;
        private String password;
    }
}