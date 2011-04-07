package org.jboss.weld.compliance.impl.scenarios.producer;

import java.util.HashSet;
import java.util.Set;
import org.jboss.weld.compliance.api.Scenario;
import org.jboss.weld.compliance.api.Test;

/**
 *
 * @author Matthieu Clochard
 */
public class ProducerReporter implements Scenario {

    private Set<Test> tests;

    public ProducerReporter() {
        tests = new HashSet<Test>();
    }

    @Override
    public String report(Test test) {
        return test.getResult();
    }

    @Override
    public String reportAll() {
        if(tests.size() > 0) {
            String report = "";
            for(Test test : tests) {
                report += test.getResult();
                report += System.getProperty("line.separator");
            }
            return report;
        }
        return "No test provided";
    }

    @Override
    public Scenario add(Test test) {
        tests.add(test);
        return this;
    }

}
