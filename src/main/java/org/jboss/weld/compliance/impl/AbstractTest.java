package org.jboss.weld.compliance.impl;

import org.jboss.weld.compliance.api.Test;
import org.jboss.weld.compliance.exception.ComplianceException;

/**
 * An abstract implementation of Test used by the provided tests.
 * Set the result format.
 * Uses the Test class name to format output so this name may not longer than
 * about forty characters.
 * @author Matthieu Clochard
 */
public abstract class AbstractTest implements Test {

    @Override
    public String getResult() {
        String result = getClass().getSimpleName();
        int offset = (50 - result.length());
        try {
            run();
        } catch (ComplianceException ex) {
            return getClass().getSimpleName() + " UNCOMPLIANT : " + ex.getMessage();
        }
        for(int i = offset;i > 0;i--) {
            result += " ";
        }
        result += "COMPLIANT";
        return result;
    }

}
