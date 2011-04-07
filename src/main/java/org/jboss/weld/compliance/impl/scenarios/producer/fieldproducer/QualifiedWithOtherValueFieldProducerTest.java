package org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer;

import javax.inject.Inject;
import org.jboss.weld.compliance.api.Test;
import org.jboss.weld.compliance.exception.ComplianceException;
import org.jboss.weld.compliance.impl.scenarios.producer.FieldProducedClass;
import org.jboss.weld.compliance.impl.scenarios.producer.QualifiedWithValue;

/**
 *
 * @author Matthieu Clochard
 */
public class QualifiedWithOtherValueFieldProducerTest implements Test {

    @Inject
    @QualifiedWithValue(false)
    private FieldProducedClass fieldProduced;

    @Override
    public void run() throws ComplianceException {
        if(fieldProduced == null) {
            throw new ComplianceException("the injected value was null (not produced)");
        }
        if(!fieldProduced.getName().equals("QualifiedWithOtherValueFieldProducedClass")) {
            throw new ComplianceException("the injected value was wrong (produced elsewhere)");
        }
    }

    @Override
    public String getResult() {
        try {
            run();
        } catch (ComplianceException ex) {
            return "Qualified with other value field producer uncompliant : " + ex.getMessage();
        }
        return "Qualified with other value field producer compliant";
    }

}
