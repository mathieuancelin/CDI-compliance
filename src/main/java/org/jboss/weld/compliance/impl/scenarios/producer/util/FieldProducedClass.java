package org.jboss.weld.compliance.impl.scenarios.producer.util;

/**
 *
 * @author Matthieu Clochard
 */
public class FieldProducedClass {

    private String name;

    public FieldProducedClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
