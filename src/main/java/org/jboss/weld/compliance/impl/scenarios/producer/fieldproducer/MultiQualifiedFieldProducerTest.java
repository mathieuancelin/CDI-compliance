package org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer;

import javax.inject.Inject;
import org.jboss.weld.compliance.api.Test;
import org.jboss.weld.compliance.exception.ComplianceException;
import org.jboss.weld.compliance.impl.scenarios.producer.FieldProducedClass;
import org.jboss.weld.compliance.impl.scenarios.producer.MultiQualified1;
import org.jboss.weld.compliance.impl.scenarios.producer.MultiQualified2;

/**
 *
 * @author Matthieu Clochard
 */
public class MultiQualifiedFieldProducerTest implements Test {

    @Inject
    @MultiQualified1
    @MultiQualified2
    private FieldProducedClass fieldProduced;

    @Override
    public void run() throws ComplianceException {
        if(fieldProduced == null) {
            throw new ComplianceException("the injected value was null (not produced)");
        }
        if(!fieldProduced.getName().equals("MultiQualifiedFieldProducedClass")) {
            throw new ComplianceException("the injected value was wrong (produced elsewhere)");
        }
    }

    @Override
    public String getResult() {
        try {
            run();
        } catch (ComplianceException ex) {
            return "Multiqualified field producer uncompliant : " + ex.getMessage();
        }
        return "Multiqualified field producer compliant";
    }

}
