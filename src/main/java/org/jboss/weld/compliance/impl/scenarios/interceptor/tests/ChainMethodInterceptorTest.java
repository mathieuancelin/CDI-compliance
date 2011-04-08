package org.jboss.weld.compliance.impl.scenarios.interceptor.tests;

import javax.inject.Inject;
import org.jboss.weld.compliance.exception.ComplianceException;
import org.jboss.weld.compliance.impl.AbstractTest;
import org.jboss.weld.compliance.impl.scenarios.interceptor.util.ChainMethodInterceptedClass;

/**
 * Test the compliance of chained method interceptors. Try to intercept (by
 * calling it) one method (annotated with the correct InterceptorBinding) with
 * two interceptors and verify the calls order (->interceptor1->intercpetor2
 * ->business).
 * @author Matthieu Clochard
 */
public class ChainMethodInterceptorTest extends AbstractTest {

    @Inject
    private ChainMethodInterceptedClass fieldProduced;

    @Override
    public void run() throws ComplianceException {
        if(fieldProduced == null) {
            throw new ComplianceException("the injected value was null (not produced)");
        }
        if(!fieldProduced.getName().equals("ChainMethodInterceptedClass")) {
            throw new ComplianceException("the injected value was wrong (produced elsewhere)");
        }
        fieldProduced.intercepted();
        if(!fieldProduced.getName().equals("ChainMethodInterceptedClassAfter")) {
            throw new ComplianceException("the first interception went wrong (intercepted method never called or too soon)");
        }
        if(!fieldProduced.getInterception1name().equals("ChainMethodInterceptor1Class")) {
            throw new ComplianceException("the interception went wrong (first interceptor never called)");
        }
        if(!fieldProduced.getInterception2name().equals("ChainMethodInterceptor2Class")) {
            throw new ComplianceException("the interception went wrong (second interceptor never called)");
        }
    }

}
