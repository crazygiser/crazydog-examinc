package com.crazydog.examinc.system;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2 {
    @Value("${swagger2.package}")
    private String swagger2PackageName;

    @Bean
    public Docket buildDocket() {
        /******************************增加header中的token*****************************************/
//        ParameterBuilder tokenPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<>();
//        tokenPar.name("token").description("token").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
//        pars.add(tokenPar.build());
        /******************************增加header中的token*****************************************/

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(ApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(swagger2PackageName))
                .paths(PathSelectors.any())
                .build();
//                .globalOperationParameters(pars);//增加header中的token
    }
    private ApiInfo ApiInfo() {
        return new ApiInfoBuilder()
                .description("主要提供了图片、视频、文件等服务")
                .title("Spring Cloud恒达通用骨架多文件类型后端分布式微服务")
                .version("2.0")
                .build();
    }
}
