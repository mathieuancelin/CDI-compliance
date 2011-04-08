package org.jboss.weld.compliance.impl.scenarios.decorator.util;

public class DecoratedClass implements Decorated {

    private String name = "DecoratedClass";
    private String decoratorName = "";

    @Override
    public void decorate() {
        if(decoratorName.equals("DecoratorClass")) {
            name = "DecoratedClassAfter";
        }
    }

    @Override
    public String getDecoratorName() {
        return decoratorName;
    }

    @Override
    public void setDecoratorName(String decoratorName) {
        this.decoratorName = decoratorName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
