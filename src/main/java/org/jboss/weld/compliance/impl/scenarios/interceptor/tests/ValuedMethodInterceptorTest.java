package org.jboss.weld.compliance.impl.scenarios.interceptor.tests;

import javax.inject.Inject;
import org.jboss.weld.compliance.api.Test;
import org.jboss.weld.compliance.exception.ComplianceException;
import org.jboss.weld.compliance.impl.scenarios.interceptor.util.ValuedMethodInterceptedClass;

/**
 * Test the compliance of valued method interceptor. Try to intercept (by
 * calling them) two methods (annotated with the same InterceptorBinding but
 * with two different values) in a row and verify the calls result.
 * @author Matthieu Clochard
 */
public class ValuedMethodInterceptorTest implements Test {

    @Inject
    private ValuedMethodInterceptedClass fieldProduced;

    @Override
    public void run() throws ComplianceException {
        if(fieldProduced == null) {
            throw new ComplianceException("the injected value was null (not produced)");
        }
        if(!fieldProduced.getName().equals("ValuedMethodInterceptedClass")) {
            throw new ComplianceException("the injected value was wrong (produced elsewhere)");
        }
        fieldProduced.intercepted();
        if(!fieldProduced.getName().equals("ValuedMethodInterceptedClassI1After")) {
            throw new ComplianceException("the first interception went wrong (intercepted method never called or too soon)");
        }
        if(!fieldProduced.getInterception1name().equals("ValuedMethodInterceptor1Class")) {
            throw new ComplianceException("the first interception went wrong (interceptor never called)");
        }
        if(!fieldProduced.getInterception2name().equals("")) {
            throw new ComplianceException("the first interception went wrong (second interceptor was called)");
        }
        fieldProduced.intercepted2();
        if(!fieldProduced.getName().equals("ValuedMethodInterceptedClassI2After")) {
            throw new ComplianceException("the second interception went wrong (intercepted method never called or too soon)");
        }
        if(!fieldProduced.getInterception1name().equals("ValuedMethodInterceptor1Class")) {
            throw new ComplianceException("the second interception went wrong (how's that possible ?)");
        }
        if(!fieldProduced.getInterception2name().equals("ValuedMethodInterceptor2Class")) {
            throw new ComplianceException("the second interception went wrong (interceptor never called)");
        }
    }

    @Override
    public String getResult() {
        try {
            run();
        } catch (ComplianceException ex) {
            return getClass().getSimpleName() + " UNCOMPLIANT : " + ex.getMessage();
        }
        return getClass().getSimpleName() + " COMPLIANT";
    }

}
