package org.jboss.weld.compliance.impl.scenarios.producer.methodproducer;

import javax.inject.Inject;
import org.jboss.weld.compliance.api.Test;
import org.jboss.weld.compliance.exception.ComplianceException;
import org.jboss.weld.compliance.impl.scenarios.producer.util.QualifiedWithValue;
import org.jboss.weld.compliance.impl.scenarios.producer.util.StaticMethodProducedClass;

/**
 * Test the compliance of qualified field producer. Try to inject a qualified
 * value discriminated field using a static producer method of an external class.
 * Another class test used the same Qualifier with another value :
 * QualifiedWithOtherValueStaticMethodProducerTest
 * @author Matthieu Clochard
 */
public class QualifiedWithValueStaticMethodProducerTest implements Test {

    @Inject
    @QualifiedWithValue(true)
    private StaticMethodProducedClass fieldProduced;

    @Override
    public void run() throws ComplianceException {
        if(fieldProduced == null) {
            throw new ComplianceException("the injected value was null (not produced)");
        }
        if(!fieldProduced.getName().equals("QualifiedWithValueStaticMethodProducedClass")) {
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
