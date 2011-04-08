package org.jboss.weld.compliance.impl.scenarios.interceptor.util;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Matthieu Clochard
 */
@Interceptor
@ChainMethodInterception
public class ChainMethodInterceptor1Class {

    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {
        ChainMethodInterceptedClass target = (ChainMethodInterceptedClass) ctx.getTarget();
        if (target.getName().equals("ChainMethodInterceptedClass")) {
            target.setInterception1name("ChainMethodInterceptor1Class");
        }
        return ctx.proceed();
    }

}
