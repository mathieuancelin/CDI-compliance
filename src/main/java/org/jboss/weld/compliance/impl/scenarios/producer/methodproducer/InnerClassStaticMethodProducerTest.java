package org.jboss.weld.compliance.impl.scenarios.producer.methodproducer;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.jboss.weld.compliance.exception.ComplianceException;
import org.jboss.weld.compliance.impl.AbstractTest;

/**
 * Test the compliance of autoproduced inner class. Try to inject an inner class
 * typed field using a static producer method of this class.
 * @author Matthieu Clochard
 */
public class InnerClassStaticMethodProducerTest extends AbstractTest {

    @Produces
    static private StaticMethodProducerTestClass produce = new StaticMethodProducerTestClass(InnerClassStaticMethodProducerTest.class.getSimpleName());

    @Inject
    StaticMethodProducerTestClass fieldProduced;

    @Override
    public void run() throws ComplianceException {
        if(fieldProduced == null) {
            throw new ComplianceException("the injected value was null (not produced)");
        }
        if(!fieldProduced.getName().equals(getClass().getSimpleName())) {
            throw new ComplianceException("the injected value was wrong (produced elsewhere)");
        }
    }

    static private class StaticMethodProducerTestClass {
        private String name;

        public StaticMethodProducerTestClass(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
