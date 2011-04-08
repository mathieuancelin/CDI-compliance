package org.jboss.weld.compliance.impl.scenarios.interceptor.tests;

import javax.inject.Inject;
import org.jboss.weld.compliance.exception.ComplianceException;
import org.jboss.weld.compliance.impl.AbstractTest;
import org.jboss.weld.compliance.impl.scenarios.interceptor.util.ClassInterceptedClass;

/**
 * Test the compliance of simple class interceptor. Try to intercept (by
 * calling them) two methods (which class is annotated with the correct
 * InterceptorBinding) in a row and verify the calls order (->interceptor
 * ->business).
 * @author Matthieu Clochard
 */
public class ClassInterceptorTest extends AbstractTest {

     @Inject
    private ClassInterceptedClass fieldProduced;

    @Override
    public void run() throws ComplianceException {
        if(fieldProduced == null) {
            throw new ComplianceException("the injected value was null (not produced)");
        }
        if(!fieldProduced.getName().equals("ClassInterceptedClass")) {
            throw new ComplianceException("the injected value was wrong (produced elsewhere)");
        }
        fieldProduced.intercepted();
        if(!fieldProduced.getName().equals("ClassInterceptedClassI1After")) {
            throw new ComplianceException("the first interception went wrong (intercepted method never called or too soon)");
        }
        if(!fieldProduced.getInterception1name().equals("ClassInterceptorClass")) {
            throw new ComplianceException("the first interception went wrong (interceptor never called)");
        }
        if(!fieldProduced.getInterception2name().equals("")) {
            throw new ComplianceException("the first interception went wrong (second interceptor was called)");
        }
        fieldProduced.intercepted2();
        if(!fieldProduced.getName().equals("ClassInterceptedClassI2After")) {
            throw new ComplianceException("the second interception went wrong (intercepted method never called or too soon)");
        }
        if(!fieldProduced.getInterception1name().equals("ClassInterceptorClass")) {
            throw new ComplianceException("the second interception went wrong (how's that possible ?)");
        }
        if(!fieldProduced.getInterception2name().equals("ClassInterceptorClass")) {
            throw new ComplianceException("the second interception went wrong (interceptor never called)");
        }
    }

}
