package org.jboss.weld.compliance.api;

import org.jboss.weld.compliance.exception.ComplianceException;

/**
 *
 * @author Matthieu Clochard
 */
public interface Test {
    void run() throws ComplianceException;
    String getResult();
}
