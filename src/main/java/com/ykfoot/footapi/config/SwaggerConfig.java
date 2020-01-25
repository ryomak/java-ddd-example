package com.ykfoot.footapi.config;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Set;

@Profile("swagger")
@RequiredArgsConstructor
@EnableSwagger2
@Configuration
@EnableConfigurationProperties({SwaggerConfig.SwaggerProperties.class})
public class SwaggerConfig {

    private final SwaggerProperties properties;

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(properties.getTitle())
                .build();
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .protocols(properties.getProtocols())
                .host(properties.getHost())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ykfoot.footapi"))
                .build()
                .apiInfo(apiInfo());
    }

    @Data
    @ConfigurationProperties("swagger")
    public static class SwaggerProperties {
        private Set<String> protocols;
        private String title;
        private String host;

    }

}
