package org.jboss.weld.compliance.impl.scenarios.producer.util;

/**
 *
 * @author Matthieu Clochard
 */
public class StaticFieldProducedClass {

    private String name;

    public StaticFieldProducedClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
