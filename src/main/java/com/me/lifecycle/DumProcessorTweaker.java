package com.me.lifecycle;

import com.me.AccountOwner;
import jakarta.annotation.Nonnull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class DumProcessorTweaker implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory
            (@Nonnull ConfigurableListableBeanFactory beanFactory)
            throws BeansException {

        BeanDefinition definition =
                beanFactory.getBeanDefinition("dumService");
        definition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        definition.setLazyInit(true);
        definition.getPropertyValues().add("author", "BeanFactoryPostProcessor");
        definition.getPropertyValues().add("owner", AccountOwner.builder().username("Alex").build());
    }
}
