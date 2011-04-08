package org.jboss.weld.compliance;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import org.jboss.weld.compliance.impl.scenarios.decorator.DecoratorReporter;
import org.jboss.weld.compliance.impl.scenarios.interceptor.InterceptorReporter;
import org.jboss.weld.compliance.impl.scenarios.producer.ProducerReporter;
import org.jboss.weld.environment.osgi.api.extension.events.BundleContainerInitialized;

@ApplicationScoped
public class OSGiRunner {

    @Inject ProducerReporter prodReporter;
    @Inject InterceptorReporter intReporter;
    @Inject DecoratorReporter decReporter;

    public void onStartup(@Observes BundleContainerInitialized event) {
        System.out.println(prodReporter.reportAll());
        System.out.println(intReporter.reportAll());
        System.out.println(decReporter.reportAll());
    }
}
