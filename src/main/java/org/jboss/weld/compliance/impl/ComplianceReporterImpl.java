package org.jboss.weld.compliance.impl;

import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import org.jboss.weld.compliance.api.ComplianceReporter;
import org.jboss.weld.compliance.api.Scenario;
import org.jboss.weld.compliance.impl.scenarios.decorator.DecoratorReporter;
import org.jboss.weld.compliance.impl.scenarios.interceptor.InterceptorReporter;
import org.jboss.weld.compliance.impl.scenarios.producer.ProducerReporter;

/**
 * A ready to be uses implementation of a ComplianceReporter.
 * Report about the compliance of :
 *    #Producers
 *    #Interceptors
 *    #Decorators
 * Tested & working with Weld 1.1.
 * @author Matthieu Clochard
 */
public class ComplianceReporterImpl implements ComplianceReporter {

    private Set<Scenario> scenarios;

    @Inject
    public ComplianceReporterImpl(ProducerReporter producerReporter,
            InterceptorReporter interceptorReporter,
            DecoratorReporter decoratorReporter) {
        scenarios = new HashSet<Scenario>();
        scenarios.add(producerReporter);
        scenarios.add(interceptorReporter);
        scenarios.add(decoratorReporter);
    }

    @Override
    public String report(Scenario scenario) {
        return scenario.reportAll();
    }

    @Override
    public String reportAll() {
        String report = "";
        if(scenarios.size() > 0) {
            for(Scenario scenario : scenarios) {
                report += scenario.reportAll();
            }
            return report;
        }
        report += "No scenario provided";
        return report;
    }

    @Override
    public ComplianceReporterImpl add(Scenario scenario) {
        scenarios.add(scenario);
        return this;
    }

}
