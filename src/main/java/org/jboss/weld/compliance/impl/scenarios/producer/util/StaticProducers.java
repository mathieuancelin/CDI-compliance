package org.jboss.weld.compliance.impl.scenarios.producer.util;

import javax.enterprise.inject.Produces;

/**
 *
 * @author Matthieu Clochard
 */
public class StaticProducers {

    @Produces
    static private StaticFieldProducedClass staticFieldProducedClass = new StaticFieldProducedClass("StaticFieldProducedClass");
    @Produces
    @Qualified
    static private StaticFieldProducedClass qualifiedStaticFieldProducedClass = new StaticFieldProducedClass("QualifiedStaticFieldProducedClass");
    @Produces
    @QualifiedWithValue(true)
    static private StaticFieldProducedClass qualifiedWithValueStaticFieldProducedClass = new StaticFieldProducedClass("QualifiedWithValueStaticFieldProducedClass");
    @Produces
    @QualifiedWithValue(false)
    static private StaticFieldProducedClass qualifiedWithOtherValueStaticFieldProducedClass = new StaticFieldProducedClass("QualifiedWithOtherValueStaticFieldProducedClass");
    @Produces
    @MultiQualified1
    @MultiQualified2
    static private StaticFieldProducedClass multiQualifiedStaticFieldProducedClass = new StaticFieldProducedClass("MultiQualifiedStaticFieldProducedClass");

    @Produces
    static private StaticMethodProducedClass StaticFieldProducedClass() {
        return new StaticMethodProducedClass("StaticMethodProducedClass");
    }

    @Produces
    @Qualified
    static private StaticMethodProducedClass qualifiedStaticFieldProducedClass() {
        return new StaticMethodProducedClass("QualifiedStaticMethodProducedClass");
    }

    @Produces
    @QualifiedWithValue(true)
    static private StaticMethodProducedClass qualifiedWithValueStaticFieldProducedClass() {
        return new StaticMethodProducedClass("QualifiedWithValueStaticMethodProducedClass");
    }

    @Produces
    @QualifiedWithValue(false)
    static private StaticMethodProducedClass qualifiedWithOtherValueStaticFieldProducedClass() {
        return new StaticMethodProducedClass("QualifiedWithOtherValueStaticMethodProducedClass");
    }

    @Produces
    @MultiQualified1
    @MultiQualified2
    static private StaticMethodProducedClass multiQualifiedStaticFieldProducedClass() {
        return new StaticMethodProducedClass("MultiQualifiedStaticMethodProducedClass");
    }

}
