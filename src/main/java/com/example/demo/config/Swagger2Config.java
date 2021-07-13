package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.util.UriComponentsBuilder;
import springfox.documentation.PathProvider;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.DefaultPathProvider;
import springfox.documentation.spring.web.paths.Paths;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
@ComponentScan("com.example.demo.swagger")
public class Swagger2Config {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.OAS_30)
        //.pathProvider(customPathProvider())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.example.demo.swagger"))
        .paths(PathSelectors.any())
        .build();
  }

  @Bean
  @Primary
  public PathProvider customPathProvider() {
    return new DefaultPathProvider() {
      @Override
      public String getOperationPath(String operationPath) {
        //operationPath = operationPath.replaceFirst(servletContext.getContextPath(), "/");
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("/");
        return Paths.removeAdjacentForwardSlashes(uriComponentsBuilder.path(operationPath).build().toString());
      }

      @Override
      public String getResourceListingPath(String groupName, String apiDeclaration) {
        apiDeclaration = super.getResourceListingPath(groupName, apiDeclaration);
        return apiDeclaration;
      }
    };
  }

}
