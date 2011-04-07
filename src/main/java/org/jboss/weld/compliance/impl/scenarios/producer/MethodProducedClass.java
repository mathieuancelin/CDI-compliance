package org.jboss.weld.compliance.impl.scenarios.producer;

/**
 *
 * @author Matthieu Clochard
 */
public class MethodProducedClass {

    private String name;

    public MethodProducedClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
