package com.briup.sports;

import com.briup.sports.config.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.*;

//@Configuration
//@EnableWebMvc
public class CorsConfig extends WebMvcConfigurationSupport {

    @Bean
    LoginInterceptor localInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("Login 拦截");
        registry.addInterceptor(localInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login/loginByPassword")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("这下应该拦截了吧");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        System.out.println("这个理swagger妈");
//        registry.addResourceHandler("/**").addResourceLocations(
//                "classpath:/static/");
//        registry.addResourceHandler("swagger-ui.html").addResourceLocations(
//                "classpath:/resources/");
//        registry.addResourceHandler("/webjars/**").addResourceLocations(
//                "classpath:/META-INF/resources/webjars/");
//        super.addResourceHandlers(registry);
//    }

//    private CorsConfiguration buildConfig() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.setAllowCredentials(true);
//        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedMethod("*");
//
//        return corsConfiguration;
//    }



    @Override
    public void addCorsMappings(CorsRegistry registry){
        System.out.println("这里有拦截妈");
        registry.addMapping("/")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowCredentials(true)
                .allowedMethods("GET","POST","DELETE","PUT")
                .maxAge(3600);

    }



}
