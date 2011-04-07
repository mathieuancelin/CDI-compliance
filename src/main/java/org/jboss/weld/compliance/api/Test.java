package org.jboss.weld.compliance.api;

import org.jboss.weld.compliance.exception.ComplianceException;

/**
 * A test on CDI (JSR-299). Run a test on a functionnality.
 * This test may be injectable in order to be used by a Scenario.
 * @author Matthieu Clochard
 */
public interface Test {
    /**
     * Run the test about the current functionnality.
     * @throws ComplianceException if the test failed with the corresponding
     * fail message.
     */
    void run() throws ComplianceException;
    /**
     * Run the test and provide a result message.
     * @return a report about the success or the faillure of the test.
     */
    String getResult();
}
