package org.jboss.weld.compliance.impl.scenarios.producer.methodproducer;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.jboss.weld.compliance.api.Test;
import org.jboss.weld.compliance.exception.ComplianceException;

/**
 *
 * @author Matthieu Clochard
 */
public class InnerClassStaticMethodProducerTest implements Test {

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

    @Override
    public String getResult() {
        try {
            run();
        } catch (ComplianceException ex) {
            return "Autoproduced inner class using static method producer uncompliant : " + ex.getMessage();
        }
        return "Autoproduced inner class using static method producer compliant";
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
