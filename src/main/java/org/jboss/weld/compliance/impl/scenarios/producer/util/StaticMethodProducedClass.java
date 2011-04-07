package org.jboss.weld.compliance.impl.scenarios.producer.util;

/**
 *
 * @author Matthieu Clochard
 */
public class StaticMethodProducedClass {

    private String name;

    public StaticMethodProducedClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
