package meione.util;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author Milo on 2022/4/24.
 * @description
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext context)
            throws BeansException {
        SpringContextUtil.context = context;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static Object getBean(String beanId) throws BeansException {
        return context.getBean(beanId);
    }

    // 国际化使用
    public static String getMessage(String key) {
        return context.getMessage(key, null, Locale.getDefault());
    }

    // 获取当前环境
    public static String getActiveProfile() {
        return context.getEnvironment().getActiveProfiles()[0];
    }
}