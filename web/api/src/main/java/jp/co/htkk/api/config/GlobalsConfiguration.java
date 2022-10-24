package jp.co.htkk.api.config;

import jp.co.htkk.framework.util.SpringServiceManager;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class GlobalsConfiguration {

    private static final String API_ENDPOINT = "endpoint.yml";

    @Bean
    public static PropertySourcesPlaceholderConfigurer endpointConfigurer() {
        PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource(API_ENDPOINT));
        placeholderConfigurer.setProperties(yaml.getObject());
        return placeholderConfigurer;
    }

    @Bean
    public SpringServiceManager getSpringServiceManager() {
        return new SpringServiceManager();
    }

}