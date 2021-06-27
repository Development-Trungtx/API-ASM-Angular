package com.trungtx.poly.Config;

import com.trungtx.poly.Dto.ProductDto;
import com.trungtx.poly.Repository.OrderRepositoryExample;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.trungtx.poly.Controller"})
public class ApplicationConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public OrderRepositoryExample orderRepositoryExample() {
        return new OrderRepositoryExample();
    }
}
