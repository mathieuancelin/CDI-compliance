package org.jboss.weld.compliance.impl.scenarios.producer.methodproducer;

import javax.inject.Inject;
import org.jboss.weld.compliance.api.Test;
import org.jboss.weld.compliance.exception.ComplianceException;
import org.jboss.weld.compliance.impl.scenarios.producer.MethodProducedClass;
import org.jboss.weld.compliance.impl.scenarios.producer.Qualified;

/**
 *
 * @author Matthieu Clochard
 */
public class QualifiedMethodProducerTest implements Test {

    @Inject
    @Qualified
    private MethodProducedClass fieldProduced;

    @Override
    public void run() throws ComplianceException {
        if(fieldProduced == null) {
            throw new ComplianceException("the injected value was null (not produced)");
        }
        if(!fieldProduced.getName().equals("QualifiedMethodProducedClass")) {
            throw new ComplianceException("the injected value was wrong (produced elsewhere)");
        }
    }

    @Override
    public String getResult() {
        try {
            run();
        } catch (ComplianceException ex) {
            return "Qualified method producer uncompliant : " + ex.getMessage();
        }
        return "Qualified method producer compliant";
    }

}
