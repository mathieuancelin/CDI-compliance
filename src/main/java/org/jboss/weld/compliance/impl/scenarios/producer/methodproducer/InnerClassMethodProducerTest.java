package org.jboss.weld.compliance.impl.scenarios.producer.methodproducer;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.jboss.weld.compliance.api.Test;
import org.jboss.weld.compliance.exception.ComplianceException;

/**
 * Test the compliance of autoproduced inner class. Try to inject an inner class
 * typed field using a producer method of this class.
 * @author Matthieu Clochard
 */
public class InnerClassMethodProducerTest implements Test {

    @Produces
    private MethodProducerTestClass produce() {
        return new MethodProducerTestClass(getClass().getSimpleName());
    }

    @Inject
    MethodProducerTestClass fieldProduced;

    @Override
    public void run() throws ComplianceException {
        if(fieldProduced == null) {
            throw new ComplianceException("the injected value was null (not produced)");
        }
        if(!fieldProduced.getName().equals(getClass().getSimpleName())) {
            throw new ComplianceException("the injected value was wrong (produced elsewhere)");
        }
    }

    @Override
    public String getResult() {
        try {
            run();
        } catch (ComplianceException ex) {
            return "Autoproduced inner class using method producer uncompliant : " + ex.getMessage();
        }
        return "Autoproduced inner class using method producer compliant";
    }

    private class MethodProducerTestClass {
        private String name;

        public MethodProducerTestClass(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}