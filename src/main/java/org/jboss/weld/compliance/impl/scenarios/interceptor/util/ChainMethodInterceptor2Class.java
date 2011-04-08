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
public class ChainMethodInterceptor2Class {

    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {
        ChainMethodInterceptedClass target = (ChainMethodInterceptedClass) ctx.getTarget();
        if (target.getName().equals("ChainMethodInterceptedClass")
                && target.getInterception1name().equals("ChainMethodInterceptor1Class")) {
            target.setInterception2name("ChainMethodInterceptor2Class");
        }
        return ctx.proceed();
    }

}
