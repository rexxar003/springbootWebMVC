package programmerzamannow.webMVC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import programmerzamannow.webMVC.interceptor.SessionInterceptor;
import programmerzamannow.webMVC.resolver.partnerArgumentResolver;


@Configuration
public class MyWebConfig implements WebMvcConfigurer{
    
    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Autowired
    private partnerArgumentResolver partnerArgumentResolver;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/user/*");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(partnerArgumentResolver);
    }
}
