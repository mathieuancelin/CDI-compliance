package org.jboss.weld.compliance.impl.scenarios.producer;

import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import org.jboss.weld.compliance.api.Scenario;
import org.jboss.weld.compliance.api.Test;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.FieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.InnerClassFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.InnerClassStaticFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.MultiQualifiedFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.QualifiedFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.QualifiedWithOtherValueFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.QualifiedWithValueFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.InnerClassMethodProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.InnerClassStaticMethodProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.MethodProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.MultiQualifiedMethodProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.QualifiedMethodProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.QualifiedWithOtherValueMethodProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.QualifiedWithValueMethodProducerTest;

/**
 * A ready to be used implementation of a Scenario about producers.
 * Report about the compliance of field and method producers in a large number
 * of various situations.
 * @author Matthieu Clochard
 */
public class ProducerReporter implements Scenario {

    private Set<Test> tests;

    @Inject
    public ProducerReporter(FieldProducerTest t1,
            QualifiedFieldProducerTest t2,
            QualifiedWithValueFieldProducerTest t3,
            QualifiedWithOtherValueFieldProducerTest t4,
            MultiQualifiedFieldProducerTest t5,
            InnerClassFieldProducerTest t6,
            InnerClassStaticFieldProducerTest t7,
            MethodProducerTest t8,
            QualifiedMethodProducerTest t9,
            QualifiedWithValueMethodProducerTest t10,
            QualifiedWithOtherValueMethodProducerTest t11,
            MultiQualifiedMethodProducerTest t12,
            InnerClassMethodProducerTest t13,
            InnerClassStaticMethodProducerTest t14) {
        tests = new HashSet<Test>();
        tests.add(t1);
        tests.add(t2);
        tests.add(t3);
        tests.add(t4);
        tests.add(t5);
        tests.add(t6);
        tests.add(t7);
        tests.add(t8);
        tests.add(t9);
        tests.add(t10);
        tests.add(t11);
        tests.add(t12);
        tests.add(t13);
        tests.add(t14);
    }

    @Override
    public String report(Test test) {
        return test.getResult();
    }

    @Override
    public String reportAll() {
        if(tests.size() > 0) {
            String report = "";
            for(Test test : tests) {
                report += test.getResult();
                report += System.getProperty("line.separator");
            }
            return report;
        }
        return "No test provided";
    }

    @Override
    public Scenario add(Test test) {
        tests.add(test);
        return this;
    }

}
