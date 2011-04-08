package org.jboss.weld.compliance.impl.scenarios.producer.methodproducer;

import javax.inject.Inject;
import org.jboss.weld.compliance.exception.ComplianceException;
import org.jboss.weld.compliance.impl.AbstractTest;
import org.jboss.weld.compliance.impl.scenarios.producer.util.Qualified;
import org.jboss.weld.compliance.impl.scenarios.producer.util.StaticMethodProducedClass;

/**
 * Test the compliance of qualified field producer. Try to inject a qualified
 * field using a static producer method of an external class.
 * @author Matthieu Clochard
 */
public class QualifiedStaticMethodProducerTest extends AbstractTest {

    @Inject
    @Qualified
    private StaticMethodProducedClass fieldProduced;

    @Override
    public void run() throws ComplianceException {
        if(fieldProduced == null) {
            throw new ComplianceException("the injected value was null (not produced)");
        }
        if(!fieldProduced.getName().equals("QualifiedStaticMethodProducedClass")) {
            throw new ComplianceException("the injected value was wrong (produced elsewhere)");
        }
    }

}
