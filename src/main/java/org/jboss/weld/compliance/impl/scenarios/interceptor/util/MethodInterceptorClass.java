package org.jboss.weld.compliance.impl.scenarios.interceptor.util;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Matthieu Clochard
 */
@Interceptor
@MethodInterception
public class MethodInterceptorClass {

    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {
        MethodInterceptedClass target = (MethodInterceptedClass) ctx.getTarget();
        if (target.getName().equals("MethodInterceptedClass")) {
            target.setInterception1name("MethodInterceptorClass");
        } else if (target.getName().equals("MethodInterceptedClassI1After")) {
            target.setInterception2name("MethodInterceptorClass");
        }
        return ctx.proceed();
    }

}
