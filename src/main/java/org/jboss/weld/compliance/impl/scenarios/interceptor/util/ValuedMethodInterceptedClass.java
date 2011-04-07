package org.jboss.weld.compliance.impl.scenarios.interceptor.util;

/**
 *
 * @author Matthieu Clochard
 */
public class ValuedMethodInterceptedClass {

    private String name = "ValuedMethodInterceptedClass";
    private String interception1name = "";
    private String interception2name = "";

    @ValuedMethodInterception(true)
    public void intercepted() {
        if(interception1name.equals("ValuedMethodInterceptor1Class")) {
            name = "ValuedMethodInterceptedClassI1After";
        }
    }

    @ValuedMethodInterception(false)
    public void intercepted2() {
        if(interception2name.equals("ValuedMethodInterceptor2Class")) {
            name = "ValuedMethodInterceptedClassI2After";
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
