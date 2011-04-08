package org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer;

import javax.inject.Inject;
import org.jboss.weld.compliance.exception.ComplianceException;
import org.jboss.weld.compliance.impl.AbstractTest;
import org.jboss.weld.compliance.impl.scenarios.producer.util.FieldProducedClass;
import org.jboss.weld.compliance.impl.scenarios.producer.util.QualifiedWithValue;

/**
 * Test the compliance of qualified field producer. Try to inject a qualified
 * value discriminated field using a producer field of an external class.
 * Another class test used the same Qualifier with another value :
 * QualifiedWithValueFieldProducerTest
 * @author Matthieu Clochard
 */
public class QualifiedWithOtherValueFieldProducerTest extends AbstractTest {

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

}
