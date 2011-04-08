package org.jboss.weld.compliance.impl.scenarios.decorator.util;

public interface Decorated {

    void decorate();

    String getDecoratorName();

    String getName();

    void setDecoratorName(String decoratorName);

    void setName(String name);

}
