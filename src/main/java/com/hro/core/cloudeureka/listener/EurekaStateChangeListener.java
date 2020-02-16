package com.hro.core.cloudeureka.listener;

import com.netflix.appinfo.InstanceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaStateChangeListener {

    private static Logger logger = LoggerFactory.getLogger(EurekaStateChangeListener.class);

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        logger.debug("<< SERVERID={}, APP_NAME={} ... is offline >>", event.getServerId(), event.getAppName());
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        logger.debug("<< INSTANCEID={}, APP_NAME={} ... is registered >>", instanceInfo.getInstanceId(), instanceInfo.getAppName());
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        logger.debug("<< SERVERID={}, APP_NAME={} ... is renewed >>", event.getServerId(), event.getAppName());
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        logger.debug("<< Register center is started ... >>");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        logger.debug("<< Eureka Server is started ... >>");
    }

}
