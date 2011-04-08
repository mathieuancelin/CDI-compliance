package org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer;

import javax.inject.Inject;
import org.jboss.weld.compliance.exception.ComplianceException;
import org.jboss.weld.compliance.impl.AbstractTest;
import org.jboss.weld.compliance.impl.scenarios.producer.util.MultiQualified1;
import org.jboss.weld.compliance.impl.scenarios.producer.util.MultiQualified2;
import org.jboss.weld.compliance.impl.scenarios.producer.util.StaticFieldProducedClass;

/**
 * Test the compliance of multiqualified field producer. Try to inject a
 * multiqualified field using a static producer field of an external class.
 * @author Matthieu Clochard
 */
public class MultiQualifiedStaticFieldProducerTest extends AbstractTest {

    @Inject
    @MultiQualified1
    @MultiQualified2
    private StaticFieldProducedClass fieldProduced;

    @Override
    public void run() throws ComplianceException {
        if(fieldProduced == null) {
            throw new ComplianceException("the injected value was null (not produced)");
        }
        if(!fieldProduced.getName().equals("MultiQualifiedStaticFieldProducedClass")) {
            throw new ComplianceException("the injected value was wrong (produced elsewhere)");
        }
    }

}
