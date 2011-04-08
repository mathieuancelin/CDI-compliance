package org.jboss.weld.compliance.impl;

import java.util.List;
import org.jboss.weld.compliance.api.Scenario;
import org.jboss.weld.compliance.api.Test;

/**
 * An abstract implementation of Scenario used by the provided scenarii.
 * Set the report format and the storage of tests.
 * @author Matthieu Clochard
 */
public abstract class AbstractScenarioReporter implements Scenario {
    
    protected List<Test> tests;

    @Override
    public String report(Test test) {
        return test.getResult();
    }

    @Override
    public String reportAll() {
        String report = "# " + getClass().getSimpleName().toUpperCase() + " : ";
        report += System.getProperty("line.separator");
        if(tests.size() > 0) {
            for(Test test : tests) {
                report += "    # " + test.getResult();
                report += System.getProperty("line.separator");
            }
            return report;
        }
        report += "    # No test provided";
        report += System.getProperty("line.separator");
        return report;
    }

    @Override
    public Scenario add(Test test) {
        tests.add(test);
        return this;
    }

}
