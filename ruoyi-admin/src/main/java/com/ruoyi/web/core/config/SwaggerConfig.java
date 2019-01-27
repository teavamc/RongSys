package com.ruoyi.web.core.config;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2的接口配置
 * 
 * @author ruoyi
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig
{

    // 定义分隔符,配置Swagger多包
    private static final String splitor = ";";

    /**
     * 创建API
     */
    @Bean
    public Docket createRestApi()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                // 详细定制
                .apiInfo(apiInfo())
                .select()
                // 指定当前包路径
                .apis(basePackage("com.ruoyi.api.controller.broad"+splitor+"com.ruoyi.api.controller.village"))
                // 扫描所有 .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 添加摘要信息
     */
    private ApiInfo apiInfo()
    {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                .title("融媒体管理系统_接口文档")
                .description("用于融媒体系统开发组生成RESTapi风格的接口...")
//                .contact(new Contact(Global.getName(), null, null))
//                .version("版本号:" + Global.getVersion())
                .build();
    }


    /**
        * 重写basePackage方法，使能够实现多包访问
        * @author 张超 teavamc
        * @date 2019/1/26
        * @param [basePackage]
        * @return com.google.common.base.Predicate<springfox.documentation.RequestHandler>
        */
    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage)     {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage.split(splitor)) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }
}
