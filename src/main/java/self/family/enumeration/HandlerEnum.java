package self.family.enumeration;

import self.family.resolver.HttpCodeResolver;
import self.family.resolver.JSONResultResolver;

/**
 * Created by Administrator on 2015/8/23.
 */
public enum HandlerEnum {
    JSON("json", "jSONResultResolver"),
    CODE("code", "httpCodeResolver");


    private String resolverName;

    private String beanName;

    HandlerEnum(String resolverName, String beanName) {
        this.resolverName = resolverName;
        this.beanName = beanName;
    }

    public String getResolverName() {
        return resolverName;
    }

    public String getBeanName() {
        return beanName;
    }

    public static HandlerEnum getEnum(String resolverName) {
        for (HandlerEnum handlerEnum : HandlerEnum.values()) {
            if (handlerEnum.getResolverName().equalsIgnoreCase(resolverName)) {
                return handlerEnum;
            }
        }
        return null;
    }

}
