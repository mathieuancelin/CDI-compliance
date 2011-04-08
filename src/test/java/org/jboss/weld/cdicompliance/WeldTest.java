package org.jboss.weld.cdicompliance;

import javax.inject.Inject;
import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.weld.compliance.api.ComplianceReporter;
import org.jboss.weld.compliance.exception.ComplianceException;
import org.jboss.weld.compliance.impl.ComplianceReporterImpl;
import org.jboss.weld.compliance.impl.scenarios.decorator.DecoratorReporter;
import org.jboss.weld.compliance.impl.scenarios.decorator.tests.DecoratedTest;
import org.jboss.weld.compliance.impl.scenarios.decorator.util.Decorated;
import org.jboss.weld.compliance.impl.scenarios.interceptor.InterceptorReporter;
import org.jboss.weld.compliance.impl.scenarios.interceptor.tests.ChainMethodInterceptorTest;
import org.jboss.weld.compliance.impl.scenarios.interceptor.tests.ClassInterceptorTest;
import org.jboss.weld.compliance.impl.scenarios.interceptor.tests.MethodInterceptorTest;
import org.jboss.weld.compliance.impl.scenarios.interceptor.tests.ValuedMethodInterceptorTest;
import org.jboss.weld.compliance.impl.scenarios.interceptor.util.ClassInterception;
import org.jboss.weld.compliance.impl.scenarios.producer.ProducerReporter;
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
import org.jboss.weld.compliance.impl.scenarios.producer.util.FieldProducedClass;
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
                .addPackage(FieldProducerTest.class.getPackage())
                .addPackage(MethodProducerTest.class.getPackage())
                .addPackage(FieldProducedClass.class.getPackage())
                .addPackage(InterceptorReporter.class.getPackage())
                .addPackage(MethodInterceptorTest.class.getPackage())
                .addPackage(ClassInterception.class.getPackage())
                .addPackage(DecoratorReporter.class.getPackage())
                .addPackage(DecoratedTest.class.getPackage())
                .addPackage(Decorated.class.getPackage())
                .addResource("META-INF/beans.xml", "beans.xml");
//                .addManifestResource(
//						new UrlAsset( WeldTest.class.getResource( "/META-INF/beans.xml" ) ),
//						ArchivePaths.create( "beans.xml" )
//				);
//                .addResource(EmptyAsset.INSTANCE, "META-INF/beans.xml");
//        System.out.println(archive.toString(true));
        return archive;
    }

    /*
     * =========================================================================
     * FIELD PRODUCER TEST
     * =========================================================================
     */

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
    private MultiQualifiedFieldProducerTest multiQualifiedFieldProducerTest;

    @Test
    public void multiQualifiedFieldProducerTest() {
        try {
            multiQualifiedFieldProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    /*
     * =========================================================================
     * STATIC FIELD PRODUCER TEST
     * =========================================================================
     */

    @Inject
    private StaticFieldProducerTest statciFieldProducerTest;

    @Test
    public void statciFieldProducerTest() {
        try {
            statciFieldProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Inject
    private QualifiedStaticFieldProducerTest qualifiedStaticFieldProducerTest;

    @Test
    public void qualifiedStaticFieldProducerTest() {
        try {
            qualifiedStaticFieldProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Inject
    private QualifiedWithValueStaticFieldProducerTest qualifiedWithValueStaticFieldProducerTest;

    @Test
    public void qualifiedWithValueStaticFieldProducerTest() {
        try {
            qualifiedWithValueStaticFieldProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Inject
    private QualifiedWithOtherValueStaticFieldProducerTest qualifiedWithOtherValueStaticFieldProducerTest;

    @Test
    public void qualifiedWithOtherValueStaticFieldProducerTest() {
        try {
            qualifiedWithOtherValueStaticFieldProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Inject
    private MultiQualifiedStaticFieldProducerTest multiQualifiedStaticFieldProducerTest;

    @Test
    public void multiQualifiedStaticFieldProducerTest() {
        try {
            multiQualifiedStaticFieldProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    /*
     * =========================================================================
     * METHOD PRODUCER TEST
     * =========================================================================
     */

    @Inject
    private MethodProducerTest methodProducerTest;

    @Test
    public void methodProducerTest() {
        try {
            methodProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Inject
    private QualifiedMethodProducerTest qualifiedMethodProducerTest;

    @Test
    public void qualifiedMethodProducerTest() {
        try {
            qualifiedMethodProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Inject
    private QualifiedWithValueMethodProducerTest qualifiedWithValueMethodProducerTest;

    @Test
    public void qualifiedWithValueMethodProducerTest() {
        try {
            qualifiedWithValueMethodProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Inject
    private QualifiedWithOtherValueMethodProducerTest qualifiedWithOtherValueMethodProducerTest;

    @Test
    public void qualifiedWithOtherValueMethodProducerTest() {
        try {
            qualifiedWithOtherValueMethodProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Inject
    private MultiQualifiedMethodProducerTest multiQualifiedMethodProducerTest;

    @Test
    public void multiQualifiedMethodProducerTest() {
        try {
            multiQualifiedMethodProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    /*
     * =========================================================================
     * STATIC METHOD PRODUCER TEST
     * =========================================================================
     */

    @Inject
    private StaticMethodProducerTest staticMethodProducerTest;

    @Test
    public void staticMethodProducerTest() {
        try {
            staticMethodProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Inject
    private QualifiedStaticMethodProducerTest qualifiedStaticMethodProducerTest;

    @Test
    public void qualifiedStaticMethodProducerTest() {
        try {
            qualifiedStaticMethodProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Inject
    private QualifiedWithValueStaticMethodProducerTest qualifiedWithValueStaticMethodProducerTest;

    @Test
    public void qualifiedWithValueStaticMethodProducerTest() {
        try {
            qualifiedWithValueStaticMethodProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Inject
    private QualifiedWithOtherValueStaticMethodProducerTest qualifiedWithOtherValueStaticMethodProducerTest;

    @Test
    public void qualifiedWithOtherValueStaticMethodProducerTest() {
        try {
            qualifiedWithOtherValueStaticMethodProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Inject
    private MultiQualifiedStaticMethodProducerTest multiQualifiedStaticMethodProducerTest;

    @Test
    public void multiQualifiedStaticMethodProducerTest() {
        try {
            multiQualifiedStaticMethodProducerTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    /*
     * =========================================================================
     * INNER CLASS PRODUCER TEST
     * =========================================================================
     */
    
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

    /*
     * =========================================================================
     * METHOD INTERCEPTOR TEST
     * =========================================================================
     */

    @Inject
    private MethodInterceptorTest methodInterceptorTest;

    @Test
    public void methodInterceptorTest() {
        try {
            methodInterceptorTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Inject
    private ValuedMethodInterceptorTest valuedMethodInterceptorTest;

    @Test
    public void valuedMethodInterceptorTest() {
        try {
            valuedMethodInterceptorTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Inject
    private ChainMethodInterceptorTest chainMethodInterceptorTest;

    @Test
    public void chainMethodInterceptorTest() {
        try {
            chainMethodInterceptorTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    /*
     * =========================================================================
     * CLASS INTERCEPTOR TEST
     * =========================================================================
     */

    @Inject
    private ClassInterceptorTest classInterceptorTest;

    @Test
    public void classInterceptorTest() {
        try {
            classInterceptorTest.run();
        } catch (ComplianceException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    /*
     * =========================================================================
     * REPORT TEST
     * =========================================================================
     */

//    @Inject
//    ProducerReporter producerReporter;
//
//    @Test
//    public void producerReporter() {
//        System.out.println(producerReporter.reportAll());
//    }

//    @Inject
//    InterceptorReporter interceptorReporter;
//
//    @Test
//    public void interceptorReporter() {
//        System.out.println(interceptorReporter.reportAll());
//    }

    @Inject
    ComplianceReporter complianceReporter;

    @Test
    public void complianceReporter() {
        System.out.println(complianceReporter.reportAll());
    }


}
