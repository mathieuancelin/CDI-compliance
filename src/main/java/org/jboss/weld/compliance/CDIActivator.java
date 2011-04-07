package org.jboss.weld.compliance;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import org.jboss.weld.compliance.impl.scenarios.producer.ProducerReporter;
import org.jboss.weld.environment.osgi.api.extension.events.BundleContainerInitialized;

@ApplicationScoped
public class CDIActivator {

    @Inject ProducerReporter prodReporter;

    public void onStartup(@Observes BundleContainerInitialized event) {
        System.out.println("\n\n###############################################");
        System.out.println(prodReporter.reportAll());
        System.out.println("###############################################\n\n");
    }
}
