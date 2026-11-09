package com.me.lifecycle;

import com.me.AccountOwner;
import jakarta.annotation.Nonnull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BeanFactoryPostProcessorImpl implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(@Nonnull BeanDefinitionRegistry registry) throws BeansException {
        BeanDefinition beanDefinition = BeanDefinitionBuilder
                .genericBeanDefinition(SmartProcess.class)
                .addPropertyValue("accountOwner", AccountOwner.builder().username("John wick").build())
                .setLazyInit(true)
                .setPrimary(true)
                .getBeanDefinition();
        registry.registerBeanDefinition("smartProcess", beanDefinition);

        BeanDefinition definition = BeanDefinitionBuilder
                .genericBeanDefinition(DumService.class)
                .addPropertyValue("owner", AccountOwner.builder().username("Bob Smith").build())
                .setScope(BeanDefinition.SCOPE_PROTOTYPE)
                .setAbstract(true)
                .setLazyInit(true)
                .setPrimary(true)
                .getBeanDefinition();
        registry.registerBeanDefinition("dumService", definition);

    }
}
