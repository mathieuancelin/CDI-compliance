package org.jboss.weld.compliance.impl.scenarios.producer;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class MyInterceptor {

    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Throwable {
        System.out.println("Avant");
        try {
        return ctx.proceed();
        } finally {
            System.out.println("Après");
        }
    }
}
