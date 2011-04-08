package org.jboss.weld.compliance.impl.scenarios.decorator.util;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class DecoratorClass implements Decorated {

    @Inject
    @Delegate
    @Any
    Decorated decorated;

    @Override
    public void decorate() {
        if(decorated.getName().equals("DecoratedClass")) {
            decorated.setDecoratorName("DecoratorClass");
            decorated.decorate();
        }
    }
}
