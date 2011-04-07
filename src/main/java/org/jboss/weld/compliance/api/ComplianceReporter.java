package org.jboss.weld.compliance.api;

/**
 *
 * @author Matthieu Clochard
 */
public interface ComplianceReporter {
    String report(Scenario scenario);
    String reportAll();
    ComplianceReporter add(Scenario scenario);
}
