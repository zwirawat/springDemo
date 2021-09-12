package com.example.hibernate.configuration;

import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UndertowConfig {
    @Bean
    UndertowServletWebServerFactory undertowServletWebServerFactory(){
        UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
        /* Build customize */
        factory.addBuilderCustomizers(builder -> builder.setIoThreads(Runtime.getRuntime().availableProcessors()*2),
            builder -> builder.setWorkerThreads((Runtime.getRuntime().availableProcessors()*10))
        );
        return factory;
    }
}
