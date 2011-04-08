package org.jboss.weld.compliance.impl.scenarios.interceptor;

import java.util.ArrayList;
import javax.inject.Inject;
import org.jboss.weld.compliance.api.Test;
import org.jboss.weld.compliance.impl.AbstractScenarioReporter;
import org.jboss.weld.compliance.impl.scenarios.interceptor.tests.ChainMethodInterceptorTest;
import org.jboss.weld.compliance.impl.scenarios.interceptor.tests.ClassInterceptorTest;
import org.jboss.weld.compliance.impl.scenarios.interceptor.tests.MethodInterceptorTest;
import org.jboss.weld.compliance.impl.scenarios.interceptor.tests.ValuedMethodInterceptorTest;

/**
 *
 * @author Matthieu Clochard
 */
public final class InterceptorReporter extends AbstractScenarioReporter {

    @Inject
    public InterceptorReporter(ClassInterceptorTest t1,
            MethodInterceptorTest t2,
            ValuedMethodInterceptorTest t3,
            ChainMethodInterceptorTest t4) {
        tests = new ArrayList<Test>();
        tests.add(t1);
        tests.add(t2);
        tests.add(t3);
        tests.add(t4);
    }
    
}
