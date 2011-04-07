package org.jboss.weld.compliance.api;

/**
 * A scenario testing CDI (JSR-299). Regroups some tests about the same
 * functionality.
 * All added tests may be managed by the container (ie. injected) while they are
 * used by this scenario.
 * This scenario may be injectable in order to be used by a ComplianceReporter.
 * @author Matthieu Clochard
 */
public interface Scenario {
    /**
     * Run the test and get the generated report.
     * @param test the test to run.
     * @return the report about the compliance on this test.
     */
    String report(Test test);
    /**
     * Run all the added tests and get the generated report.
     * @return the report about the compliance on these tests.
     */
    String reportAll();
    /**
     * Add another test to the testing list of the reportAll() method.
     * @param test the Test to be added.
     * @return this scenario with the added test.
     */
    Scenario add(Test test);
}
