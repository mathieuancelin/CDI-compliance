package org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer;

import javax.inject.Inject;
import org.jboss.weld.compliance.api.Test;
import org.jboss.weld.compliance.exception.ComplianceException;
import org.jboss.weld.compliance.impl.scenarios.producer.util.FieldProducedClass;
import org.jboss.weld.compliance.impl.scenarios.producer.util.Qualified;

/**
 * Test the compliance of qualified field producer. Try to inject a qualified
 * field using a producer field of an external class.
 * @author Matthieu Clochard
 */
public class QualifiedFieldProducerTest implements Test {

    @Inject
    @Qualified
    private FieldProducedClass fieldProduced;

    @Override
    public void run() throws ComplianceException {
        if(fieldProduced == null) {
            throw new ComplianceException("the injected value was null (not produced)");
        }
        if(!fieldProduced.getName().equals("QualifiedFieldProducedClass")) {
            throw new ComplianceException("the injected value was wrong (produced elsewhere)");
        }
    }

    @Override
    public String getResult() {
        try {
            run();
        } catch (ComplianceException ex) {
            return "Qualified field producer uncompliant : " + ex.getMessage();
        }
        return "Qualified field producer compliant";
    }

}
