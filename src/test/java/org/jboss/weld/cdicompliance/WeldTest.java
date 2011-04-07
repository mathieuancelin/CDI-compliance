package org.jboss.weld.cdicompliance;

import javax.inject.Inject;
import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.weld.compliance.api.ComplianceReporter;
import org.jboss.weld.compliance.exception.ComplianceException;
import org.jboss.weld.compliance.impl.ComplianceReporterImpl;
import org.jboss.weld.compliance.impl.scenarios.producer.ProducerReporter;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.FieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.InnerClassFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.InnerClassStaticFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.QualifiedFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.QualifiedWithOtherValueFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.fieldproducer.QualifiedWithValueFieldProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.InnerClassMethodProducerTest;
import org.jboss.weld.compliance.impl.scenarios.producer.methodproducer.InnerClassStaticMethodProducerTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Matthieu Clochard
 */
@RunWith(Arquillian.class)
public class WeldTest {

    @Deployment
    public static Archive myApp() {
        JavaArchive archive = ShrinkWrap.create(JavaArchive.class)
                .addPackage(ComplianceReporter.class.getPackage())
                .addPackage(ComplianceException.class.getPackage())
                .addPackage(ComplianceReporterImpl.class.getPackage())
                .addPackage(ProducerReporter.class.getPackage())
                .addPackage(InnerClassFieldProducerTest.class.getPackage())
                .addPackage(InnerClassMethodProducerTest.class.getPackage())
                .addResource(EmptyAsset.INSTANCE, "META-INF/beans.xml");
        return archive;
    }

    @Inject
    private FieldProducerTest fieldProducerTest;

    @Test
    public void fieldProducerTest() {
        try {
            fieldProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Inject
    private QualifiedFieldProducerTest qualifiedFieldProducerTest;

    @Test
    public void qualifiedFieldProducerTest() {
        try {
            qualifiedFieldProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Inject
    private QualifiedWithValueFieldProducerTest qualifiedWithValueFieldProducerTest;
    
    @Test
    public void qualifiedWithValueFieldProducerTest() {
        try {
            qualifiedWithValueFieldProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Inject
    private QualifiedWithOtherValueFieldProducerTest qualifiedWithOtherValueFieldProducerTest;

    @Test
    public void qualifiedWithOtherValueFieldProducerTest() {
        try {
            qualifiedWithOtherValueFieldProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Inject
    private InnerClassFieldProducerTest innerClassFieldProducerTest;

    @Test
    public void innerClassFieldProducerTest() {
        try {
            innerClassFieldProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Inject
    private InnerClassStaticFieldProducerTest innerClassStaticFieldProducerTest;

    @Test
    public void innerClassStaticFieldProducerTest() {
        try {
            innerClassStaticFieldProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Inject
    private InnerClassMethodProducerTest innerClassMethodProducerTest;

    @Test
    public void innerClassMethodProducerTest() {
        try {
            innerClassMethodProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Inject
    private InnerClassStaticMethodProducerTest innerClassStaticMethodProducerTest;

    @Test
    public void innerClassStaticMethodProducerTest() {
        try {
            innerClassStaticMethodProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

}
