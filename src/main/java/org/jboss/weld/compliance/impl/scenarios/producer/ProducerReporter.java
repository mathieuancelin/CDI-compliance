package org.jboss.weld.compliance.impl.scenarios.producer;

import java.util.HashSet;
import java.util.Set;
import org.jboss.weld.compliance.api.Scenario;
import org.jboss.weld.compliance.api.Test;

/**
 * A ready to be used implementation of a Scenario about producers.
 * Report about the compliance of field and method producers in a large number
 * of various situations.
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
