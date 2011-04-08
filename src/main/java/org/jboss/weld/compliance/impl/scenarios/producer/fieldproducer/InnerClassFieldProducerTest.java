package org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.jboss.weld.compliance.exception.ComplianceException;
import org.jboss.weld.compliance.impl.AbstractTest;

/**
 * Test the compliance of autoproduced inner class. Try to inject an inner class
 * typed field using a producer field of this class.
 * @author Matthieu Clochard
 */
public class InnerClassFieldProducerTest extends AbstractTest {

    @Produces
    private FieldProducerTestClass produce = new FieldProducerTestClass(getClass().getSimpleName());

    @Inject
    private FieldProducerTestClass fieldProduced;

    @Override
    public void run() throws ComplianceException {
        if(fieldProduced == null) {
            throw new ComplianceException("the injected value was null (not produced)");
        }
        if(!fieldProduced.getName().equals(getClass().getSimpleName())) {
            throw new ComplianceException("the injected value was wrong (produced elsewhere)");
        }
    }

    private class FieldProducerTestClass {
        private String name;

        public FieldProducerTestClass(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
