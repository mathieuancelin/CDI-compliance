package org.jboss.weld.compliance.impl.scenarios.decorator;

import java.util.ArrayList;
import javax.inject.Inject;
import org.jboss.weld.compliance.api.Test;
import org.jboss.weld.compliance.impl.AbstractScenarioReporter;
import org.jboss.weld.compliance.impl.scenarios.decorator.tests.DecoratedTest;

/**
 *
 * @author Matthieu Clochard
 */
public class DecoratorReporter extends AbstractScenarioReporter {

    @Inject
    public DecoratorReporter(DecoratedTest t1) {
        tests = new ArrayList<Test>();
        tests.add(t1);
    }

}
