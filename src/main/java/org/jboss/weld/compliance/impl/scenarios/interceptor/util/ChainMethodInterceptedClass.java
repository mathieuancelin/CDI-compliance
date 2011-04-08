package org.jboss.weld.compliance.impl.scenarios.interceptor.util;

/**
 *
 * @author Matthieu Clochard
 */
public class ChainMethodInterceptedClass {

    private String name = "ChainMethodInterceptedClass";
    private String interception1name = "";
    private String interception2name = "";

    @ChainMethodInterception
    public void intercepted() {
        if(interception1name.equals("ChainMethodInterceptor1Class")
                && interception2name.equals("ChainMethodInterceptor2Class")) {
            name = "ChainMethodInterceptedClassAfter";
        }
    }

    public String getInterception1name() {
        return interception1name;
    }

    public void setInterception1name(String interception1name) {
        this.interception1name = interception1name;
    }

    public String getInterception2name() {
        return interception2name;
    }

    public void setInterception2name(String interception2name) {
        this.interception2name = interception2name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
