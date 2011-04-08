package org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.jboss.weld.compliance.exception.ComplianceException;
import org.jboss.weld.compliance.impl.AbstractTest;

/**
 * Test the compliance of autoproduced inner class. Try to inject an inner class
 * typed field using a static producer field of this class.
 * @author Matthieu Clochard
 */
public class InnerClassStaticFieldProducerTest extends AbstractTest {

    @Produces
    static private StaticFieldProducerTestClass produce = new StaticFieldProducerTestClass(InnerClassStaticFieldProducerTest.class.getSimpleName());

    @Inject
    StaticFieldProducerTestClass fieldProduced;

    @Override
    public void run() throws ComplianceException {
        if(fieldProduced == null) {
            throw new ComplianceException("the injected value was null (not produced)");
        }
        if(!fieldProduced.getName().equals(getClass().getSimpleName())) {
            throw new ComplianceException("the injected value was wrong (produced elsewhere)");
        }
    }

    static private class StaticFieldProducerTestClass {
        private String name;

        public StaticFieldProducerTestClass(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
