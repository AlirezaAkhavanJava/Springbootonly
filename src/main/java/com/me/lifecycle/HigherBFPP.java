package com.me.lifecycle;

import com.me.AccountOwner;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class HigherBFPP implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(@Nonnull BeanDefinitionRegistry registry) {
        BeanDefinition beanDefinition = BeanDefinitionBuilder
                .genericBeanDefinition(SmartProcess.class)
                .addPropertyValue("accountOwner", AccountOwner.builder().username("John wick").build())
                .setLazyInit(true)
                .setPrimary(true)
                .getBeanDefinition();
        registry.registerBeanDefinition("smartProcess", beanDefinition);
    }
}
