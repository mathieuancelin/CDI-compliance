package org.jboss.weld.compliance.impl.scenarios.decorator;

import java.util.ArrayList;
import javax.inject.Inject;
import org.jboss.weld.compliance.api.Test;
import org.jboss.weld.compliance.impl.AbstractScenarioReporter;

/**
 *
 * @author Matthieu Clochard
 */
public class DecoratorReporter extends AbstractScenarioReporter {

    @Inject
    public DecoratorReporter() {
        tests = new ArrayList<Test>();
    }

}
