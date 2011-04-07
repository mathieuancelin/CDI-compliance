package org.jboss.weld.compliance.impl.scenarios.interceptor.util;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Matthieu Clochard
 */
@Interceptor
@ValuedMethodInterception(false)
public class ValuedMethodInterceptor2Class {

    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {
        ValuedMethodInterceptedClass target = (ValuedMethodInterceptedClass) ctx.getTarget();
        if (target.getName().equals("ValuedMethodInterceptedClassI1After")) {
            target.setInterception2name("ValuedMethodInterceptor2Class");
        }
        return ctx.proceed();
    }

}
