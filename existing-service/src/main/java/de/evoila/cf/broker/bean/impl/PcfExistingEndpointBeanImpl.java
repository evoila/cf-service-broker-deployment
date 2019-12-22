package de.evoila.cf.broker.bean.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import de.evoila.cf.broker.bean.impl.ExistingEndpoint;
import de.evoila.cf.broker.model.catalog.ServerAddress;
import de.evoila.cf.broker.util.ObjectMapperUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yannic Remmet, Johannes Hiemer.
 */
@Profile("pcf")
@Configuration
@ConfigurationProperties(prefix = "existing.endpoint")
public class PcfExistingEndpointBeanImpl extends ExistingEndpoint {
    private String pcfHosts;

    public String getPcfHosts() {
        return pcfHosts;
    }

    public void setPcfHosts(String pcfHosts) throws IOException {
        List<String> pcfHostList = ObjectMapperUtils.getObjectMapper().readValue(pcfHosts, new TypeReference<List<String>>(){});
        for (String host : pcfHostList) {
            getHosts().add(new ServerAddress(getName(), host, getPort()));
        }

        this.pcfHosts = pcfHosts;
    }
}
