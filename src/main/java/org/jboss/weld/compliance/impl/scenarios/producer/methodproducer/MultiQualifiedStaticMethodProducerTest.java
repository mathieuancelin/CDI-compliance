package org.jboss.weld.compliance.impl.scenarios.producer.methodproducer;

import javax.inject.Inject;
import org.jboss.weld.compliance.api.Test;
import org.jboss.weld.compliance.exception.ComplianceException;
import org.jboss.weld.compliance.impl.scenarios.producer.util.MultiQualified1;
import org.jboss.weld.compliance.impl.scenarios.producer.util.MultiQualified2;
import org.jboss.weld.compliance.impl.scenarios.producer.util.StaticMethodProducedClass;

/**
 * Test the compliance of multiqualified field producer. Try to inject a
 * multiqualified field using a static producer method of an external class.
 * @author Matthieu Clochard
 */
public class MultiQualifiedStaticMethodProducerTest implements Test {

    @Inject
    @MultiQualified1
    @MultiQualified2
    private StaticMethodProducedClass fieldProduced;

    @Override
    public void run() throws ComplianceException {
        if(fieldProduced == null) {
            throw new ComplianceException("the injected value was null (not produced)");
        }
        if(!fieldProduced.getName().equals("MultiQualifiedStaticMethodProducedClass")) {
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
