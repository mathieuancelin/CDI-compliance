package org.jboss.weld.compliance.exception;

/**
 * The exception throwed with a failure of a compliance Test.
 * @author Matthieu Clochard
 */
public class ComplianceException extends Exception {

    /**
     * Construct a new ComplianceException with an faillure message.
     * @param message the faillure message.
     */
    public ComplianceException(String message) {
        super(message);
    }

}
