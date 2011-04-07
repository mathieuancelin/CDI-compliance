package org.jboss.weld.compliance.impl.scenarios.producer;

import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import org.jboss.weld.compliance.api.Scenario;
import org.jboss.weld.compliance.api.Test;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.FieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.InnerClassFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.InnerClassStaticFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.QualifiedFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.QualifiedWithOtherValueFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.QualifiedWithValueFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.InnerClassMethodProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.InnerClassStaticMethodProducerTest;

/**
 *
 * @author Matthieu Clochard
 */
@Interceptors({MyInterceptor.class})
public class ProducerReporter implements Scenario {

    private Set<Test> tests;

    @Inject
    public ProducerReporter(FieldProducerTest fieldProducerTest
            , QualifiedFieldProducerTest qualifiedFieldProducerTest
            , QualifiedWithValueFieldProducerTest qualifiedWithValueFieldProducerTest
            , QualifiedWithOtherValueFieldProducerTest qualifiedWithOtherValueFieldProducerTest
            , InnerClassFieldProducerTest innerClassFieldProducerTest
            , InnerClassStaticFieldProducerTest innerClassStaticFieldProducerTest
            , InnerClassMethodProducerTest innerClassMethodProducerTest
            , InnerClassStaticMethodProducerTest innerClassStaticMethodProducerTest) {
        tests = new HashSet<Test>();
        tests.add(fieldProducerTest);
        tests.add(qualifiedFieldProducerTest);
        tests.add(qualifiedWithValueFieldProducerTest);
        tests.add(qualifiedWithOtherValueFieldProducerTest);
        tests.add(innerClassFieldProducerTest);
        tests.add(innerClassStaticFieldProducerTest);
        tests.add(innerClassMethodProducerTest);
        tests.add(innerClassStaticMethodProducerTest);
    }

    public ProducerReporter() {
        tests = new HashSet<Test>();
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
