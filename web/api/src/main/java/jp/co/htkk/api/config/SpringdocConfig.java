package jp.co.htkk.api.config;


import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * Springdoc Configuration
 *
 * @author DangNH
 */
@Configuration
public class SpringdocConfig {

    @Bean
    public OpenApiCustomiser customerGlobalOpenAPICustomiser() {
        return openApi ->
            openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
                ApiResponse badRequestResponse = new ApiResponse().description("Bad request");
                ApiResponse unauthorizedResponse = new ApiResponse().description("Unauthorized");
                ApiResponse forbiddenResponse = new ApiResponse().description("Forbidden");
                ApiResponse notFoundResponse = new ApiResponse().description("Not Found");
                ApiResponse serverErrorResponse = new ApiResponse().description("Server Error");
                ApiResponses apiResponses = operation.getResponses();
                apiResponses.addApiResponse("400", badRequestResponse);
                apiResponses.addApiResponse("401", unauthorizedResponse);
                apiResponses.addApiResponse("403", forbiddenResponse);
                apiResponses.addApiResponse("404", notFoundResponse);
                apiResponses.addApiResponse("500", serverErrorResponse);
            }));
        }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("歩数計ポイント 管理API")
                        .description("")
                        .version("0.0.1-SNAPSHOT"))
                .externalDocs(new ExternalDocumentation()
                        .description("歩数計ポイント 管理API説明")
                        .url("#todo"))
                ;
    }
}