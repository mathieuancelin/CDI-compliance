package org.jboss.weld.compliance.impl.scenarios.producer.methodproducer;

import javax.inject.Inject;
import org.jboss.weld.compliance.exception.ComplianceException;
import org.jboss.weld.compliance.impl.AbstractTest;
import org.jboss.weld.compliance.impl.scenarios.producer.util.MethodProducedClass;

/**
 * Test the compliance of simple method producer. Try to inject a field using a
 * producer method of an external class.
 * @author Matthieu Clochard
 */
public class MethodProducerTest extends AbstractTest {

    @Inject
    private MethodProducedClass fieldProduced;

    @Override
    public void run() throws ComplianceException {
        if(fieldProduced == null) {
            throw new ComplianceException("the injected value was null (not produced)");
        }
        if(!fieldProduced.getName().equals("MethodProducedClass")) {
            throw new ComplianceException("the injected value was wrong (produced elsewhere)");
        }
    }

}
