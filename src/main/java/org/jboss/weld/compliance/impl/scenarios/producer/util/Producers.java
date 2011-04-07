package org.jboss.weld.compliance.impl.scenarios.producer.util;

import javax.enterprise.inject.Produces;

/**
 *
 * @author Matthieu Clochard
 */
public class Producers {

    @Produces
    private FieldProducedClass fieldProducedClass = new FieldProducedClass("FieldProducedClass");
    @Produces
    @Qualified
    private FieldProducedClass qualifiedFieldProducedClass = new FieldProducedClass("QualifiedFieldProducedClass");
    @Produces
    @QualifiedWithValue(true)
    private FieldProducedClass qualifiedWithValueFieldProducedClass = new FieldProducedClass("QualifiedWithValueFieldProducedClass");
    @Produces
    @QualifiedWithValue(false)
    private FieldProducedClass qualifiedWithOtherValueFieldProducedClass = new FieldProducedClass("QualifiedWithOtherValueFieldProducedClass");
    @Produces
    @MultiQualified1
    @MultiQualified2
    private FieldProducedClass multiQualifiedFieldProducedClass = new FieldProducedClass("MultiQualifiedFieldProducedClass");

    @Produces
    private MethodProducedClass fieldProducedClass() {
        return new MethodProducedClass("MethodProducedClass");
    }

    @Produces
    @Qualified
    private MethodProducedClass qualifiedFieldProducedClass() {
        return new MethodProducedClass("QualifiedMethodProducedClass");
    }

    @Produces
    @QualifiedWithValue(true)
    private MethodProducedClass qualifiedWithValueFieldProducedClass() {
        return new MethodProducedClass("QualifiedWithValueMethodProducedClass");
    }

    @Produces
    @QualifiedWithValue(false)
    private MethodProducedClass qualifiedWithOtherValueFieldProducedClass() {
        return new MethodProducedClass("QualifiedWithOtherValueMethodProducedClass");
    }

    @Produces
    @MultiQualified1
    @MultiQualified2
    private MethodProducedClass multiQualifiedFieldProducedClass() {
        return new MethodProducedClass("MultiQualifiedMethodProducedClass");
    }
}
