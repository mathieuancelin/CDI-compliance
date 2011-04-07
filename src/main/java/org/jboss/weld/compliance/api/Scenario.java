package org.jboss.weld.compliance.api;

/**
 *
 * @author Matthieu Clochard
 */
public interface Scenario {
    String report(Test test);
    String reportAll();
    Scenario add(Test test);
}
