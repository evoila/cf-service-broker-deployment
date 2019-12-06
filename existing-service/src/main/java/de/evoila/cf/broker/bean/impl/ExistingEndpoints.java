package de.evoila.cf.broker.bean.impl;

import de.evoila.cf.broker.bean.ExistingEndpointBean;
import de.evoila.cf.broker.bean.ExistingEndpointsBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marco Di Martino.
 */

@ConditionalOnMissingBean(ExistingEndpointsBean.class)
@Configuration
@ConfigurationProperties(prefix="existing")
public class ExistingEndpoints implements ExistingEndpointsBean {

    private List<ExistingEndpointBean> endpoints = new ArrayList<>();

    public List<ExistingEndpointBean> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(List<ExistingEndpointBean> endpoints) {
        this.endpoints = endpoints;
    }

    public ExistingEndpointBean findByName(String name) {
        return getEndpoints().stream().filter(e -> e.getServerName().equals(name))
                .findFirst().orElse(null);
    }
}
