package org.jboss.weld.compliance.impl.scenarios.producer;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jboss.weld.compliance.api.Scenario;
import org.jboss.weld.compliance.api.Test;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.FieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.InnerClassFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.InnerClassStaticFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.MultiQualifiedFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.MultiQualifiedStaticFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.QualifiedFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.QualifiedStaticFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.QualifiedWithOtherValueFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.QualifiedWithOtherValueStaticFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.QualifiedWithValueFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.QualifiedWithValueStaticFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.StaticFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.InnerClassMethodProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.InnerClassStaticMethodProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.MethodProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.MultiQualifiedMethodProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.MultiQualifiedStaticMethodProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.QualifiedMethodProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.QualifiedStaticMethodProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.QualifiedWithOtherValueMethodProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.QualifiedWithOtherValueStaticMethodProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.QualifiedWithValueMethodProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.QualifiedWithValueStaticMethodProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.StaticMethodProducerTest;

/**
 * A ready to be used implementation of a Scenario about producers.
 * Report about the compliance of field and method producers in a large number
 * of various situations.
 * @author Matthieu Clochard
 */
public class ProducerReporter implements Scenario {

    private List<Test> tests;

    @Inject
    public ProducerReporter(FieldProducerTest t1,
            QualifiedFieldProducerTest t2,
            QualifiedWithValueFieldProducerTest t3,
            QualifiedWithOtherValueFieldProducerTest t4,
            MultiQualifiedFieldProducerTest t5,
            StaticFieldProducerTest t6,
            QualifiedStaticFieldProducerTest t7,
            QualifiedWithValueStaticFieldProducerTest t8,
            QualifiedWithOtherValueStaticFieldProducerTest t9,
            MultiQualifiedStaticFieldProducerTest t10,
            InnerClassFieldProducerTest t11,
            InnerClassStaticFieldProducerTest t12,
            MethodProducerTest t13,
            QualifiedMethodProducerTest t14,
            QualifiedWithValueMethodProducerTest t15,
            QualifiedWithOtherValueMethodProducerTest t16,
            MultiQualifiedMethodProducerTest t17,
            StaticMethodProducerTest t18,
            QualifiedStaticMethodProducerTest t19,
            QualifiedWithValueStaticMethodProducerTest t20,
            QualifiedWithOtherValueStaticMethodProducerTest t21,
            MultiQualifiedStaticMethodProducerTest t22,
            InnerClassMethodProducerTest t23,
            InnerClassStaticMethodProducerTest t24) {
        tests = new ArrayList<Test>();
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
        tests.add(t15);
        tests.add(t16);
        tests.add(t17);
        tests.add(t18);
        tests.add(t19);
        tests.add(t20);
        tests.add(t21);
        tests.add(t22);
        tests.add(t23);
        tests.add(t24);
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
