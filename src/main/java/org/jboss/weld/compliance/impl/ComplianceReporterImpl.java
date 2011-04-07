package org.jboss.weld.compliance.impl;

import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import org.jboss.weld.compliance.api.ComplianceReporter;
import org.jboss.weld.compliance.api.Scenario;
import org.jboss.weld.compliance.impl.scenarios.producer.ProducerReporter;

/**
 *
 * @author Matthieu Clochard
 */
public class ComplianceReporterImpl implements ComplianceReporter {

    private Set<Scenario> scenarios;

    @Inject
    public ComplianceReporterImpl() {
        scenarios = new HashSet<Scenario>();
    }

    @Override
    public String report(Scenario scenario) {
        return scenario.reportAll();
    }

    @Override
    public String reportAll() {
        if(scenarios.size() > 0) {
            String report = "";
            for(Scenario scenario : scenarios) {
                report += scenario.reportAll();
            }
            return report;
        }
        return "No scenario provided";
    }

    @Override
    public ComplianceReporterImpl add(Scenario scenario) {
        scenarios.add(scenario);
        return this;
    }

}
