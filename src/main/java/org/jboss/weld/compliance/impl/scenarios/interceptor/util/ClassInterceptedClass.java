package org.jboss.weld.compliance.impl.scenarios.interceptor.util;

/**
 *
 * @author Matthieu Clochard
 */
@ClassInterception
public class ClassInterceptedClass {

    private String name = "ClassInterceptedClass";
    private String interception1name = "";
    private String interception2name = "";

    public void intercepted() {
        if(interception1name.equals("ClassInterceptorClass")
                && interception2name.equals("")) {
            name = "ClassInterceptedClassI1After";
        }
    }

    public void intercepted2() {
        if(interception1name.equals("ClassInterceptorClass")
                && interception2name.equals("ClassInterceptorClass")) {
            name = "ClassInterceptedClassI2After";
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
