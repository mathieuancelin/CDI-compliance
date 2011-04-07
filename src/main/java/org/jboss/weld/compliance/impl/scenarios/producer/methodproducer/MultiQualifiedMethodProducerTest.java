package org.jboss.weld.compliance.impl.scenarios.producer.methodproducer;

import javax.inject.Inject;
import org.jboss.weld.compliance.api.Test;
import org.jboss.weld.compliance.exception.ComplianceException;
import org.jboss.weld.compliance.impl.scenarios.producer.MethodProducedClass;
import org.jboss.weld.compliance.impl.scenarios.producer.MultiQualified1;
import org.jboss.weld.compliance.impl.scenarios.producer.MultiQualified2;

/**
 *
 * @author Matthieu Clochard
 */
public class MultiQualifiedMethodProducerTest implements Test {

    @Inject
    @MultiQualified1
    @MultiQualified2
    private MethodProducedClass fieldProduced;

    @Override
    public void run() throws ComplianceException {
        if(fieldProduced == null) {
            throw new ComplianceException("the injected value was null (not produced)");
        }
        if(!fieldProduced.getName().equals("MultiQualifiedMethodProducedClass")) {
            throw new ComplianceException("the injected value was wrong (produced elsewhere)");
        }
    }

    @Override
    public String getResult() {
        try {
            run();
        } catch (ComplianceException ex) {
            return "Multiqualified method producer uncompliant : " + ex.getMessage();
        }
        return "Multiqualified method producer compliant";
    }

}
