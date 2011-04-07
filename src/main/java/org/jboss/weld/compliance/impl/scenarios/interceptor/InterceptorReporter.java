package org.jboss.weld.compliance.impl.scenarios.interceptor;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jboss.weld.compliance.api.Scenario;
import org.jboss.weld.compliance.api.Test;
import org.jboss.weld.compliance.impl.scenarios.interceptor.tests.ClassInterceptorTest;
import org.jboss.weld.compliance.impl.scenarios.interceptor.tests.MethodInterceptorTest;
import org.jboss.weld.compliance.impl.scenarios.interceptor.tests.ValuedMethodInterceptorTest;

/**
 *
 * @author Matthieu Clochard
 */
public class InterceptorReporter implements Scenario {

    private List<Test> tests;

    @Inject
    public InterceptorReporter(ClassInterceptorTest t1,
            MethodInterceptorTest t2,
            ValuedMethodInterceptorTest t3) {
        tests = new ArrayList<Test>();
        tests.add(t1);
        tests.add(t2);
        tests.add(t3);
    }

    @Override
    public String report(Test test) {
        return test.getResult();
    }

    @Override
    public String reportAll() {
        String report = "INTERCEPTOR##########################################";
        report += System.getProperty("line.separator");
        if(tests.size() > 0) {
            for(Test test : tests) {
                report += test.getResult();
                report += System.getProperty("line.separator");
            }
            return report;
        }
        report += "No test provided";
        report += System.getProperty("line.separator");
        return report;
    }

    @Override
    public Scenario add(Test test) {
        tests.add(test);
        return this;
    }
}
