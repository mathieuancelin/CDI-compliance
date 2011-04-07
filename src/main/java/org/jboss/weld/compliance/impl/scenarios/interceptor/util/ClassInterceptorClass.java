package org.jboss.weld.compliance.impl.scenarios.interceptor.util;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Matthieu Clochard
 */
@Interceptor
@ClassInterception
public class ClassInterceptorClass {

    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {
        if(ctx.getMethod().getName().equals("intercepted")
                || ctx.getMethod().getName().equals("intercepted2")) {
            ClassInterceptedClass target = (ClassInterceptedClass) ctx.getTarget();
            if (target.getName().equals("ClassInterceptedClass")) {
                target.setInterception1name("ClassInterceptorClass");
            } else if (target.getName().equals("ClassInterceptedClassI1After")) {
                target.setInterception2name("ClassInterceptorClass");
            }
        }
        return ctx.proceed();
    }

}
