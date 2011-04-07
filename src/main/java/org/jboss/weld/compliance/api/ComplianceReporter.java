package org.jboss.weld.compliance.api;

/**
 * A compliance reporter for CDI (JSR-299). Provides a report about the
 * compliance of the used container.
 * All added scenarii may be managed by the container (ie. injected) while they
 * are used by this reporter.
 * @author Matthieu Clochard
 */
public interface ComplianceReporter {

    /**
     * Run the scenario and get the generated report.
     * @param scenario the scenario to run.
     * @return the report about the compliance on this scenario.
     */
    String report(Scenario scenario);

    /**
     * Run all the added scenarii and get the generated report.
     * @return the report about the compliance on these scenarii.
     */
    String reportAll();

    /**
     * Add another scenario to the testing list of the reportAll() method.
     * @param scenario the Scenario to be added.
     * @return this reporter whith the added scenario.
     */
    ComplianceReporter add(Scenario scenario);
}
