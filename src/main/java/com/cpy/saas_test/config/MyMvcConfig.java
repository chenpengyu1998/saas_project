package com.cpy.saas_test.config;

import com.cpy.saas_test.component.LoginHanderInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        registry.addViewController("/type").setViewName("type");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHanderInterceptor()).addPathPatterns("/**").excludePathPatterns("/register","/adminLogin","/admin/select","/user","/index","/logindetail","/type/select","/css/**","/js/**","/image/**","/Resources/fonts/**","/","/userRegister","/RegisterDetile");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

        super.addResourceHandlers(registry);
    }


    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer adapter = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {

                registry.addViewController("/").setViewName("index");
                registry.addViewController("/logindetail").setViewName("logindetail");
//                registry.addViewController("/inventory").setViewName("inventory");
//                registry.addViewController("/inbound").setViewName("inbound");
                registry.addViewController("/warning").setViewName("recommend");
//                registry.addViewController("/outBoud").setViewName("outBoud");
                registry.addViewController("/updatePwd").setViewName("updatePwd");
                registry.addViewController("/adminLogin").setViewName("adminLogin");
            }




            //注册拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHanderInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/index","/type/select","/logindetail","","/css/**","/js/**","/resources/**");
//
//            }
        };






        return adapter;
    }



}
