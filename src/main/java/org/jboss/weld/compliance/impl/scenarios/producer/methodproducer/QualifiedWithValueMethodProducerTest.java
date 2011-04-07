package org.jboss.weld.compliance.impl.scenarios.producer.methodproducer;

import javax.inject.Inject;
import org.jboss.weld.compliance.api.Test;
import org.jboss.weld.compliance.exception.ComplianceException;
import org.jboss.weld.compliance.impl.scenarios.producer.util.MethodProducedClass;
import org.jboss.weld.compliance.impl.scenarios.producer.util.QualifiedWithValue;

/**
 * Test the compliance of qualified field producer. Try to inject a qualified
 * value discriminated field using a producer method of an external class.
 * Another class test used the same Qualifier with another value :
 * QualifiedWithOtherValueMethodProducerTest
 * @author Matthieu Clochard
 */
public class QualifiedWithValueMethodProducerTest implements Test {

    @Inject
    @QualifiedWithValue(true)
    private MethodProducedClass fieldProduced;

    @Override
    public void run() throws ComplianceException {
        if(fieldProduced == null) {
            throw new ComplianceException("the injected value was null (not produced)");
        }
        if(!fieldProduced.getName().equals("QualifiedWithValueMethodProducedClass")) {
            throw new ComplianceException("the injected value was wrong (produced elsewhere)");
        }
    }

    @Override
    public String getResult() {
        try {
            run();
        } catch (ComplianceException ex) {
            return getClass().getSimpleName() + " UNCOMPLIANT : " + ex.getMessage();
        }
        return getClass().getSimpleName() + " COMPLIANT";
    }

}
