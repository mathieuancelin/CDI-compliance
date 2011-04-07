package org.jboss.weld.compliance.impl.scenarios.interceptor.util;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Matthieu Clochard
 */
@Interceptor
@ValuedMethodInterception(true)
public class ValuedMethodInterceptor1Class {

    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {
        ValuedMethodInterceptedClass target = (ValuedMethodInterceptedClass) ctx.getTarget();
        if (target.getName().equals("ValuedMethodInterceptedClass")) {
            target.setInterception1name("ValuedMethodInterceptor1Class");
        }
        return ctx.proceed();
    }

}
